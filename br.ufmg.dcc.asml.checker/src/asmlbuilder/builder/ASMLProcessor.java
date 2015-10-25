package asmlbuilder.builder;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JarPackageFragmentRoot;

import asmlbuilder.Activator;
import asmlbuilder.classloader.ASMLClassLoader;
import asmlbuilder.constants.ASMLConstant;
import asmlbuilder.matching.MatchingVisitor;
import asmlbuilder.matching.PrintMatchingVisitor;
import asmlbuilder.validation.ValidatorVisitor;
import asmlbuilder.view.console.ASMLConsoleFactory;
import asmlbuilder.view.preferences.PreferenceConstants;
import br.ufmg.dcc.asml.ClassPathUtil;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.XtextParser;
import br.ufmg.dcc.asml.aSMLModel.ASMLModel;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class ASMLProcessor {
	static public int AUTO_BUILD = 9;
	static public int FULL_BUILD = 6;
	static public int CLEAN_BUILD = 15;
	static public int INCREMENTAL_BUILD = 10;

	private static final Logger log = Logger.getLogger(ASMLProcessor.class.getName());

	public ASMLContext getAsmlContext() {
		return asmlContext;
	}

	private ASMLContext asmlContext;
	XtextParser xtextParser = new XtextParser();
	private String path_vaccine = null;
	private boolean initialized = false;
	private boolean DESIGN_MODE;
	private boolean DEBUG;

	// private IConsoleView consoleView;

	public void printLog() {
		if (DEBUG) {
			List<ComponentInstance> componentInstances = new ArrayList<ComponentInstance>(asmlContext.getComponentInstances());

			Collections.sort(componentInstances, new Comparator<ComponentInstance>() {
				@Override
				public int compare(ComponentInstance o1, ComponentInstance o2) {
					return o1.toString().compareTo(o2.toString());
				}
			});
			for (ComponentInstance componentInstance : componentInstances) {
				log(Level.ALL, componentInstance.toString());
			}
		}
	}

	public void initialize(int kind, List<IProject> projects) {
		try {
			configuraContexto(projects.get(0));// TODO - Rever
			carregaArvoreDeComponentes(projects);
			allTokensNameConventionRecovery();
			asmlContext.clearJarMathingLoadedAll();
			for (IProject iProject : projects) {
				configuraClassLoaderEspecifico(iProject);
				limpaInstanciasDeComponetesInternos(iProject);
				allExternalComponentInstancesRecoveryInJarFiles(iProject);
				allInternalComponentInstancesRecovery(iProject);
				allInternalComponentInstancesReferencesRecovery(iProject);
			}
			matchingExternal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printEstatistica() {
		try {
			int sizeTotaComponentes = 0;
			ASMLModel asmlModelPrimario = asmlContext.getAsmlModelPrimario();
			EList<EObject> contents = asmlModelPrimario.eResource().getContents();
			log(Level.INFO, "--------------------------------------------------------------------");
			log(Level.INFO, "--------------------------------------------------------------------");
			log(Level.INFO, "--------------------------------------------------------------------");

			for (EObject eObject : contents) {
				ASMLModel asmlModel = (ASMLModel) eObject;
				List<AbstractComponent> allComponents = asmlModel.getAllComponents();
				int size = allComponents.size();
				int restrictions = 0;
				for (AbstractComponent abstractComponent : allComponents) {
					restrictions = restrictions + abstractComponent.getRestrictions().size();
				}
				log(Level.INFO, "Estatistica do componente: " + asmlModel.getName());
				log(Level.INFO, "Número de componentes: " + size);
				log(Level.INFO, "Número de restrições: " + restrictions);
				sizeTotaComponentes = sizeTotaComponentes + size;

			}
			int references = 0;
			Set<ComponentInstance> componentInstances = asmlContext.getComponentInstances();
			for (ComponentInstance componentInstance : componentInstances) {
				Set<ComponentInstanceReference> dependencies = componentInstance.getDependencies();
				references = references + dependencies.size();
			}
			log(Level.INFO, "--------------------------------------------------------------------");
			log(Level.INFO, "--------------------------------------------------------------------");
			log(Level.INFO, "--------------------------------------------------------------------");
			log(Level.INFO, "Número de componentes totais: " + sizeTotaComponentes);
			log(Level.INFO, "Número de instâncias totais:" + componentInstances.size());
			log(Level.INFO, "Número de relações totais:" + references);
			log(Level.INFO, "Número de violações totais: " + asmlContext.getViolations().size());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * private void configuraConsole() { PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() { public void run() { IWorkbenchWindow dwindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow(); IWorkbenchPage page = dwindow.getActivePage(); if (page != null) { try { consoleView = (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW); } catch (Exception pie) { // pie.printStackTrace(); } } } }); }
	 */
	private void log(Level level, String msg) {
		DEBUG = Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_DEBUG);
		if (DEBUG) {
			ASMLConsoleFactory.print(msg);
		}
	}

	public void showViolations(IProject project) {
		for (ComponentInstance componentInstance : asmlContext.getComponentInstances()) {
			if (componentInstance.getComponent() == null && !componentInstance.isExternal()) {
				if (componentInstance.getResource().exists() && componentInstance.getResource().getProject().equals(project)) {
					MarkerUtils.addMarker(componentInstance.getResource(), "Component unknown!", 1, IMarker.SEVERITY_ERROR, ASMLConstant.MARKER_TYPE);
				}
			}
		}

		for (ComponentInstance componentInstance : asmlContext.getComponentInstances()) {
			Set<ComponentInstanceReference> referencesToOthersComponentInstances = componentInstance.getDependencies();
			if (!referencesToOthersComponentInstances.isEmpty()) {
				for (ComponentInstanceReference componentInstanceReference : referencesToOthersComponentInstances) {
					if (componentInstance.getResource().exists() && componentInstance.getResource().getProject().equals(project)) {
						if (componentInstanceReference.getComponentInstanceReferenced() != null && componentInstanceReference.getComponentInstanceReferenced().getComponent() == null)
							MarkerUtils.addMarker(componentInstance.getResource(), "Referência sem componente declarado na arquitetura: " + componentInstanceReference.getComponentInstanceReferenced(), componentInstanceReference.getLineNumber(), IMarker.SEVERITY_ERROR, ASMLConstant.MARKER_TYPE);
					}
				}
			}
		}

		for (Violation violation : asmlContext.getViolations()) {// TODO: Mudar "desconhecida para uma constante, talvez criar um atributo para dizer o tipo de violação"
			if (violation.getComponentInstanceReference() != null && violation.getMessage().contains("desconhecida") && violation.getComponentInstanceReference().getComponentInstanceDependent().getComponent() == null)
				continue;
			if (violation.getResource().exists() && violation.getResource().getProject().equals(project))
				MarkerUtils.addMarker(violation.getResource(), violation.getMessage(), violation.getLineNumber(), violation.getSeverity(), ASMLConstant.MARKER_TYPE);
		}
	}

	public void allExternalComponentInstancesRecoveryInJarFiles(IProject project) throws JavaModelException {
		// IProject project = asmlContext.getJavaProject().getProject();
		IJavaProject javaProject = asmlContext.getJavaProject(project);

		Set<String> packagesNamesInASMLDefinition = asmlContext.getPackagesMathing();
		IPackageFragmentRoot[] packagesRoots = javaProject.getPackageFragmentRoots();
		for (IPackageFragmentRoot packagesRoot : packagesRoots) {
			String jarName = packagesRoot.getPath().toString();
			if (!asmlContext.isJarMathingLoaded(jarName)) {
				if (packagesRoot.getKind() == IPackageFragmentRoot.K_BINARY) {
					IJavaElement[] children = packagesRoot.getChildren();
					int i = 0;
					children:
					for (IJavaElement iJavaElement : children) {
						i++;
						if (iJavaElement instanceof IPackageFragment) {
							IPackageFragment iPackageFragment = (IPackageFragment) iJavaElement;
							String elementName = iPackageFragment.getElementName() + "";
							for (String packageName : packagesNamesInASMLDefinition) {
								String prefix = packageName.split("\\{\\?\\}")[0];
								if (prefix.endsWith(".")) {
									prefix = prefix.substring(0, prefix.length() - 1);
								}
								if (elementName.equals(packageName) || (packageName.contains("{?}") && elementName.startsWith(prefix))) {
									IClassFile[] classFiles = iPackageFragment.getClassFiles();
									for (IClassFile iClassFile : classFiles) {
										String typePath = iPackageFragment.getPath().toString() + "/" + iClassFile.getType().getFullyQualifiedName().replaceAll("\\.", "/") + ".class";
										FileInJar fileInJar = new FileInJar();
										fileInJar.setFullPath(typePath);
										ComponentInstance componentInstance = ComponentInstance.createInstance(fileInJar, true, null);
										componentInstance.setType(iClassFile.getType());
										asmlContext.addComponentInstance(componentInstance);
									}
									continue children;
								}
							}
						}
					}
				}
				asmlContext.addJarMathingLoaded(jarName);
			} else {
				// System.out.println(jarName);
			}
		}
	}

	public void allInternalComponentInstancesRecovery(IProject project) throws CoreException {
		// IProject project = asmlContext.getJavaProject().getProject();
		IPackageFragmentRoot[] packageFragmentRoots = null;
		// packageFragmentRoots = asmlContext.getJavaProject().getAllPackageFragmentRoots();
		IJavaProject javaProject = asmlContext.getJavaProject(project);
		packageFragmentRoots = javaProject.getAllPackageFragmentRoots();

		for (IPackageFragmentRoot iPackageFragmentRoot : packageFragmentRoots) {
			if (!(iPackageFragmentRoot instanceof JarPackageFragmentRoot) && iPackageFragmentRoot.getParent().getElementName().equals(project.getName())) {
				IJavaElement[] iJavaElement = iPackageFragmentRoot.getChildren();
				for (IJavaElement iJavaElement2 : iJavaElement) {
					if (iJavaElement2 instanceof IPackageFragment) {
						IPackageFragment iPackageFragment = (IPackageFragment) iJavaElement2;
						ICompilationUnit[] iCompilationUnits = iPackageFragment.getCompilationUnits();
						for (ICompilationUnit iCompilationUnit : iCompilationUnits) {
							IType iType = iCompilationUnit.getTypes()[0];
							ComponentInstance componentInstance = ComponentInstance.createInstance(iCompilationUnit.getResource(), false, null);
							componentInstance.setType(iType);
							asmlContext.addComponentInstance(componentInstance);
						}
					}
				}
			}
		}
	}

	public void allInternalComponentInstancesReferencesIncrementalRecovery(IResourceDelta delta, IProject iProject) throws CoreException {
		asmlContext.getResourceDeltaVisitor().setProject(iProject);
		delta.accept(asmlContext.getResourceDeltaVisitor());
		// allInternalComponentInstancesRecoveryNaoJava();

	}

	public void allInternalComponentInstancesReferencesRecovery(IProject iProject) throws CoreException {
		asmlContext.getResourceVisitor().setProject(iProject);
		iProject.accept(asmlContext.getResourceVisitor());
	}

	private void allTokensNameConventionRecovery() throws CoreException {
		TokensNameConventionVisitor componentRecoveryVisitor = new TokensNameConventionVisitor(asmlContext);
		Set<ASMLModel> models = new HashSet<ASMLModel>(asmlContext.getOtherAsmlModelReferenced());
		models.add(asmlContext.getAsmlModelPrimario());
		for (ASMLModel asmlModel : models) {
			EList<AbstractComponent> components = asmlModel.getComponents();
			for (AbstractComponent component : components) {
				component.accept(componentRecoveryVisitor);
			}
		}
	}

	/*
	 * private IProject inicialize(int kind) throws CoreException { IProject project =asmlContext.getJavaProject().getProject(); log.log(Level.INFO, "##################################"); try { IJavaProject javaProject = JavaCore.create(project);
	 * 
	 * configuraContexto();
	 * 
	 * carregaArvoreDeComponentes();
	 * 
	 * configuraClassLoaderEspecifico(javaProject);
	 * 
	 * limpaInstanciasDeComponetesInternos(javaProject);
	 * 
	 * } catch (Throwable e) { MarkerUtils.addMarker(project, "Projeto não vacinado! Verifique se a vaccine consta no classpath do projeto.", 1, IMarker.SEVERITY_ERROR, ASMLConstant.MARKER_TYPE); throw new CoreException(Status.CANCEL_STATUS); } return project; }
	 */
	private void configuraCaminhoDaVacina(IJavaProject javaProject) {
		if (path_vaccine == null)
			path_vaccine = ClassPathUtil.recuperaPathVaccine(javaProject);
	}

	private void configuraContexto(IProject project) {
		asmlContext = new ASMLContext();
		IJavaProject javaProject = asmlContext.getJavaProject(project);
		asmlContext.setDesignMode(DESIGN_MODE);
		// asmlContext.setJavaProject(javaProject);
		asmlContext.setReosurceJavaVisitor(new ASMLReosurceJavaVisitor(asmlContext));
		asmlContext.setResourceVisitor(new ASMLResourceVisitor(asmlContext));
		asmlContext.setResourceDeltaVisitor(new ASMLResourceDeltaVisitor(asmlContext));
		asmlContext.setPrintMatchingVisitor(new PrintMatchingVisitor(asmlContext));
		asmlContext.setMatchingVisitor(new MatchingVisitor(asmlContext));
		if (asmlContext.getClasspathMavenContainer() == null) {
			IClasspathContainer classpathMavenContainer = ClassPathUtil.recuperaMavenContainerClassPath(javaProject);
			asmlContext.setClasspathMavenContainer(classpathMavenContainer);
		}
		configuraCaminhoDaVacina(javaProject);
	}

	public void limpaInstanciasDeComponetesInternos(IProject iProject) {
		try {
			iProject.deleteMarkers(ASMLConstant.MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			ASMLModel asmlModel = asmlContext.getAsmlModel(iProject);
			if (asmlModel == null) {
				Resource eResource = asmlContext.getAsmlModelPrimario().eResource();
				String path = ClassPathUtil.recuperaPathVaccine(asmlContext.getJavaProject(iProject));
				xtextParser.addAllResourcesImported(eResource, path);
				asmlModel = asmlContext.getAsmlModel(iProject);
			} else {
				asmlContext.removeViolations(iProject);
				iProject.deleteMarkers(ASMLConstant.MARKER_TYPE, true, IResource.DEPTH_INFINITE);
				asmlContext.clearInternalsComponentInstance(iProject);
				List<AbstractComponent> allComponents = asmlModel.getComponents();
				for (AbstractComponent abstractComponent : allComponents) {
					abstractComponent.componentInstancesClearAll();// A partir da raiz limpa todos as instancias de componentes encontradas.
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao limpar instancias de componentes");
		}
	}

	private void configuraClassLoaderEspecifico(IProject iProject) {
		try {
			IJavaProject javaProject = asmlContext.getJavaProject(iProject);
			IClasspathEntry iClasspathEntryVaccine = ClassPathUtil.recuperaClassPathDaVaccina(javaProject);
			String workspacePath = javaProject.getProject().getWorkspace().getRoot().getLocation().toString();// TODO:Melhorar as duas linhas abaixo
			URL[] urls = new URL[] { new URL("file:/" + workspacePath + iClasspathEntryVaccine.getPath() + "/target/classes/") };
			asmlContext.setClassLoader(new ASMLClassLoader(urls, this.getClass().getClassLoader()));
		} catch (Throwable e) {
			throw new RuntimeException("Erro ao configurar class loader especifico");
		}
	}

	private void carregaArvoreDeComponentes(List<IProject> projects) {
		Map<String, String> paths = recoveryVaccineInfo(projects);
		Resource resourcePrimario = mergeVaccinesComponents(paths);
		associatesModelsToProjects(projects, resourcePrimario);
	}

	private void updateArvoreDeComponentes(List<IProject> projects) {
		Map<String, String> paths = recoveryVaccineInfo(projects);
		Resource resourcePrimario = mergeVaccineComponents(paths);
		associatesModelsToProjects(projects, resourcePrimario);
	}

	private void associatesModelsToProjects(List<IProject> projects, Resource resourcePrimario) {
		ASMLModel asmlModel;
		EList<EObject> contents2 = resourcePrimario.getContents();
		for (EObject eObject : contents2) {
			asmlModel = (ASMLModel) eObject;
			String name = asmlModel.getName();
			for (IProject project : projects) {
				String name2 = project.getName();
				if (name2.endsWith(name)) {
					// log.info("Encontrou jar ou porjeto maven da vaccine...:" + iClasspathEntry.getPath().toString());
					asmlModel.setProject(project);
					break;
				}
			}
		}
	}

	private Resource mergeVaccinesComponents(Map<String, String> paths) {
		int i = 0;
		Resource resourcePrimario = null;
		ASMLModel asmlModel = null;
		for (String path : paths.values()) {
			if (i == 0) {
				resourcePrimario = xtextParser.getResource(path);
				EList<EObject> contents = resourcePrimario.getContents();
				asmlModel = (ASMLModel) contents.get(0);
			} else {
				xtextParser.addAllResourcesImported(i, resourcePrimario, path);
			}
			i++;
		}
		asmlContext.setAsmlModel(asmlModel);
		return resourcePrimario;
	}

	private Resource mergeVaccineComponents(Map<String, String> paths) {
		System.out.println();
		ASMLModel asmlModelPrimario = getAsmlContext().getAsmlModelPrimario();
		Resource resourcePrimario = asmlModelPrimario.eResource();
		Set<ASMLModel> models = new LinkedHashSet<ASMLModel>(asmlContext.getOtherAsmlModelReferenced());
		models.add(asmlContext.getAsmlModelPrimario());
		Set<String> vaccineNewVaccinePaths = new LinkedHashSet<String>();
		Set<String> vaccineNames = paths.keySet();
		externalfor: for (String name : vaccineNames) {
			for (ASMLModel asmlModel : models) {
				String name2 = asmlModel.getName();
				String rawName = name.replaceFirst("vaccine-", "");
				if (name2.equals(rawName)) {
					continue externalfor;
				}
			}
			vaccineNewVaccinePaths.add(paths.get(name));
		}
		int i = resourcePrimario.getContents().size();
		for (String path : vaccineNewVaccinePaths) {
			xtextParser.addAllResourcesImported(i, resourcePrimario, path);
			i++;
		}
		asmlContext.setAsmlModel(asmlModelPrimario);
		return resourcePrimario;
	}

	private Map<String, String> recoveryVaccineInfo(List<IProject> projects) {
		Map<String, String> paths = new HashMap<String, String>();
		String vaccineName = "";
		for (IProject project : projects) {
			IJavaProject javaProject = asmlContext.getJavaProject(project);
			List<IClasspathEntry> entries = ClassPathUtil.recuperaIClasspathEntriesDaVaccina(javaProject);
			for (IClasspathEntry iClasspathEntry : entries) {
				String path = "";
				IPath vaccinaFisicalPath = iClasspathEntry.getPath();
				IClasspathAttribute iClasspathAttribute = iClasspathEntry.getExtraAttributes()[2];
				if (iClasspathAttribute != null) {
					vaccineName = iClasspathAttribute.getValue();
				} else {
					vaccineName = iClasspathEntry.getPath().lastSegment();// Projetos não maven
				}
				if (iClasspathEntry.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
					path = "jar:file:/" + vaccinaFisicalPath.toString() + "!" + "/vaccine.asml";
					paths.put(vaccineName, path);
				} else if (iClasspathEntry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
					path = "file:/" + javaProject.getProject().getWorkspace().getRoot().getLocation() + vaccinaFisicalPath + "/src/main/resources/vaccine.asml";
					paths.put(vaccineName, path);
				}
			}
		}
		return paths;
	}

	protected void clean(IProgressMonitor monitor, IProject iProject) throws CoreException {
		iProject.deleteMarkers(ASMLConstant.MARKER_TYPE, true, IResource.DEPTH_INFINITE);
	}

	public void printMatching(IProject iProject) {
		DEBUG = Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_DEBUG);
		if (DEBUG) {

			PrintMatchingVisitor printMatchingVisitor = asmlContext.getPrintMatchingVisitor();

			Set<ASMLModel> otherAsmlModelReferenced = new HashSet<ASMLModel>(asmlContext.getOtherAsmlModelReferenced());
			for (ASMLModel asmlModel : otherAsmlModelReferenced) {
				List<AbstractComponent> components = asmlModel.getComponents();
				for (AbstractComponent component : components) {
					component.accept(printMatchingVisitor);
				}
			}
			for (AbstractComponent component : asmlContext.getAsmlModel(iProject).getAllComponents()) {
				component.accept(printMatchingVisitor);
			}
		}
	}

	public void matchingInternal(Set<ComponentInstance> componentInstances, IProject iProject) {
		if (componentInstances == null) {
			componentInstances = asmlContext.getComponentInstances();
		}
		MatchingVisitor matchingVisitor = asmlContext.getMatchingVisitor();
		matchingVisitor.setComponentInstances(componentInstances);
		matchingVisitor.setInternal(true);
		ASMLModel asmlModel = asmlContext.getAsmlModel(iProject);
		for (AbstractComponent component : asmlModel.getComponents()) {
			component.accept(matchingVisitor);
		}
	}

	public void matchingExternal() {
		MatchingVisitor matchingVisitor = asmlContext.getMatchingVisitor();
		matchingVisitor.setInternal(false);
		Set<ASMLModel> otherAsmlModelReferenced = new HashSet<ASMLModel>(asmlContext.getOtherAsmlModelReferenced());
		otherAsmlModelReferenced.add(asmlContext.getAsmlModelPrimario());
		for (ASMLModel asmlModel : otherAsmlModelReferenced) {
			List<AbstractComponent> components = asmlModel.getComponents();
			for (AbstractComponent component : components) {
				component.accept(matchingVisitor);
			}
		}
	}

	public void validate(IProject iProject) {
		log(Level.INFO, "Iniciou o processo validação...");
		EList<AbstractComponent> components = asmlContext.getAsmlModel(iProject).getComponents();
		ValidatorVisitor validatorVisitor = new ValidatorVisitor(asmlContext);
		for (AbstractComponent component : components) {
			component.accept(validatorVisitor);
		}
		log(Level.INFO, "Finalizou o processo validação...");
	}

	public void fullBuild(IProject project) {
		try {
			if (getAsmlContext() != null) {
				limpaInstanciasDeComponetesInternos(project);
				allInternalComponentInstancesRecovery(project);
				allInternalComponentInstancesReferencesRecovery(project);
				matchingInternal(null, project);
				validate(project);
				showViolations(project);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro em full build", e);
		}
	}

	public void autoBuild(IResourceDelta delta, IProject project) {
		try {
			if (delta == null || getAsmlContext().getAsmlModel(project) == null) {
				List<IProject> projects = new ArrayList<IProject>();
				projects.add(project);
				updateArvoreDeComponentes(projects);
				allTokensNameConventionRecovery();
				configuraClassLoaderEspecifico(project);
				limpaInstanciasDeComponetesInternos(project);
				allInternalComponentInstancesRecovery(project);
				allInternalComponentInstancesReferencesRecovery(project);
				matchingInternal(null, project);
				matchingExternal();
				validate(project);
				showViolations(project);
			} else {
				incrementalBuild(delta, project);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro em  full  build", e);
		}
	}

	public void incrementalBuild(IResourceDelta delta, IProject project) {
		try {
			allInternalComponentInstancesReferencesIncrementalRecovery(delta, project);
			Set<ComponentInstance> componentInstances = new HashSet<ComponentInstance>();
			List<IResourceDelta> deltas = new ArrayList<IResourceDelta>();
			revoreyChildrenResources(delta, deltas);
			for (IResourceDelta iResourceDelta : deltas) {
				IResource resource = iResourceDelta.getResource();
				if (!resource.exists())
					continue;
				resource.deleteMarkers(ASMLConstant.MARKER_TYPE, true, IResource.DEPTH_INFINITE);
				getAsmlContext().removeViolations(resource);
				ComponentInstance componentInstanceByIResourceName = Activator.getAsmlProcessor().getAsmlContext().getComponentInstanceByIResourceName(resource);
				if (componentInstanceByIResourceName != null)
					componentInstances.add(componentInstanceByIResourceName);
			}
			validate(project);
			showViolations(project);
		} catch (Exception e) {
			throw new RuntimeException("Erro em incremental Build", e);
		}
		// allInternalComponentInstancesRecoveryNaoJavaIncremental(project);
	}

	private void revoreyChildrenResources(IResourceDelta delta, List<IResourceDelta> deltas) {
		IResourceDelta[] affectedChildren = delta.getAffectedChildren();
		deltas.add(delta);
		if (affectedChildren != null && affectedChildren.length > 0) {
			for (IResourceDelta iResourceDelta : affectedChildren) {
				revoreyChildrenResources(iResourceDelta, deltas);
			}
		}
	}

}

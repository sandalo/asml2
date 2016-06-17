package asmlbuilder.builder;

import java.io.FileNotFoundException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
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
import asmlbuilder.builder.Violation.DependecyType;
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
	private boolean DESIGN_MODE;
	private boolean DEBUG;

	public void printLog() {
		if (DEBUG) {
			List<ComponentInstance> componentInstances = new ArrayList<ComponentInstance>(asmlContext.getComponentInstances());
			Collections.sort(componentInstances, new Comparator<ComponentInstance>() {
				@Override
				public int compare(ComponentInstance o1, ComponentInstance o2) {
					AbstractComponent component = o1.getComponent();
					AbstractComponent component2 = o2.getComponent();
					String fullName = "";
					String fullName2 = "";

					if (component != null)
						fullName = component.getFullName();

					if (component2 != null)
						fullName2 = component2.getFullName();

					String string = fullName + " " + o1.toString();
					String string2 = fullName2 + " " + o2.toString();

					return string.compareTo(string2);
				}
			});
			String filter = Activator.getDefault().getPreferenceStore().getString(PreferenceConstants.P_DEBUG_COMPONENT_FILTER);

			AbstractComponent componentAtual = null;
			int cont = 0;
			boolean print = false;
			for (ComponentInstance componentInstance : componentInstances) {
				if (componentInstance.getComponent() != null && !componentInstance.getComponent().equals(componentAtual)) {
					componentAtual = componentInstance.getComponent();
					boolean full = filter.endsWith("*");
					String filter_sem_operador = filter.replace("*", "");
					if ((full && componentInstance.getComponent().getFullName().contains(filter_sem_operador)) || componentInstance.getComponent().getName().equals(filter_sem_operador) || "".equals(filter)) {
						print = true;
						log(Level.ALL, ++cont + ") Componente: " + componentAtual.getFullName() + " ###################################################################");
					} else
						print = false;
				}
				String msg = componentInstance.toString();
				if (print)
					log(Level.ALL, "     " + msg);
			}
		}
	}

	public void initialize(int kind, List<IProject> projects, IProgressMonitor monitor) {
		try {
			monitor.beginTask("Atualização de arquitetura: ", 5 + (5 * projects.size()));

			monitor.subTask("Configurando o contexto...");
			configuraContexto(projects.get(0));// TODO - Rever
			monitor.worked(1);

			monitor.subTask("Carregrando arvore de componentes...");
			carregaArvoreDeComponentes(projects);
			monitor.worked(1);

			monitor.subTask("Recuperando tokens(sufix, prefixo)...");
			recoveryAllTokensNameConvention();
			monitor.worked(1);

			monitor.subTask("Limpando jars carregados...");
			asmlContext.clearJarMathingLoadedAll();
			monitor.worked(1);

			for (IProject iProject : projects) {
				monitor.subTask("Configurando classloader..." + iProject.getName());
				configuraClassLoaderEspecifico(iProject);
				monitor.worked(1);

				monitor.subTask("Limpando instancias de conponentes internos..." + iProject.getName());
				limpaInstanciasDeComponetesInternos(iProject);
				monitor.worked(1);

				monitor.subTask("Carregando instancias de conponentes externos..." + iProject.getName());
				recoveryAllExternalComponentInstancesInJarFiles(iProject);
				monitor.worked(1);

				/*
				 * monitor.subTask(
				 * "Carregando instancias de conponentes internos..." +
				 * iProject.getName());
				 * recoveryAllInternalComponentInstances(iProject);
				 * monitor.worked(1);
				 * 
				 * monitor.subTask(
				 * "Carregando referências à conponentes internos..." +
				 * iProject.getName());
				 * recoveryAllInternalComponentInstancesReferences(iProject);
				 * monitor.worked(1);
				 */}
			monitor.subTask("Realizando matching...");
			matchingExternal();
			monitor.worked(1);

		} catch (Exception e) {
			Throwable cause = e.getCause();
			if (cause instanceof FileNotFoundException && cause.getMessage().contains("vaccine")) {
				throw new RuntimeException(" Arquivo da vacina não encontrado. Se estiver com o projeto da vacina aberto, verifique se o projeto da vacina se encontra no mesmo workspace do projeto alvo.");
			}
			e.printStackTrace();
			
		} finally {
			monitor.done();
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
				log(Level.INFO, "--------------------------------------------------------------------");
				log(Level.INFO, "--------------------------------------------------------------------");
				log(Level.INFO, "--------------------------------------------------------------------");
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

			List<Violation> violations = asmlContext.getViolations();
			int erros = 0, avisos = 0;
			String sql = "INSERT INTO tb_violacoes_asml(id, dependency_type, description, resource, path, line, complexity, author, exper, project, workspace, checking_data, severity, violation_type) VALUES (";
			for (Violation violation : violations) {
				if(violation.getSeverity()==IMarker.SEVERITY_ERROR)
					erros++;
				if(violation.getSeverity()==IMarker.SEVERITY_WARNING)
					avisos++;
			}
			log(Level.INFO, "Número de violações avisos: " + avisos);
			log(Level.INFO, "Número de violações erros: " + erros);
			log(Level.INFO, "Número de violações totais: " + violations.size());
			
			String message = "";
/*			for (Violation violation : violations) {
				try {
					
					Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					String[] segments = violation.getResource().getProject().getLocation().segments();
					message = violation.getMessage().replaceAll("\\\\", "");
					if(message.contains("desconhecido")|| (message.contains("inválido") && !message.contains("Componente inválido"))) {
						int indexOf = message.indexOf(";");
						if(indexOf !=-1){
							message = message.substring(0, indexOf);
						}else{
							message = message.substring(0, message.length()-1);
						}
					}
					
					log(Level.INFO, sql+" nextval('violation_sequence'),'"+violation.getDependecyType()+"','"+message
							+"','"+violation.getResource().getName()+"','"+violation.getResource().getFullPath()+"','"
							+violation.getLineNumber()+"','','','','"+violation.getResource().getProject().getName()+"','"+segments[segments.length-2]+"','"+dateFormat.format(date)+   "','" + violation.getSeverity()+   "','" + violation.getViolation_type() +"');");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
*/			
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	/*
	 * private void configuraConsole() {
	 * PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() { public
	 * void run() { IWorkbenchWindow dwindow =
	 * PlatformUI.getWorkbench().getActiveWorkbenchWindow(); IWorkbenchPage page
	 * = dwindow.getActivePage(); if (page != null) { try { consoleView =
	 * (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW); } catch
	 * (Exception pie) { // pie.printStackTrace(); } } } }); }
	 */
	private void log(Level level, String msg) {
		DEBUG = Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_DEBUG);
		if (DEBUG) {
			ASMLConsoleFactory.print(msg);
			Activator.getDefault().getLog().log(new Status(Status.INFO, Activator.PLUGIN_ID, msg));
		}
	}

	public void showViolations(IProject project) {
		if (Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_SHOW_RESTRCTION_VALIDATIONS))
			showRestrictionsViolations(project);
	}

	private void showRestrictionsViolations(IProject project) {
		for (Violation violation : asmlContext.getViolations()) {
			if (violation.getResource().exists() && violation.getResource().getProject().equals(project))
				MarkerUtils.addMarker(violation.getResource(), violation.getMessage(), violation.getLineNumber(), violation.getSeverity(), ASMLConstant.MARKER_TYPE);
		}
	}

	private void validateHierachicalViolations(IProject project) {
		for (ComponentInstance componentInstance : asmlContext.getComponentInstances()) {
			if (componentInstance.getComponent() == null && !componentInstance.isExternal()) {
				if (componentInstance.getResource().exists() && componentInstance.getResource().getProject().equals(project)) {
					String message = "Componente desconhecido!";
					asmlContext.getViolations().add(new Violation(componentInstance.getResource(), message, 1, IMarker.SEVERITY_ERROR,DependecyType.STRUCTURAL,"UNKNOWN COMPONENT"));
				}
			}
		}

		for (ComponentInstance componentInstance : asmlContext.getComponentInstances()) {
			if (componentInstance.getComponent() == null)
				continue;
			Set<ComponentInstanceReference> referencesToOthersComponentInstances = componentInstance.getDependencies();
			if (!referencesToOthersComponentInstances.isEmpty()) {
				for (ComponentInstanceReference componentInstanceReference : referencesToOthersComponentInstances) {
					if (componentInstance.getResource().exists() && componentInstance.getResource().getProject().equals(project)) {
						if (componentInstanceReference.getComponentInstanceReferenced() != null && componentInstanceReference.getComponentInstanceReferenced().getComponent() == null){
							asmlContext.getViolations().add(new Violation(componentInstance.getResource(), "Referência apontanto para um componente desconhecido(a): " + componentInstanceReference.getComponentInstanceReferenced(), componentInstanceReference.getLineNumber(), IMarker.SEVERITY_ERROR, DependecyType.STRUCTURAL, "UNKNOWN REFERENCE"));
						}else if (componentInstanceReference.getComponentInstanceReferenced() == null) {
							asmlContext.getViolations().add(new Violation(componentInstance.getResource(), "Referência apontanto para um componente desconhecido(b): " + componentInstanceReference.toString() +  componentInstanceReference.getComponentInstanceReferenced(), componentInstanceReference.getLineNumber(), IMarker.SEVERITY_ERROR, DependecyType.STRUCTURAL, "UNKNOWN REFERENCE"));
						}
					}
				}
			}
		}
	}

	public void recoveryAllExternalComponentInstancesInJarFiles(IProject project) throws JavaModelException {
		// IProject project = asmlContext.getJavaProject().getProject();
		IJavaProject javaProject = asmlContext.getJavaProject(project);

		Set<String> packagesNamesInASMLDefinition = asmlContext.getPackagesMathing();
		IPackageFragmentRoot[] packagesRoots = javaProject.getPackageFragmentRoots();
		for (IPackageFragmentRoot packagesRoot : packagesRoots) {
			String jarName = packagesRoot.getPath().toString();
			if (!asmlContext.isJarMathingLoaded(jarName)) {
				if (packagesRoot.getKind() == IPackageFragmentRoot.K_BINARY) {
					IJavaElement[] children = packagesRoot.getChildren();
					children: for (IJavaElement iJavaElement : children) {
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
										//System.out.println(jarName+" => "+componentInstance);
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

	public void recoveryAllInternalComponentInstances(IProject project) throws CoreException {
		// IProject project = asmlContext.getJavaProject().getProject();
		IPackageFragmentRoot[] packageFragmentRoots = null;
		// packageFragmentRoots =
		// asmlContext.getJavaProject().getAllPackageFragmentRoots();
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

	public void recoveryAllInternalComponentInstancesReferencesIncremental(IResourceDelta delta, IProject iProject) throws CoreException {
		asmlContext.getResourceDeltaVisitor().setProject(iProject);
		delta.accept(asmlContext.getResourceDeltaVisitor());
		// allInternalComponentInstancesRecoveryNaoJava();

	}

	public void recoveryAllInternalComponentInstancesReferences(IProject iProject) throws CoreException {
		asmlContext.getResourceVisitor().setProject(iProject);
		iProject.accept(asmlContext.getResourceVisitor());
	}

	private void recoveryAllTokensNameConvention() throws CoreException {
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
	 * private IProject inicialize(int kind) throws CoreException { IProject
	 * project =asmlContext.getJavaProject().getProject(); log.log(Level.INFO,
	 * "##################################"); try { IJavaProject javaProject =
	 * JavaCore.create(project);
	 * 
	 * configuraContexto();
	 * 
	 * carregaArvoreDeComponentes();
	 * 
	 * configuraClassLoaderEspecifico(javaProject);
	 * 
	 * limpaInstanciasDeComponetesInternos(javaProject);
	 * 
	 * } catch (Throwable e) { MarkerUtils.addMarker(project,
	 * "Projeto não vacinado! Verifique se a vaccine consta no classpath do projeto."
	 * , 1, IMarker.SEVERITY_ERROR, ASMLConstant.MARKER_TYPE); throw new
	 * CoreException(Status.CANCEL_STATUS); } return project; }
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
				ASMLModel asmlModelPrimario = asmlContext.getAsmlModelPrimario();
				if(asmlModelPrimario==null){
					List<IProject> projects = new ArrayList<IProject>();
					projects = Activator.getOpenedProjects(iProject.getWorkspace());
					carregaArvoreDeComponentes(projects);
				}
				Resource eResource = asmlModelPrimario.eResource();
				String path = ClassPathUtil.recuperaPathVaccine(asmlContext.getJavaProject(iProject));
				xtextParser.addAllResourcesImported(eResource, path);
				asmlModel = asmlContext.getAsmlModel(iProject);
				if(asmlModel==null){
					throw new RuntimeException("Não existe especificação de arquitetura com nome:"+ iProject.getName() );
				}
			} else {
				asmlContext.removeViolations(iProject);
				iProject.deleteMarkers(ASMLConstant.MARKER_TYPE, true, IResource.DEPTH_INFINITE);
				asmlContext.clearInternalsComponentInstance(iProject);
				List<AbstractComponent> allComponents = asmlModel.getComponents();
				for (AbstractComponent abstractComponent : allComponents) {
					abstractComponent.componentInstancesClearAll();// A partir
																	// da raiz
																	// limpa
																	// todos as
																	// instancias
																	// de
																	// componentes
																	// encontradas.
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void configuraClassLoaderEspecifico(IProject iProject) {
		try {
			IJavaProject javaProject = asmlContext.getJavaProject(iProject);
			IClasspathEntry iClasspathEntryVaccine = ClassPathUtil.recuperaClassPathDaVaccina(javaProject);
			String workspacePath = javaProject.getProject().getWorkspace().getRoot().getLocation().toString();// TODO:Melhorar
																												// as
																												// duas
																												// linhas
																												// abaixo
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
					// log.info("Encontrou jar ou porjeto maven da vaccine...:"
					// + iClasspathEntry.getPath().toString());
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
					vaccineName = iClasspathEntry.getPath().lastSegment();// Projetos
																			// não
																			// maven
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
				if (component.getModel().getProject() == null)
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
		if (Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_SHOW_STRUCTURAL_VIOLATIONS))
			validateHierachicalViolations(iProject);

		log(Level.INFO, "Finalizou o processo validação...");
	}

	public void fullBuild(IProject project, IProgressMonitor monitor) {
		try {
			if (getAsmlContext() != null) {
				monitor.beginTask("Validação de arquitetura: ", 6);

				monitor.subTask("Limpando instancias de componentes internos...");
				limpaInstanciasDeComponetesInternos(project);
				monitor.worked(1);

				monitor.subTask("Recuperando instancias de componentes internos...");
				recoveryAllInternalComponentInstances(project);
				monitor.worked(1);

				monitor.subTask("Recuperando referências à componentes internos...");
				recoveryAllInternalComponentInstancesReferences(project);
				monitor.worked(1);

				monitor.subTask("Realizando o matching...");
				matchingInternal(null, project);
				monitor.worked(1);

				monitor.subTask("Validando...");
				validate(project);
				monitor.worked(1);

				monitor.subTask("Mostrando violações...");
				showViolations(project);
				monitor.worked(1);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void autoBuild(IResourceDelta delta, IProject project) {
		try {
			ASMLModel asmlModel = getAsmlContext().getAsmlModel(project);
			List<IProject> projects = new ArrayList<IProject>();
			if (asmlModel == null) {
				projects = Activator.getOpenedProjects(project.getWorkspace());
				carregaArvoreDeComponentes(projects);
			} else {
				projects.add(project);
				updateArvoreDeComponentes(projects);
			}
			if (delta == null) {
				recoveryAllTokensNameConvention();
				configuraClassLoaderEspecifico(project);
				limpaInstanciasDeComponetesInternos(project);
				recoveryAllInternalComponentInstances(project);
				recoveryAllInternalComponentInstancesReferences(project);
				matchingInternal(null, project);
				matchingExternal();
				validate(project);
				showViolations(project);
			} else {
				incrementalBuild(delta, project);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro em auto Build", e);
		}
	}

	public void incrementalBuild(IResourceDelta delta, IProject project) {
		try {
			recoveryAllInternalComponentInstancesReferencesIncremental(delta, project);
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

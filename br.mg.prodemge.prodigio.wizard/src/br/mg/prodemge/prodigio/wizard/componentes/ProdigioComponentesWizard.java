package br.mg.prodemge.prodigio.wizard.componentes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;

import asmlbuilder.Activator;
import br.mg.prodemge.prodigio.wizard.ProdigioWizardHelper;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class ProdigioComponentesWizard extends Wizard implements INewWizard {

	private static String projectName = "";
	private static IProject iprojectSelecionado;
	private static ComponentInstance componentInstanceDominante;

	private static final String WIZARD_NAME = "Prodigio assistente";
	private static final String PAGE_1 = "Pagina 1";
	private static final String PAGE_2 = "Pagina 2";
	private static final String PAGE_VO = "Pagina VO";

	private ProdigioComponentesPageWizard _pageOne;
	private ProdigioComponentesPage2Wizard _pageTwo;
	private ProdigioComponentesVOPageWizard _pageVO;
	private boolean canFinish;
	private HashMap<String, String> variables = new HashMap<String, String>();
	private static HashMap<String, ComponentInstance> componentesDominantes = new HashMap<String, ComponentInstance>();

	public static HashMap<String, ComponentInstance> getComponentesDominantes() {
		return componentesDominantes;
	}

	private static Map<String, IProject> openedProjectsMap = new HashMap<String, IProject>();
	private static AbstractComponent componenteQueSeraInstanciado = null;
	private static ComponentInstance moduloDoComponenteQueSeraInstanciado = null;

	protected static Map<String, String> templates = new HashMap<String, String>();

	public static Map<String, IProject> getOpenedProjectsMap() {
		return Collections.unmodifiableMap(openedProjectsMap);
	}

	public ProdigioComponentesWizard() {
		setWindowTitle(WIZARD_NAME);

		componentInstanceDominante = null;

		atualizaVaccina();

		initTemplates();
	}

	private void initTemplates() {
		templates.clear();

		Bundle bundle = Platform.getBundle("br.mg.prodemge.prodigio.wizard");
		String caminhoDoTemplate = "/templates_componentes/src/main/java/";
		Enumeration<URL> entries = bundle.findEntries(caminhoDoTemplate, "*", true);
		while (entries.hasMoreElements()) {
			URL url = (URL) entries.nextElement();
			final String[] segments = url.getFile().split("/");
			final String templateNameWithExtension = segments[segments.length - 1];
			String path = url.toString();
			String ext = path.substring(path.lastIndexOf(".") + 1, path.length());
			String templateName = templateNameWithExtension.replace("." + ext, "");
			templates.put(templateName, templateNameWithExtension);
		}

		caminhoDoTemplate = "/templates_componentes/src/main/webapp/";
		entries = bundle.findEntries(caminhoDoTemplate, "*", true);
		while (entries.hasMoreElements()) {
			URL url = (URL) entries.nextElement();
			final String[] segments = url.getFile().split("/");
			final String templateNameWithExtension = segments[segments.length - 1];
			String path = url.toString();
			String ext = path.substring(path.lastIndexOf(".") + 1, path.length());
			String templateName = templateNameWithExtension.replace("." + ext, "");
			templates.put(templateName, templateNameWithExtension);
		}

	}

	private String extractTemplateName(String path) {
		Pattern pattern = Pattern.compile("java/(.*).(java|zul)");
		Matcher matcher = pattern.matcher(path);
		if (matcher.find())
			return matcher.group(1);

		throw new RuntimeException("Não foi possivel recuperar nome.");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		List<IProject> openedProjects = asmlbuilder.Activator.getOpenedProjects(ResourcesPlugin.getWorkspace());
		for (IProject iProject : openedProjects) {
			openedProjectsMap.put(iProject.getName(), iProject);
		}
		atualizaVaccina();

	}

	@Override
	public boolean performFinish() {

		criaVariaveisDinamicas();

		criaVariaveisRelacionadasAoConceito();

		criaVariaveisRelacionadosAsClasseQueSeraoExtendidas();

		Map<String, String> replaceNome = new HashMap<String, String>();
		if (ProdigioComponentesWizard.componentInstanceDominante != null) {
			final String[] segments = ProdigioComponentesWizard.componentInstanceDominante.getResource().getFullPath().segments();
			final AbstractComponent[] hierarquiaDoComponentesQueSeraInstanciado = recuperaNomeDaHierarquiaDoComponenteQueSeraInstanciado(segments.length);
			final ComponentInstance[] hierarquiaDoComponenteDominante = recuperaNomeDaHierarquiaDoComponenteDominante(segments.length);

			for (int i = hierarquiaDoComponentesQueSeraInstanciado.length - 1; i >= 0; i--) {
				AbstractComponent instanciado = hierarquiaDoComponentesQueSeraInstanciado[i];
				ComponentInstance dominante = hierarquiaDoComponenteDominante[i];
				if (instanciado == null)
					break;
				final String matchingInstanciado = instanciado.getMatching();
				final String rawNameDominante = dominante.getRawName();
				final String nameDominante = dominante.getResource().getFullPath().removeFileExtension().lastSegment();
				String fnalNameInstanciado = matchingInstanciado.replace("{?}", rawNameDominante);
				fnalNameInstanciado = fnalNameInstanciado.replace("_{*}", "");
				fnalNameInstanciado = fnalNameInstanciado.replaceAll("\\{extension=([^<]*)\\}", "");
				replaceNome.put(nameDominante, fnalNameInstanciado);
			}
		}

		String nomeDoComponenteQueSeraInstanciado = ProdigioComponentesWizard.componenteQueSeraInstanciado.getFullName();
		copiarTemplate(replaceNome, nomeDoComponenteQueSeraInstanciado);

		return true;
	}

	private ComponentInstance[] recuperaNomeDaHierarquiaDoComponenteDominante(int length) {
		int index = length-1;
		ComponentInstance[] compontentesParentsDoComponenteDominante = new ComponentInstance[length];
		ComponentInstance aux;
		aux = ProdigioComponentesWizard.componentInstanceDominante;
		while (!aux.getComponent().getName().equals("sistema")) {
			compontentesParentsDoComponenteDominante[index--] = aux;
			final AbstractComponent componente = (AbstractComponent) aux.getComponent().eContainer();
			final Set<ComponentInstance> instances = componente.getInstances();
			for (ComponentInstance componentInstance : instances) {
				if (componentInstance.getResource().getFullPath().equals(aux.getResource().getParent().getFullPath())) {
					aux = (ComponentInstance) componentInstance;
					break;
				}
			}
		}
		return compontentesParentsDoComponenteDominante;
	}

	private AbstractComponent[] recuperaNomeDaHierarquiaDoComponenteQueSeraInstanciado(int length) {
		int index = length-1;
		final AbstractComponent[] hierarquiaDoComponentesQueSeraInstanciado = new AbstractComponent[length];
		AbstractComponent aux = ProdigioComponentesWizard.componenteQueSeraInstanciado;
		while (!aux.getName().equals("sistema")) {
			hierarquiaDoComponentesQueSeraInstanciado[index--] = aux;
			aux = (AbstractComponent) aux.eContainer();
		}
		return hierarquiaDoComponentesQueSeraInstanciado;
	}

	private void copiarTemplate(Map<String, String> replaceNomeArquivo, String nomeDoComponenteQueSeraInstanciado, String... classe) {
		String stringPathComponente = null;
		final ComponentInstance componentInstanceDominante = ProdigioComponentesWizard.componentInstanceDominante;
		if (componentInstanceDominante != null) {
			stringPathComponente = recuperaPathDoComponenteUsandoNomeDoComponenteDominante(replaceNomeArquivo, componentInstanceDominante);
		} else {
			final ProdigioComponentesVOPageWizard prodigioComponentesVOPageWizard = (ProdigioComponentesVOPageWizard) this.getPage(ProdigioComponentesWizard.PAGE_VO);
			final String modulo = prodigioComponentesVOPageWizard.getNomeModulo();
			final String nomeClasse = prodigioComponentesVOPageWizard.getNomeClasse();
			stringPathComponente = recuperaPathDoComponenteQueNaoPossuiComponenteDominante(nomeClasse, modulo);
		}

		File file = recuperarTemplate(templates.get(nomeDoComponenteQueSeraInstanciado));
		final String pathAux = file.toString();
		if (pathAux.contains("\\webapp\\")) {
			stringPathComponente = stringPathComponente.replace("/java/", "/webapp/");
		}

		final String[] segments = pathAux.split("\\.");

		final String extension = segments[segments.length - 1];
		IFile iFile = iprojectSelecionado.getFile(stringPathComponente + "." + extension);
		ProdigioWizardHelper.copiaArquivoDoTemplateParaArquivo(iFile, file, variables);

		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		try {
			IDE.openEditor(win.getActivePage(), iFile);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		atualizaVaccina();
	}

	private void criaVariaveisRelacionadosAsClasseQueSeraoExtendidas() {
		final AbstractComponent componenteQueSeraInstanciado2 = ProdigioComponentesWizard.getComponenteQueSeraInstanciado();
		final Set<ComponentInstance> recuperaInstanciasQueEsteComponenteDeveEstender = ProdigioComponentesWizard.recuperaInstanciasQueEsteComponenteDeveEstender(componenteQueSeraInstanciado2);
		ComponentInstance next = null;
		if (!recuperaInstanciasQueEsteComponenteDeveEstender.isEmpty()) {
			next = recuperaInstanciasQueEsteComponenteDeveEstender.iterator().next();
			final IType type = next.getType();
			final AbstractComponent abstractComponent = next.getComponent();
			variables.put("<%EXTEND_" + abstractComponent.getName() + "_package%>", type.getPackageFragment().getElementName());
			variables.put("<%EXTEND_" + abstractComponent.getName() + "_fullname%>", type.getFullyQualifiedName());
			variables.put("<%EXTEND_" + abstractComponent.getName() + "_name%>", type.getElementName());
			variables.put("<%EXTEND_" + abstractComponent.getName() + "_name_upper%>", type.getElementName().toUpperCase());
			variables.put("<%EXTEND_" + abstractComponent.getName() + "_name_lower%>", type.getElementName().toLowerCase());
		}
	}

	private String recuperaPathDoComponenteQueNaoPossuiComponenteDominante(String nomeClasse, String modulo) {
		String stringPathComponente;
		final String camada = ((AbstractComponent) ProdigioComponentesWizard.componenteQueSeraInstanciado.eContainer().eContainer()).getName();
		final Set<ComponentInstance> instances = ((AbstractComponent) ProdigioComponentesWizard.componenteQueSeraInstanciado.eContainer().eContainer().eContainer()).getInstances();
		final ComponentInstance instanceSistema = instances.iterator().next();
		final IPath fullPath = instanceSistema.getResource().getFullPath();
		final IPath removeFirstSegments = fullPath.removeFirstSegments(1);
		final String matching = componenteQueSeraInstanciado.getMatching();
		nomeClasse = matching.replaceAll("\\{\\?\\}", nomeClasse);
		stringPathComponente = removeFirstSegments.append(camada).append(modulo).append(nomeClasse).toString();
		stringPathComponente = stringPathComponente.replace("{", "").replace("}", "").replace("_", "").replace("?", "").replace("extension=zul", "").replace("*", "");
		return stringPathComponente;
	}

	private String recuperaPathDoComponenteUsandoNomeDoComponenteDominante(Map<String, String> replaceNomeArquivo, final ComponentInstance componentInstanceDominante) {
		String stringPathComponenteDominante = null;
		final IResource resource = componentInstanceDominante.getResource();
		IPath fullPathComponenteDominante = resource.getFullPath();
		final IPath fullPathSemProjeto = fullPathComponenteDominante.removeFirstSegments(1);
		stringPathComponenteDominante = fullPathSemProjeto.removeFileExtension().toString();
		String stringPathComponente = "";
		if (replaceNomeArquivo != null) {
			stringPathComponente = replaceTokens(replaceNomeArquivo, stringPathComponenteDominante);
		}
		return stringPathComponente;
	}

	private String replaceTokens(Map<String, String> replaceNomeArquivo, String stringPathComponenteDominante) {
		String stringPathComponente;
		Set<String> keySet = replaceNomeArquivo.keySet();
		stringPathComponente = stringPathComponenteDominante;
		for (String key : keySet)
			stringPathComponente = stringPathComponente.replace(key, replaceNomeArquivo.get(key));
		return stringPathComponente;
	}

	private void atualizaVaccina() {
		try {
			final Collection<IProject> values = ProdigioComponentesWizard.openedProjectsMap.values();
			for (IProject iProject : values) {
				Activator.getAsmlProcessor().fullBuild(iProject, new NullProgressMonitor());
			}
		} catch (Exception e) {
			throw new RuntimeException("Atualizar os componentes arquiteturais.");
		}
	}

	private void criaVariaveisDinamicas() {
		variables.put("<%modulo%>", getInstanciaDoComponentePaiDoQueSeraInstanciad().getRawName());
	}

	private void criaVariaveisRelacionadasAoConceito() {
		String conceito = "";
		final ComponentInstance componentInstanceDominante = ProdigioComponentesWizard.componentInstanceDominante;
		final ProdigioComponentesVOPageWizard prodigioComponentesVOPageWizard = (ProdigioComponentesVOPageWizard) this.getPage(ProdigioComponentesWizard.PAGE_VO);
		if (componentInstanceDominante != null) {
			conceito = componentInstanceDominante.getRawName();
		} else {
			conceito = prodigioComponentesVOPageWizard.getNomeClasse();
		}

		variables.put("<%conceito%>", conceito.toLowerCase());
		variables.put("<%Conceito%>", conceito.substring(0, 1).toUpperCase() + conceito.substring(1));
		final Collection<IProject> values = getOpenedProjectsMap().values();
		for (IProject iProject : values) {
			final List<AbstractComponent> allComponents = Activator.getAsmlProcessor().getAsmlContext().getAsmlModel(iProject).getAllComponents();
			for (AbstractComponent abstractComponent : allComponents) {
				final Set<ComponentInstance> instances = abstractComponent.getInstances();
				for (ComponentInstance componentInstance : instances) {
					// if (componentInstance.getRawName().contains(conceito)) {
					final IType type = componentInstance.getType();
					if (type != null) {
						variables.put("<%" + abstractComponent.getName() + "_package%>", type.getPackageFragment().getElementName());
						variables.put("<%" + abstractComponent.getName() + "_fullname%>", type.getFullyQualifiedName());
						variables.put("<%" + abstractComponent.getName() + "_name%>", type.getElementName());
						variables.put("<%" + abstractComponent.getName() + "_name_upper%>", type.getElementName().toUpperCase());
						variables.put("<%" + abstractComponent.getName() + "_name_lower%>", type.getElementName().toLowerCase());
					} else {
						variables.put("<%" + abstractComponent.getName() + "_name%>", componentInstance.getRawName());
						if (abstractComponent.getMatching() != null && abstractComponent.getName() != null) {
							variables.put("<%" + abstractComponent.getName() + "_matching%>", abstractComponent.getMatching());
							variables.put("<%" + abstractComponent.getName() + "_raw_matching%>", abstractComponent.getMatching().replace("{?}", "").replace("{*}", "").replace("_{extension=}", ""));
						}
					}
					// }
				}
			}
		}
	}

	private File recuperarTemplate(String template) {
		Bundle bundle = Platform.getBundle("br.mg.prodemge.prodigio.wizard");
		String caminhoDoTemplate = "/templates_componentes/src/main/java/";
		URL fileURL = bundle.getEntry(caminhoDoTemplate + template);
		if (fileURL == null) {
			caminhoDoTemplate = "/templates_componentes/src/main/webapp/";
			fileURL = bundle.getEntry(caminhoDoTemplate + template);
		}

		URL fileURL2;
		try {
			fileURL2 = FileLocator.toFileURL(fileURL);
			File file = new File(fileURL2.getFile());
			return file;
		} catch (IOException e) {
			throw new RuntimeException("Template inexistente.");
		}
	}

	@Override
	public void addPages() {
		_pageOne = new ProdigioComponentesPageWizard(PAGE_1);
		_pageTwo = new ProdigioComponentesPage2Wizard(PAGE_2);
		_pageVO = new ProdigioComponentesVOPageWizard(PAGE_VO);

		addPage(_pageOne);
		addPage(_pageTwo);
		addPage(_pageVO);
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page.getDescription().toLowerCase().contains("passo 1")) {
			if (!ProdigioComponentesWizard.requerComponenteDominante(componenteQueSeraInstanciado)) {
				final String rawName = ProdigioComponentesWizard.getInstanciaDoComponentePaiDoQueSeraInstanciad().getRawName();
				_pageVO.getInputModulo().setText(rawName);
				final String primeiraletra = rawName.substring(0, 1).toUpperCase();
				final String nome = primeiraletra + rawName.substring(1);
				_pageVO.getInputNomeDaNovaInstanciaDoComponente().setText(nome);
				return _pageVO;
			} else if (page.isPageComplete()) {
				carregaIntanciasDeComponentesDominantes();
				((ProdigioComponentesPage2Wizard) _pageTwo).updatePage();
				return _pageTwo;
			}
		}

		return super.getNextPage(page);
	}

	@Override
	public boolean canFinish() {
		return this.isCanFinish();
	}

	public static String getProjectName() {
		return projectName;
	}

	public static void setProjectName(String projectName) {
		ProdigioComponentesWizard.projectName = projectName;
	}

	public static AbstractComponent getComponenteQueSeraInstanciado() {
		return componenteQueSeraInstanciado;
	}

	public static void setComponenteQueSeraInstanciado(AbstractComponent abstractComponent) {
		ProdigioComponentesWizard.componenteQueSeraInstanciado = abstractComponent;
	}

	public static IProject getIprojectSelecionado() {
		return iprojectSelecionado;
	}

	public static void setIprojectSelecionado(IProject iproject) {
		ProdigioComponentesWizard.iprojectSelecionado = iproject;
	}

	public static ComponentInstance getComponentInstanceDominante() {
		return componentInstanceDominante;
	}

	public static void setComponentInstanceDominante(ComponentInstance componentInstance) {
		ProdigioComponentesWizard.componentInstanceDominante = componentInstance;
	}

	public boolean isCanFinish() {
		return canFinish;
	}

	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}

	public static Set<ComponentInstance> recuperaInstanciasQueEsteComponenteDeveEstender(final AbstractComponent abstractComponent) {
		final RelactionType relactionType = RelactionType.EXTEND;
		EList<Restriction> restrictions = abstractComponent.getRestrictions();
		Set<ComponentInstance> allComponentInstances = null;
		for (Restriction restriction : restrictions) {
			if (restriction.getRelactionType().equals(relactionType)) {
				final EList<ComponentsBinRestrictionDeclareation> componentsB = restriction.getComponentB();
				if (!componentsB.isEmpty()) {
					final ComponentsBinRestrictionDeclareation componentsBinRestrictionDeclareation2 = componentsB.get(0);
					ComponentsBinRestrictionDeclareation componentsBinRestrictionDeclareation = componentsBinRestrictionDeclareation2;
					AbstractComponent componentB = componentsBinRestrictionDeclareation.getComponentB();
					allComponentInstances = componentB.getInstances();
				}
			}
		}
		if (allComponentInstances == null)
			return new HashSet<ComponentInstance>();
		return allComponentInstances;
	}

	public static ComponentInstance getInstanciaDoComponentePaiDoQueSeraInstanciad() {
		return moduloDoComponenteQueSeraInstanciado;
	}

	public static void setInstanciaDoComponentePaiDoQueSeraInstanciado(ComponentInstance moduloDoComponenteQueSeraInstanciado) {
		ProdigioComponentesWizard.moduloDoComponenteQueSeraInstanciado = moduloDoComponenteQueSeraInstanciado;
	}

	public static boolean requerComponenteDominante(final AbstractComponent abstractComponent) {
		final RelactionType relactionType = RelactionType.REQUIRES;
		EList<Restriction> restrictions = abstractComponent.getRestrictions();
		for (Restriction restriction : restrictions) {
			if (restriction.getRelactionType().equals(relactionType)) {
				return true;
			}
		}
		return false;
	}

	public static void carregaIntanciasDeComponentesDominantes() {
		componentesDominantes.clear();

		final AbstractComponent abstractComponent = ProdigioComponentesWizard.getComponenteQueSeraInstanciado();
		Set<ComponentInstance> allComponentInstances = recuperaInstanciasDominantesDoComponente(abstractComponent);
		System.out.println("");
		for (ComponentInstance componentInstance : allComponentInstances)
			componentesDominantes.put(componentInstance.toString(), componentInstance);

	}

	private static Set<ComponentInstance> recuperaInstanciasDominantesDoComponente(final AbstractComponent abstractComponent) {
		final RelactionType relactionType = RelactionType.REQUIRES;
		EList<Restriction> restrictions = abstractComponent.getRestrictions();
		Set<ComponentInstance> allComponentInstances = new HashSet<ComponentInstance>();
		for (Restriction restriction : restrictions) {
			if (restriction.getRelactionType().equals(relactionType)) {
				final EList<ComponentsBinRestrictionDeclareation> componentsB = restriction.getComponentB();
				if (!componentsB.isEmpty()) {
					final ComponentsBinRestrictionDeclareation componentsBinRestrictionDeclareation2 = componentsB.get(0);
					ComponentsBinRestrictionDeclareation componentsBinRestrictionDeclareation = componentsBinRestrictionDeclareation2;
					AbstractComponent componentB = componentsBinRestrictionDeclareation.getComponentB();
					allComponentInstances = componentB.getInstances();
				}
			}
		}
		return allComponentInstances;
	}

	public static void main(String args[]) {
		// String to be scanned to find the pattern.
		String str = "{extenssions=.zul}";
		str = str.replaceAll("\\{extenssions=([^<]*)\\}", "");
		System.out.println(str);
	}

}

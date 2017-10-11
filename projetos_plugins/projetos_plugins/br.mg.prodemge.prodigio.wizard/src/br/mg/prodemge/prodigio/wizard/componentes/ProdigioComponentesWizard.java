package br.mg.prodemge.prodigio.wizard.componentes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
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

import br.mg.prodemge.prodigio.wizard.ProdigioWizardHelper;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class ProdigioComponentesWizard extends Wizard implements INewWizard {

	private static String projectName = "";
	private static IProject iproject ;
	private static ComponentInstance componentInstance;
	
	private static final String WIZARD_NAME = "Prodigio assistente";
	private static final String FROM_SCRATCH_PROJECT_WIZARD = "Criação de componentes";
	private static final String FROM_SCRATCH_PROJECT = "Criação de componentes arquiteturais";
	
	private ProdigioComponentesPageWizard _pageOne;
	private ProdigioComponentesPage2Wizard _pageTwo;
	private ProdigioComponentesVOPageWizard _pageVO;
	private boolean canFinish;
	
	private static Map<String,IProject> openedProjectsMap = new HashMap<String, IProject>();
	private static AbstractComponent abstractComponent = null;
	
	protected static Map<String, String> templates = new HashMap<String, String>();
	
	public static Map<String, IProject> getOpenedProjectsMap() {
		return Collections.unmodifiableMap(openedProjectsMap);
	}

	public ProdigioComponentesWizard() {
	    setWindowTitle(WIZARD_NAME);
	    
	    componentInstance = null;
	    initTemplates();
	}

	private void initTemplates() {
		templates.clear();
		
		Bundle bundle = Platform.getBundle("br.mg.prodemge.prodigio.wizard");
        final String caminhoDoTemplate = "/templates_componentes/src/main/java/";
        Enumeration<URL> entries = bundle.findEntries(caminhoDoTemplate, "*", true);
        while (entries.hasMoreElements()) {
			URL url = (URL) entries.nextElement();
			String path= url.toString();
			String ext = path.substring(path.lastIndexOf(".") + 1, path.length());
			String templateName = extractTemplateName(path);
			templates.put(templateName, String.format("%s.%s", templateName, ext));
		}
	}

	private String extractTemplateName(String path) {
		Pattern pattern =  Pattern.compile("java/(.*).(java|zul)");
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
	}

	@Override
	public boolean performFinish() {
		String componenteQueSeraInstanciado = abstractComponent.getFullName();
		Map<String,String> replaceNome = new HashMap<String, String>();
				
		switch (componenteQueSeraInstanciado) {
		case "ecosistema.sistema.controle.modulo.Controller":
			replaceNome.put("entidades", "controle");
			replaceNome.put("VO", "Ctr");
			copiarTemplate(replaceNome, componenteQueSeraInstanciado);
			return true;
		case "ecosistema.sistema.negocio.modulo.Especification":
			replaceNome.put("entidades", "negocio");
			replaceNome.put("VO", "RN");
			copiarTemplate(replaceNome, componenteQueSeraInstanciado);
			return true;
		case "ecosistema.sistema.persistencia.modulo.DAO":
			replaceNome.put("entidades", "persistencia");
			replaceNome.put("VO", "DAO");
			copiarTemplate(replaceNome, componenteQueSeraInstanciado);
			return true;
		case "ecosistema.sistema.entidades.modulo.AppVO":
			String pacote = _pageVO.getPacote().replace(".", "/"); 
			String classe = _pageVO.getClasse().replace(".", "/"); 
			String path = String.format("/src/main/java/%s/%s.java", pacote, classe);
			copiarTemplate(null, componenteQueSeraInstanciado, path);
			return true;
		case "ecosistema.sistema.visao.modulo.Page":
			replaceNome.put("src/main/java", "src/main/webapp");
			replaceNome.put("controle", "visao");
			replaceNome.put("Ctr", "");
			replaceNome.put(".java", ".zul");
			copiarTemplate(replaceNome, componenteQueSeraInstanciado);
			return true;

		default:
			return false;
		}
	}
	
	private void copiarTemplate(Map<String, String> replaceNomeArquivo, String componenteQueSeraInstanciado, String... classe) {
		String stringPath = null;
		if (ProdigioComponentesWizard.componentInstance != null) {
			IPath fullPath = ProdigioComponentesWizard.componentInstance.getResource().getFullPath();
			stringPath = fullPath.toString().substring(1);
		} else {
			stringPath = classe[0];
		}
		
		String nomeVO = recuperarNomeVO(stringPath);
		
		stringPath = stringPath.substring(stringPath.indexOf("/"), stringPath.length());
		
		if (replaceNomeArquivo != null) {
			Set<String> keySet = replaceNomeArquivo.keySet();
			for (String key : keySet) 
				stringPath = stringPath.replace(key, replaceNomeArquivo.get(key));
		}
		
		String componente = recuperarComponente(stringPath);
		String pacote = recuperarPacote(stringPath);
		String pacoteBase = recuperarPacoteBase(stringPath);
		String nomeBaseProjeto = recuperaNomeBaseProjeto();
		
		Map <String, String> parametros = new HashMap<String, String>();
		parametros.put("<%package%>", pacote);
		parametros.put("<%componente%>", componente);
		parametros.put("<%componente_base%>", nomeBaseProjeto);
		parametros.put("<%package_componente_base%>", pacoteBase);
		parametros.put("<%dependenciaVO%>", nomeVO);
		
		File file = recuperarTemplate(templates.get(componenteQueSeraInstanciado));
		IFile iFile = iproject.getFile(stringPath);
		ProdigioWizardHelper.copiaArquivoDoTemplateParaArquivo(iFile, file, parametros);
		
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		try {
			IDE.openEditor(win.getActivePage(), iFile);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
		}
	}
	
	private String recuperaNomeBaseProjeto() {
		String rawName = projectName.split("-")[0];
		return rawName.substring(0, 1).toUpperCase() + rawName.substring(1);
	}

	private String recuperarComponente(String fullPath) {
		Pattern pattern =  Pattern.compile("/(\\w*)(VO|Ctr|VO|DAO|RN|\\.zul)");
		Matcher matcher = pattern.matcher(fullPath);
		if (matcher.find())
			return matcher.group(1);
		
		throw new RuntimeException("Não foi possivel recuperar nome.");
	}
	
	private String recuperarNomeVO(String fullPath) {
		Pattern pattern = Pattern.compile("/(br.*).java");
		Matcher matcher = pattern.matcher(fullPath);
		if (matcher.find())
			return matcher.group(1).replace("/", ".");
		
		throw new RuntimeException("Não foi possivel recuperar nome do VO.");
	}
	
	private String recuperarPacote(String fullPath) {
		Pattern pattern = Pattern.compile("(br.*)/");
		Matcher matcher = pattern.matcher(fullPath);
		if (matcher.find())
			return matcher.group(1).replace("/", ".");
		
		throw new RuntimeException("Não foi possivel recuperar pacote.");
	}
	
	private String recuperarPacoteBase(String fullPath) {
		Pattern pattern = Pattern.compile("/(br.*(controle|negocio|persistencia|entidades|visao))");
		Matcher matcher = pattern.matcher(fullPath);
		if (matcher.find())
			return matcher.group(1).replace("/", ".");
		
		throw new RuntimeException("Não foi possivel recuperar pacote base.");
	}
	
	private File recuperarTemplate(String template) {
		Bundle bundle = Platform.getBundle("br.mg.prodemge.prodigio.wizard");
        final String caminhoDoTemplate = "/templates_componentes/src/main/java/";
        URL fileURL = bundle.getEntry(caminhoDoTemplate + template);
        
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
	    _pageOne = new ProdigioComponentesPageWizard(FROM_SCRATCH_PROJECT_WIZARD);
	    _pageTwo = new ProdigioComponentesPage2Wizard(FROM_SCRATCH_PROJECT_WIZARD);
	    _pageVO = new ProdigioComponentesVOPageWizard(FROM_SCRATCH_PROJECT);

	    addPage(_pageOne);
	    addPage(_pageTwo);
	    addPage(_pageVO);
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page.getDescription().toLowerCase().contains("passo 1")) {
			if (abstractComponent.getFullName().equals("ecosistema.sistema.entidades.modulo.AppVO"))
				return _pageVO;
			else if (page.isPageComplete()) {
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
		return abstractComponent;
	}

	public static void setComponenteQueSeraInstanciado(AbstractComponent abstractComponent) {
		ProdigioComponentesWizard.abstractComponent = abstractComponent;
	}

	public static IProject getIproject() {
		return iproject;
	}

	public static void setIproject(IProject iproject) {
		ProdigioComponentesWizard.iproject = iproject;
	}

	public static ComponentInstance getComponentInstance() {
		return componentInstance;
	}

	public static void setComponentInstance(ComponentInstance componentInstance) {
		ProdigioComponentesWizard.componentInstance = componentInstance;
	}

	public boolean isCanFinish() {
		return canFinish;
	}

	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}

}

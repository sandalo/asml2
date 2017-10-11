package br.mg.prodemge.prodigio.wizard;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

public class ProdigioWizardHelper {
	/**
	 * For this marvelous project we need to: - create the default Eclipse
	 * project - add the custom project nature - create the folder structure
	 *
	 * @param projectName
	 * @param location
	 * @param monitor
	 * @param natureId
	 * @return
	 */
	public static void createProject(String projectName, URI location, String templateType, IProgressMonitor monitor) {
		
		monitor.beginTask("Criando projetos proddígio: ", 6);

		monitor.subTask("Criando projeto parent...");
		IProject projetoMavenParent = montaProjeto(projectName, location, "cursoprodigio", templateType);
		monitor.worked(1);

		monitor.subTask("Criando projeto domain...");
		IProject projetoDomain = montaProjeto(projectName, location, "cursoprodigio-domain", templateType);
		monitor.worked(1);

		monitor.subTask("Criando projeto BackEnd...");
		IProject projetoBackEnd = montaProjeto(projectName, location,"cursoprodigio-backend", templateType);
		monitor.worked(1);

		monitor.subTask("Criando projeto FrontEnd...");
		IProject projetoFrontEnd = montaProjeto(projectName, location, "cursoprodigio-frontend", templateType);
		monitor.worked(1);

		monitor.subTask("Criando projeto EAR BackEnd...");
		IProject projetoEarBackEnd = montaProjeto(projectName, location, "cursoprodigio-app-backend", templateType);
		monitor.worked(1);

		monitor.subTask("Criando projeto EAR FrontEnd...");
		IProject projetoEarFrontEnd = montaProjeto(projectName, location, "cursoprodigio-app-frontend", templateType);
		monitor.worked(1);

		String[] natures;
		String[] buildSpecs;

		natures = new String[] { "org.eclipse.wst.common.modulecore.ModuleCoreNature", "org.eclipse.m2e.core.maven2Nature", "org.eclipse.wst.common.project.facet.core.nature", "org.jboss.tools.jst.web.kb.kbnature" };
		buildSpecs = new String[] { "org.eclipse.wst.common.project.facet.core.builder" };
		preparaBuild(natures, buildSpecs, projetoMavenParent);
		
		natures = new String[] { "org.eclipse.wst.common.modulecore.ModuleCoreNature", "org.eclipse.jdt.core.javanature", "org.eclipse.m2e.core.maven2Nature", "br.ufmg.dcc.asml.checker.asmlNature", "org.eclipse.wst.common.project.facet.core.nature" };
		buildSpecs = new String[] { "org.eclipse.jdt.core.javabuilder", "org.eclipse.wst.common.project.facet.core.builder", "br.ufmg.dcc.asml.checker.asmlBuilder" };
		preparaBuild(natures, buildSpecs, projetoDomain);
		
		natures = new String[] { "org.eclipse.wst.common.modulecore.ModuleCoreNature", "org.eclipse.jdt.core.javanature", "org.eclipse.m2e.core.maven2Nature", "br.ufmg.dcc.asml.checker.asmlNature", "org.eclipse.wst.common.project.facet.core.nature" };
		buildSpecs = new String[] { "org.eclipse.jdt.core.javabuilder", "org.eclipse.wst.common.project.facet.core.builder", "br.ufmg.dcc.asml.checker.asmlBuilder" };
		preparaBuild(natures, buildSpecs, projetoBackEnd);
		
		natures = new String[] { "org.eclipse.wst.common.modulecore.ModuleCoreNature", 
				                 "org.eclipse.wst.common.project.facet.core.nature", 
				                 "org.eclipse.m2e.core.maven2Nature", 
				                 "org.jboss.tools.jst.web.kb.kbnature",				                 
				                 "br.ufmg.dcc.asml.checker.asmlNature",				                 
				                 "org.eclipse.jdt.core.javanature" };
		buildSpecs = new String[] { "org.eclipse.jdt.core.javabuilder", "org.eclipse.wst.common.project.facet.core.builder", "br.ufmg.dcc.asml.checker.asmlBuilder" ,"org.eclipse.wst.validation.validationbuilder"};
		preparaBuild(natures, buildSpecs, projetoFrontEnd);

		natures = new String[] { "org.eclipse.wst.common.modulecore.ModuleCoreNature", "org.eclipse.m2e.core.maven2Nature", "org.eclipse.wst.common.project.facet.core.nature", "org.jboss.tools.jst.web.kb.kbnature" };
		buildSpecs = new String[] { "org.eclipse.wst.common.project.facet.core.builder" };
		preparaBuild(natures, buildSpecs, projetoEarBackEnd);
		
		natures = new String[] { "org.eclipse.wst.common.modulecore.ModuleCoreNature", "org.eclipse.m2e.core.maven2Nature", "org.eclipse.wst.common.project.facet.core.nature", "org.jboss.tools.jst.web.kb.kbnature" };
		buildSpecs = new String[] { "org.eclipse.wst.common.project.facet.core.builder" };
		preparaBuild(natures, buildSpecs, projetoEarFrontEnd);

	}


	private static IProject montaProjeto(String projectName, URI location, String template,String projetcType) {
		
		IProject project = criaProjetoVazio(projectName, location, template);
		criaEstruturaApartirDoTemplate(project, template, projetcType);
		return project;
	}

	/**
	 * Just do the basics: create a basic project.
	 *
	 * @param location
	 * @param projectName
	 * @param templatePath
	 * @param buildSpecs
	 * @param natures
	 */
	private static IProject criaProjetoVazio(String projectName, URI location, String templatePath) {
		// it is acceptable to use the ResourcesPlugin class
		IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(templatePath.replaceAll("cursoprodigio", projectName));

		if (!newProject.exists()) {
			URI projectLocation = location;
			IProjectDescription desc = newProject.getWorkspace().newProjectDescription(newProject.getName());
			if (location != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
				projectLocation = null;
			}
			desc.setLocationURI(projectLocation);
			try {
				newProject.create(desc, null);
				if (!newProject.isOpen()) {
					newProject.open(null);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		return newProject;
	}

	private static void preparaBuild(String[] natures, String[] buildSpecs, IProject newProject) {
		for (String nature : natures) {
			addNature(newProject, nature);
		}
		for (String buildSpec : buildSpecs) {
			addBuildSpec(newProject, buildSpec);
		}
	}

	private static void criaHierarquiaDaFolder(IFolder folder) throws CoreException {
		IContainer parent = folder.getParent();
		if (parent instanceof IFolder) {
			criaHierarquiaDaFolder((IFolder) parent);
		}
		if (!folder.exists()) {
			folder.create(false, true, null);
		}
	}

	/**
	 * Create a folder structure with a parent root, overlay, and a few child
	 * folders.
	 *
	 * @param newProject
	 * @param paths
	 * @throws CoreException
	 */
	private static void criaEstruturaApartirDoTemplate(IProject newProject, String templatePath, String projectType) {
		try {
			Bundle bundle = Platform.getBundle("br.mg.prodemge.prodigio.wizard");
			URL fileURL = bundle.getEntry(projectType + templatePath);
			URL fileURL2 = FileLocator.toFileURL(fileURL);
			File file = new File(fileURL2.getFile());

			File[] listFiles = file.listFiles();
			for (File filhos : listFiles) {
				criaEstrutura(newProject, filhos);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar projeto" + newProject.getName(), e);
		}
	}

	public static void criaEstrutura(IContainer container, File fileTemplate) {
		try {
			if (fileTemplate.isDirectory()) {
				copiaPastaDoTemplateParaNovoProjeto(container, fileTemplate);
			} else {
				copiaArquivoDoTemplateParaNovoProjeto(container, fileTemplate);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar " + container.getName(), e);
		}
	}

	private static void copiaPastaDoTemplateParaNovoProjeto(IContainer container, File fileTemplate) throws CoreException {
		String rawName = getRawNameProject(container);

		String template_name = getTemplateName(fileTemplate, rawName);

		IFolder etcFolder = null;

		etcFolder = criaFolderVazia(container, template_name);

		criaHierarquiaDaFolder(etcFolder);

		File[] listFiles = fileTemplate.listFiles();

		if (listFiles != null && listFiles.length > 0) {
			for (File fileChild : listFiles) {
				criaEstrutura(etcFolder, fileChild);
			}
		}
	}

	private static String getTemplateName(File fileTemplate, String rawName) {
		String template_name = fileTemplate.getName().replaceAll("cursoprodigio", rawName);
		return template_name;
	}

	private static String getRawNameProject(IContainer container) {
		String rawName = container.getProject().getName().split("-")[0];
		return rawName;
	}

	public static void copiaArquivoDoTemplateParaNovoProjeto(IContainer container, File fileTemplate) {
		String rawName = getRawNameProject(container);
		String template_name = getTemplateName(fileTemplate, rawName);
		IFile ifile = null;
		BufferedReader buff = null;
		ByteArrayOutputStream bao = null;
		try {
			String rawNameUpperCaseNaPrimeiraLetra = rawName.substring(0, 1).toUpperCase() + rawName.substring(1);
			ifile = inicializaIFile(container, template_name.replaceAll("CursoProdigio", rawNameUpperCaseNaPrimeiraLetra));
			InputStream in = new FileInputStream(fileTemplate);
			buff = new BufferedReader(new InputStreamReader(in, "UTF-8"));

			bao = new ByteArrayOutputStream();
			String bytesRead = "";
			while ((bytesRead = buff.readLine()) != null) {
				bytesRead = bytesRead.replaceAll("cursoprodigio", rawName);
				bytesRead = bytesRead.replaceAll("CursoProdigio", rawNameUpperCaseNaPrimeiraLetra);
				System.out.println(bytesRead);
				String quebra = "\n";
				bao.write(bytesRead.getBytes(Charset.forName("UTF-8")));
				bao.write(quebra.getBytes(Charset.forName("UTF-8")));
			}
			InputStream inputStream = new ByteArrayInputStream(bao.toByteArray());
			if (!ifile.exists()) {
				ifile.create(inputStream, true, null);
			} else {
				ifile.setContents(inputStream, IResource.FORCE, null);
			}
			buff.close();
			bao.close();
			in.close();
		} catch (Exception e) {
			try {
				buff.close();
				bao.close();
			} catch (IOException e1) {
				throw new RuntimeException("Erro ao criar estutura do projeto ou pasta " + container.getName(), e1);
			}
		}
	}
	
	public static void copiaArquivoDoTemplateParaArquivo(IFile ifile, File fileTemplate, Map parametros) {
		createFolder(ifile);
		
		BufferedReader buff = null;
		ByteArrayOutputStream bao = null;
		try {
			InputStream in = new FileInputStream(fileTemplate);
			buff = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			bao = new ByteArrayOutputStream();
			String bytesRead = "";
			while ((bytesRead = buff.readLine()) != null) {
				if (parametros != null) {
					Set<String> keySet = parametros.keySet();
					for (String key : keySet) 
						bytesRead = bytesRead.replaceAll(key, (String) parametros.get(key));
				}
					
				String quebra = "\n";
				bao.write(bytesRead.getBytes(Charset.forName("UTF-8")));
				bao.write(quebra.getBytes(Charset.forName("UTF-8")));
			}
			InputStream inputStream = new ByteArrayInputStream(bao.toByteArray());
			if (!ifile.exists()) {
				ifile.create(inputStream, true, null);
			} else {
				ifile.setContents(inputStream, IResource.FORCE, null);
			}
			buff.close();
			bao.close();
			in.close();
		} catch (Exception e) {
			try {
				buff.close();
				bao.close();
			} catch (IOException e1) {
				throw new RuntimeException("Erro ao criar estutura do projeto ou pasta ", e1);
			}
		}
	}


	private static void createFolder(IFile ifile) {
		String fullPath = ifile.getFullPath().toString().substring(1);
		fullPath = fullPath.substring(fullPath.indexOf("/"), fullPath.length());
		fullPath = fullPath.substring(0, fullPath.lastIndexOf("/"));
		
		IFolder folder = ifile.getProject().getFolder(fullPath);
		try {
			folder.create(true, true, null);
		} catch (CoreException e2) {
		}
	}

	private static IFolder criaFolderVazia(IContainer container, String template_name) {
		IFolder etcFolders = null;
		if (container instanceof IProject)
			etcFolders = ((IProject) container).getFolder(template_name);
		else if (container instanceof IFolder) {
			etcFolders = ((IFolder) container).getFolder(template_name);
		}
		return etcFolders;
	}

	private static IFile inicializaIFile(IContainer parent, String template_name) {
		IFile ifile = null;
		if (parent instanceof IProject)
			ifile = ((IProject) parent).getFile(template_name);
		else if (parent instanceof IFolder) {
			ifile = ((IFolder) parent).getFile(template_name);
		}
		return ifile;
	}

	private static void addNature(IProject project, String natureId) {
		try {
			if (!project.hasNature(natureId)) {
				IProjectDescription description = project.getDescription();
				String[] prevNatures = description.getNatureIds();
				String[] newNatures = new String[prevNatures.length + 1];
				System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
				newNatures[prevNatures.length] = natureId;
				description.setNatureIds(newNatures);
				IProgressMonitor monitor = null;
				project.setDescription(description, monitor);
			}
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(Status.INFO, Activator.PLUGIN_ID, Status.OK, "Erro ao adicionar Nature", e));
		}
	}

	private static void addBuildSpec(IProject project, String buildSpecName) {
		try {
			IProjectDescription description = project.getDescription();

			ICommand[] buildSpec = description.getBuildSpec();
			ICommand command = description.newCommand();
			command.setBuilderName(buildSpecName);
			Collection<ICommand> list = new ArrayList<>(Arrays.asList(buildSpec));
			list.add(command);
			description.setBuildSpec(list.toArray(new ICommand[list.size()]));
			project.setDescription(description, new NullProgressMonitor());
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(Status.INFO, Activator.PLUGIN_ID, Status.OK, "Erro ao adicionar BuildSpec", e));
		}
	}

}
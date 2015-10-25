package br.ufmg.dcc.asml;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class ClassPathUtil {
	private static final Logger log = Logger.getLogger(ClassPathUtil.class.getName());
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int, java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public static String recuperaPathVaccine(IJavaProject javaProject) {
		IClasspathEntry iClasspathEntryVaccine; 
		try {
			iClasspathEntryVaccine = ClassPathUtil.recuperaClassPathDaVaccina(javaProject);
			String path_vaccine_in_open_project;
			if (iClasspathEntryVaccine.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
				path_vaccine_in_open_project = "jar:file:/" + iClasspathEntryVaccine.getPath() + "!" + "/vaccine.asml";
			} else {
				String workspacePath = javaProject.getProject().getPathVariableManager().getValue("WORKSPACE_LOC").toString();
				path_vaccine_in_open_project = "file:/" + workspacePath + iClasspathEntryVaccine.getPath() + "/src/main/resources/" + "vaccine.asml";
			}
			return path_vaccine_in_open_project;
		} catch (Exception e) {
			String string = "N�o achou o path da vaccina";
			log.log(Level.SEVERE, string, e);
			throw new RuntimeException(string);
		}
	}

	public static String recuperaPathVaccine(IJavaProject javaProject, IClasspathEntry iClasspathEntryVaccine) {
		try {
			String path_vaccine_in_open_project;
			if (iClasspathEntryVaccine.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
				path_vaccine_in_open_project = "jar:file:/" + iClasspathEntryVaccine.getPath() + "!" + "/vaccine.asml";
			} else {
				String workspacePath = javaProject.getProject().getPathVariableManager().getValue("WORKSPACE_LOC").toString();
				path_vaccine_in_open_project = "file:/" + workspacePath + iClasspathEntryVaccine.getPath() + "/src/main/resources/" + "vaccine.asml";
			}
			return path_vaccine_in_open_project;
		} catch (Exception e) {
			String string = "Não achou o path da vaccina";
			log.log(Level.SEVERE, string, e);
			throw new RuntimeException(string);
		}
	}

	public static IClasspathEntry recuperaClassPathDaVaccina(IJavaProject javaProject) throws JavaModelException {
		String nomeProjeto = javaProject.getProject().getName();

		IClasspathContainer classpathMavenContainer = recuperaMavenContainerClassPath(javaProject);
		if (classpathMavenContainer == null) {
			log.info("Não encoutro o classPathContainer Maven.");
			return null;
		}
		IClasspathEntry[] classpathEntryMaven = classpathMavenContainer.getClasspathEntries();
//		log.info("Começa a varredura para encontrar iClasspathEntry de vaccine...");
		for (IClasspathEntry iClasspathEntry : classpathEntryMaven) {
	//		log.info("Encontrou " + iClasspathEntry.getPath().toString());
			IClasspathAttribute attributes[] = iClasspathEntry.getExtraAttributes();
			for (IClasspathAttribute iClasspathAttribute : attributes) {
				if (iClasspathAttribute.getValue().contains("vaccine")) {
					String iClasspathAttributeSemVaccine = iClasspathAttribute.getValue().replaceFirst("vaccine", "");
					if(iClasspathAttributeSemVaccine.startsWith("-"))
						iClasspathAttributeSemVaccine = iClasspathAttributeSemVaccine.replaceFirst("-", "");
					if (nomeProjeto.endsWith(iClasspathAttributeSemVaccine)) {
		//				log.info("Encontrou jar ou porjeto maven da vaccine...:" + iClasspathEntry.getPath().toString());
						return iClasspathEntry;
					}
				}
			}
		}
		log.info("N�o encontrou iClasspathEntry");
		return null;
	}

	
	public static List<IClasspathEntry> recuperaOpenedProjectsInClassPath(IJavaProject javaProject)  {
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		IClasspathContainer classpathMavenContainer = recuperaMavenContainerClassPath(javaProject);
		if (classpathMavenContainer == null) {
			log.info("N�o encoutro o classPathContainer Maven.");
			return entries;
		}
		IClasspathEntry[] classpathEntryMaven = classpathMavenContainer.getClasspathEntries();
		log.info("Come�a a varredura para encontrar iClasspathEntry de vaccine...");
		for (IClasspathEntry iClasspathEntry : classpathEntryMaven) {
			if (iClasspathEntry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
				entries.add(iClasspathEntry);
			}
		}
		return entries;
	}

	public static List<String> recuperaOpenedProjectNamesInClassPath(IJavaProject javaProject) {
		List<String> names = new ArrayList<String>();
		List<IClasspathEntry> entries = recuperaOpenedProjectsInClassPath(javaProject);
		for (IClasspathEntry iClasspathEntry : entries) {
			String name = iClasspathEntry.getPath().toString().replace("/", "");
			names.add(name);
		}
		return names;
	}

	
	public static IClasspathContainer recuperaMavenContainerClassPath(IJavaProject javaProject) {
		IClasspathEntry[] rawClasspath;
		try {
			rawClasspath = javaProject.getRawClasspath();
//			log.info("rawClasspath encontrados: " + rawClasspath + " size:" + rawClasspath.length);
			IClasspathEntry iClasspathEntryMAVEN = null;
			for (IClasspathEntry iClasspathEntry : rawClasspath) {
//				log.info("   encontrou a entrada:" + iClasspathEntry.getPath() + " EntryKind:" + iClasspathEntry.getEntryKind() + " no classpath.");
				if (iClasspathEntry.getPath().toString().contains("MAVEN")) {
					iClasspathEntryMAVEN = iClasspathEntry;
//					log.info("      vai recuperar o classpathContainer no path: " + iClasspathEntryMAVEN.getPath() + " size:" + rawClasspath.length);
					IClasspathContainer classpathMavenContainer = JavaCore.getClasspathContainer(iClasspathEntryMAVEN.getPath(), javaProject);
//					log.info("       Recuperou o classpathContainer MAVEN");
					return classpathMavenContainer;
				}
			}
		} catch (JavaModelException e) {
			String string = "A plataforma ainda não está disponível";
			log.log(Level.SEVERE, string);
			throw new RuntimeException(string);
		}
		return null;
	}

	public static List<IClasspathEntry> recuperaIClasspathEntriesDaVaccina(IJavaProject javaProject) {
		List<IClasspathEntry> IClasspathEntries = new ArrayList<IClasspathEntry>();
		IClasspathContainer classpathMavenContainer;
		classpathMavenContainer = recuperaMavenContainerClassPath(javaProject);
		if (classpathMavenContainer == null) {
//			log.info("Não encoutro o classPathContainer Maven.");
			return null;
		}
		IClasspathEntry[] classpathEntryMaven = classpathMavenContainer.getClasspathEntries();
//		log.info("Começa a varredura para encontrar iClasspathEntry de vaccine...");
		for (IClasspathEntry iClasspathEntry : classpathEntryMaven) {
//			log.info("Encontrou " + iClasspathEntry.getPath().toString());
			IClasspathAttribute attributes[] = iClasspathEntry.getExtraAttributes();
			for (IClasspathAttribute iClasspathAttribute : attributes) {
				if (iClasspathAttribute.getValue().contains("vaccine")) {
//					log.info("Encontrou jar ou porjeto maven da vaccine...:" + iClasspathEntry.getPath().toString());
					IClasspathEntries.add(iClasspathEntry);
					break;
				}
			}
		}
//		log.info("N�o encontrou iClasspathEntry");
		return IClasspathEntries;
	}

}

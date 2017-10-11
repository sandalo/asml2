package br.ufmg.dcc.asml.scoping;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

import br.ufmg.dcc.asml.ClassPathUtil;

public class ASMLImportUriGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	private static final Logger log = Logger.getLogger(ASMLImportUriGlobalScopeProvider.class.getName());

	@Override 
	protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
		LinkedHashSet<URI> temp = new LinkedHashSet<URI>();
		try {
			temp = super.getImportedUris(resource);
			String nomeProjeto = resource.getURI().segment(1);
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(nomeProjeto);
			IJavaProject javaProject = JavaCore.create(project);
			List<IClasspathEntry> rawClasspath = ClassPathUtil.recuperaIClasspathEntriesDaVaccina(javaProject);
			for (IClasspathEntry iClasspathEntry : rawClasspath) {
				String path = ClassPathUtil.recuperaPathVaccine(javaProject, iClasspathEntry);
				URI uri = URI.createURI(path);
				temp.add(uri);
			}
		} catch (Exception e) {
			log.warning("Ainda não foi possível recuperar os importes da limguagem ASML.");
		}
		return temp;
	}
}
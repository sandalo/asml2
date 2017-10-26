package asmlbuilder.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import asmlbuilder.Activator;
import asmlbuilder.view.preferences.PreferenceConstants;
import br.ufmg.dcc.asml.ComponentInstance;

public class ASMLResourceVisitor implements IResourceVisitor {
	protected ASMLContext asmlContext;

	private IProject iProject;

	public ASMLResourceVisitor(ASMLContext cacheASML) {
		this.asmlContext = cacheASML;
	}

	public boolean visit(IResource resource) {
		if (resource instanceof IProject)
			return true;
		if ((resource.getFileExtension() + "").equals("class")) {
			return false;
		}

		boolean deep = deep(resource);
		boolean ignoreResource = ignoreResource(resource);

		if (ignoreResource && deep) {
			return false;
		}

		if (ignoreResource) {
			return true;
		}

		ComponentInstance componentInstance = asmlContext.getComponentInstanceByIResourceName(resource);
		if (componentInstance == null) {
			componentInstance = ComponentInstance.createInstance(resource, false);
/*			if (resource.getFileExtension() == null || !resource.getFileExtension().equals("java")) {
				componentInstance = ComponentInstance.createInstance(resource, false, null);
			} else {
				throw new RuntimeException("Recurso sem componentInstance. "+resource);
			} 
*/		}
		this.asmlContext.addComponentInstance(componentInstance);
		if (resource instanceof IFile && resource.getFileExtension().equals("java")){
			parse(componentInstance);
		}
		return true;
	}

	protected boolean ignoreResource(IResource resource) {
		boolean ignoreResource = false;
		EList<String> ignores = asmlContext.getAsmlModel(iProject).getIgnore();
		acrescentaIgnoresDaPaginaDePreferencia(ignores);
		try {
			for (String ignore : ignores) {
				String[] segments = resource.getFullPath().segments();
				String segment = resource.getFullPath().segment(segments.length - 1);
				if (!ignore.contains(".")) {
					if (segment.equals(ignore.replace("*", ""))) {
						ignoreResource = true;
						break;
					}
				} else {
					if (!(resource instanceof IFolder) || resource.getName().startsWith(".")) {
						if (segment.equals(ignore.replace("*", ""))) {
							ignoreResource = true;
							break;
						}
					} else if (resource instanceof IFolder) {
						if (segments.length < 2) {
							ignoreResource = true;
							break;
						}
						String segmentParent = resource.getFullPath().segment(segments.length - 2);
						String[] parts = ignore.split("\\.");
						if (parts.length < 2) {
							ignoreResource = true;
							break;
						}
						String ignorePart = parts[parts.length - 1].replace("*", "");
						if (segment.equals(ignorePart)) {
							String ignorePartParent = parts[parts.length - 2];
							if (segmentParent.equals(ignorePartParent)) {
								ignoreResource = true;
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ignoreResource;
	}

	private void acrescentaIgnoresDaPaginaDePreferencia(EList<String> ignores) {
		String filter = Activator.getDefault().getPreferenceStore().getString(PreferenceConstants.P_IGNORE_ARTFACT_FILTER);
		if(!filter.equals("")){
			String[] split = filter.split(",");
			for (String string : split) {
				ignores.add(string);
			}
		}
	}


	protected boolean deep(IResource resource) {
		boolean ignoreResource = false;
		EList<String> ignores = asmlContext.getAsmlModel(iProject).getIgnore();
		try {
			for (String ignore : ignores) {
				String segment = resource.getFullPath().segment(resource.getFullPath().segments().length - 1);
				if (segment.equals(ignore.replace("*", ""))) {
					ignoreResource = ignore.endsWith("*");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ignoreResource;
	}

	// use ASTParse to parse string
	protected void parse(ComponentInstance componentInstance) {
		try {
			componentInstance.clearDependencies();
			ICompilationUnit element = (ICompilationUnit) JavaCore.create(componentInstance.getResource());
			ASTParser parser = ASTParser.newParser(AST.JLS8);
			parser.setSource(element);
			parser.setKind(ASTParser.K_COMPILATION_UNIT);
			parser.setResolveBindings(true);
			final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
			componentInstance.setCompilationUnitAST(cu);
			componentInstance.setType(element.getTypes()[0]);// TODO - Considera apenas um tipo por arquivo...
			ASMLReosurceJavaVisitor reosurceJavaVisitor = asmlContext.getReosurceJavaVisitor();
			reosurceJavaVisitor.setComponentInstance(componentInstance);
			reosurceJavaVisitor.setProject(iProject);
			cu.accept(reosurceJavaVisitor);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

	public IProject getiProject() {
		return iProject;
	}
	
	public void setProject(IProject iProject) {
		this.iProject = iProject;
	}
}
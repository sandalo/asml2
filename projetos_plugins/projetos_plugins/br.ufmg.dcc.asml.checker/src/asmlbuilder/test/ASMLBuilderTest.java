package asmlbuilder.test;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

public class ASMLBuilderTest{

	/*
	 * @Override public Object start(IApplicationContext arg0) throws Exception { try { final String string = "C:\\eclipse-luna\\runtime-EclipseApplication\\sistema2\\.project"; IPath dotProjectFile = new Path(string); final IWorkspace workspace = ResourcesPlugin.getWorkspace(); IProjectDescription projectDescription = workspace.loadProjectDescription(dotProjectFile); IProject project = workspace.getRoot().getProject(projectDescription.getName()); JavaCapabilityConfigurationPage.createProject(project, projectDescription.getLocationURI(), null); } catch (CoreException e) { e.printStackTrace(); } return null; }
	 * 
	 * @Override public void stop() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	public ASMLBuilderTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testBuild() {
		try {
			final String string = "C:\\Users\\Sândalo Bessa\\TI\\ides\\eclipse-luna\\runtime-EclipseApplication\\ssc-admin-comum\\.project";
			IPath dotProjectFile = new Path(string);
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IProjectDescription projectDescription = workspace.loadProjectDescription(dotProjectFile);
			IProject project = workspace.getRoot().getProject(projectDescription.getName());
			project.build(IncrementalProjectBuilder.FULL_BUILD, null);
			System.out.println();
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}
}
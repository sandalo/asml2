package asmlbuilder;

import java.util.List;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IBuildConfiguration;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import asmlbuilder.builder.ASMLProcessor;
import asmlbuilder.view.preferences.PreferenceConstants;

public class ThreadValidation extends Job {

	List<IProject> openedProjects = null;
	boolean build = false;

	public ThreadValidation(List<IProject> openedProjects, boolean build) {
		super("Validação de arquitetura...");
		this.openedProjects = openedProjects;
		this.build = build;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		Activator.getAsmlProcessor().initialize(ASMLProcessor.FULL_BUILD, openedProjects, monitor);
		boolean P_DEBUG = Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_DEBUG);
		Workspace workspace = (Workspace) ResourcesPlugin.getWorkspace();
		IBuildConfiguration[] buildOrder = workspace.getBuildOrder();
		if (build) {
			for (IBuildConfiguration buildOrderConfiguration : buildOrder) {
				for (IProject iProject : openedProjects) {
					if (iProject.equals(buildOrderConfiguration.getProject())) {
						Activator.getAsmlProcessor().fullBuild(iProject, monitor);
					}
				}
			}
		}
		if (P_DEBUG) {
			Activator.getAsmlProcessor().printEstatistica();
			Activator.getAsmlProcessor().printLog();
		}
		return Status.OK_STATUS;
	}
}
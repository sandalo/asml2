package asmlbuilder.view.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;

import asmlbuilder.ThreadValidation;
import asmlbuilder.builder.ASMLNature;
public class ValidateComandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ThreadValidation threadValidation = new ThreadValidation(getOpenedProjects(), true);
		threadValidation.schedule();
		return null;
	}
	private List<IProject> getOpenedProjects() {
		final List<IProject> openedProjects = new ArrayList<IProject>();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject[] projects = workspace.getRoot().getProjects();
		for (IProject iProject : projects) {
			try {
				if (iProject.isOpen()) {
					IProjectNature nature = iProject.getNature(ASMLNature.NATURE_ID);
					if (nature != null)
						openedProjects.add(iProject);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return openedProjects;
	}

}

package asmlbuilder.builder;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import asmlbuilder.Activator;

public class ASMLBuilder extends IncrementalProjectBuilder {

	protected IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor) throws CoreException {
		ASMLProcessor asmlProcessor = Activator.getAsmlProcessor();
		IProject[] build = null;
		IProject project = getProject();
		if (kind == FULL_BUILD) {
			asmlProcessor.fullBuild(project);
		} else if (kind == AUTO_BUILD) {
			IResourceDelta delta = getDelta(project);
			asmlProcessor.autoBuild(delta,project);
		} else if (kind == INCREMENTAL_BUILD) {
			IResourceDelta delta = getDelta(project);
			asmlProcessor.incrementalBuild(delta,project);
		}
		return build;
	}

}

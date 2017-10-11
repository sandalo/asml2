package asmlbuilder.builder;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import asmlbuilder.Activator;
import asmlbuilder.view.preferences.PreferenceConstants;

public class ASMLBuilder extends IncrementalProjectBuilder {

	protected IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor) throws CoreException {
		ASMLProcessor asmlProcessor = Activator.getAsmlProcessor();
		IProject[] build = null;
		IProject project = getProject();
		boolean LIVE_FEEDBACK = Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_LIVE_FEEDBACK);
		boolean BUILD_FEEDBACK = Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_BUILD_FEEDBACK);
		if (kind == FULL_BUILD) {
			if (BUILD_FEEDBACK) {
				asmlProcessor.fullBuild(project, monitor);
			}
		} else if (kind == AUTO_BUILD) {
			if (LIVE_FEEDBACK) {
				IResourceDelta delta = getDelta(project);
				if (delta != null) {
					if (!isMavenChangeOnly(delta)) {
						if (isOpennigProject(delta))
							asmlProcessor.fullBuild(project,monitor);
						else
							asmlProcessor.incrementalBuild(delta, project);
					}
				}
			}
		} else if (kind == INCREMENTAL_BUILD) {
			IResourceDelta delta = getDelta(project);
			if (delta != null) {
				if (!isMavenChangeOnly(delta)) {
					asmlProcessor.incrementalBuild(delta, project);
				}
			}
		}
		return build;
	}

	private boolean isMavenChangeOnly(IResourceDelta delta) {
		IResourceDelta[] affectedChildren = delta.getAffectedChildren();
		if (affectedChildren != null && affectedChildren.length == 1) {
			IResourceDelta iResourceDeltaChildren = affectedChildren[0];
			if (iResourceDeltaChildren.getFullPath().lastSegment().equals("target")) {
				return true;
			}
		}
		return false;
	}

	private boolean isOpennigProject(IResourceDelta delta) {
		IResourceDelta[] affectedChildren = delta.getAffectedChildren();
		if (affectedChildren != null && affectedChildren.length == 0) {
			return true;
		}
		return false;
	}

}

package asmlbuilder.builder;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public class MarkerUtils {
	static public void addMarker(IResource resource, String message, int lineNumber, int severity, String MARKER_TYPE) {
		try {
			if(resource instanceof FileInJar)
				return;
			IMarker marker = resource.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	

	static public void deleteMarkers(IResource file, String MARKER_TYPE) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
		} catch (CoreException ce) {
			ce.printStackTrace();
		}
	}
}

package asmlbuilder.resolution;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;

class QuickFixer implements IMarkerResolutionGenerator {

    public IMarkerResolution[] getResolutions(IMarker arg0) {
    try {
            Object problem = arg0.getAttribute("Whatsup");
            return new IMarkerResolution[] {
            new QuickFix("Fix #1 for "+problem),
            new QuickFix("Fix #2 for "+problem),
            };
        } catch(CoreException e) {
            return new IMarkerResolution[0];
        }
    }
} 

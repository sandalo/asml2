package asmlbuilder.view.navigator.filters;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import asmlbuilder.Activator;
import br.ufmg.dcc.asml.ComponentInstance;

public class ASMLRequiresFilter extends ViewerFilter {

	private String value = null;
	private Set<ComponentInstance> componentInstances = new LinkedHashSet<ComponentInstance>();

	public ASMLRequiresFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean select(Viewer _viewer, Object parentElement, Object element) {
		selectComponentInstance();
		if (componentInstances.size()>0) {
			TreeViewer viewer = (TreeViewer) _viewer;
			viewer.expandToLevel(AbstractTreeViewer. ALL_LEVELS);
			viewer.refresh();
			return true;
		}
		return false;
	}

	private void selectComponentInstance() {
		if (value == null || "".equals(value)) {
			InputDialog dialog = new InputDialog(null, "ASML Rirquires Filter", "Enter a name filter pattern" + " (* = any string, ? = any character)" + System.getProperty("line.separator") + "or an empty string for no filtering:", null, null);
			dialog.open();
			value = dialog.getValue();
			Set<ComponentInstance> componentInstances = Activator.getAsmlProcessor().getAsmlContext().getComponentInstances();
			for (ComponentInstance componentInstance : componentInstances) {
				IResource resource = componentInstance.getResource();
				if (IFile.class.isInstance(resource)) {
					String name = componentInstance.getResource().getName().replace("."+componentInstance.getResource().getFileExtension(),"");
					if (name.toLowerCase().contains(value.toLowerCase())) {
						this.componentInstances.add(componentInstance);
						this.componentInstances.addAll(componentInstance.getComponentInstancesThatRequireMe());
					}
				}
			}
		}
	}
}

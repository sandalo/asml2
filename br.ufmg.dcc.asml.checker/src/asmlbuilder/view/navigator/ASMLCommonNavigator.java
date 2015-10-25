package asmlbuilder.view.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.navigator.CommonNavigator;

import br.ufmg.dcc.asml.ComponentInstance;

public class ASMLCommonNavigator extends CommonNavigator {

	@Override
	protected void handleDoubleClick(DoubleClickEvent anEvent) {
		try {
			System.out.println();
			ISelection selection = anEvent.getSelection();
			if (TreeSelection.class.isInstance(selection)) {
				TreeSelection treeSelection = (TreeSelection) selection;
				if (treeSelection.getFirstElement() instanceof ComponentInstance) {
					ComponentInstance componentInstance = (ComponentInstance) treeSelection.getFirstElement();
					IWorkbench wb = PlatformUI.getWorkbench();
					IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
					if (IFile.class.isInstance(componentInstance.getResource())) {
						IFile file = (IFile) componentInstance.getResource();
						IDE.openEditor(win.getActivePage(), file);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		super.handleDoubleClick(anEvent);
	}
	
}

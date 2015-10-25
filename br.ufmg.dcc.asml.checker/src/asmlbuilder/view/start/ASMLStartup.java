package asmlbuilder.view.start;

import org.eclipse.ui.IStartup;

import asmlbuilder.Activator;

public class ASMLStartup implements IStartup {

	@Override
	public void earlyStartup() {
		Activator activator = Activator.getDefault();
		activator.notifyAll();
	}

}

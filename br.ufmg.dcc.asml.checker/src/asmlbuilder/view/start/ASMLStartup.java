package asmlbuilder.view.start;

import org.eclipse.ui.IStartup;

import asmlbuilder.Activator;

public class ASMLStartup implements IStartup {

	@Override
	public void earlyStartup() {
		Activator activator = Activator.getDefault();
		try {
			activator.notifyAll();
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

}

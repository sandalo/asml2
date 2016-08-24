package asmlbuilder.view.console;

import java.io.IOException;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

import asmlbuilder.Activator;
import asmlbuilder.view.preferences.PreferenceConstants;

public class ASMLConsoleFactory implements IConsoleFactory {

	private static MessageConsole _console;

	public void openConsole() {
		MessageConsole console = getConsole();
		if (console != null) {
			IConsoleManager manager = ConsolePlugin.getDefault()
					.getConsoleManager();
			IConsole[] existing = manager.getConsoles();
			boolean exists = false;
			for (int i = 0; i < existing.length; i++) {
				if (console == existing[i])
					exists = true;
			}
			if (!exists)
				manager.addConsoles(new IConsole[] { console });
			manager.showConsoleView(console);
		}

	}

	public static MessageConsole getConsole() {
		if (_console == null) {
			String string = "ConsoleASML";
			_console = new MessageConsole(string, null);
		}
		return _console;
	}

	public static void print(String msg) {
		boolean DEBUG = Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_DEBUG);
		if (DEBUG) {
			try {
				ASMLConsoleFactory.getConsole().activate();
				ASMLConsoleFactory.getConsole().newOutputStream().write("\n" + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

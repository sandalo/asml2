package asmlbuilder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import asmlbuilder.builder.ASMLNature;
import asmlbuilder.builder.ASMLProcessor;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	final List<IProject> openedProjects = new ArrayList<IProject>();

	private final class PosBuilderWorkspaceBuilder implements IResourceChangeListener {

		private IWorkspace workspace;

		private PosBuilderWorkspaceBuilder(IWorkspace workspace) {
			this.workspace = workspace;
			workspace.addResourceChangeListener(this, IResourceChangeEvent.POST_BUILD);
		}

		public void resourceChanged(IResourceChangeEvent event) {
		//	asmlProcessor.printEstatistica();
/*			Object source = event.getSource();
			IResourceDelta delta = event.getDelta();
			if (delta != null && source instanceof IWorkspace) {
				IResourceDelta[] affectedChildren = delta.getAffectedChildren();
				for (IResourceDelta iResourceDelta : affectedChildren) {
					if (iResourceDelta.getResource() instanceof IProject) {
						IProject iProjectVaccine = (IProject) iResourceDelta.getResource();
						if (iProjectVaccine.isOpen() && iProjectVaccine.getName().contains("vaccine")) {
							asmlProcessor.initialize(ASMLProcessor.FULL_BUILD, openedProjects);
						}
					}
				}
				asmlProcessor.printEstatistica();
			}
*/		}
	}

	// The plug-in ID
	public static final String PLUGIN_ID = "br.ufmg.dcc.asml.checker"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private static ASMLProcessor asmlProcessor = new ASMLProcessor();

	public static ASMLProcessor getAsmlProcessor() {
		return asmlProcessor;
	}

	private static MessageConsole console;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResourceChangeListener listener = new PosBuilderWorkspaceBuilder(workspace);
		/*
		 * // ... some time later one ... workspace.removeResourceChangeListener(listener);
		 */
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
		asmlProcessor.initialize(ASMLProcessor.FULL_BUILD, openedProjects);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path
	 *
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public static MessageConsole console(IConsoleView view) {
		try {
			final String id_console = PLUGIN_ID + "_CONSOLE";
			if (console == null || view == null) {
				if (console == null)
					console = new MessageConsole(id_console, null);
			}
			if (view != null)
				view.display(console);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (MessageConsole) console;
	}
}

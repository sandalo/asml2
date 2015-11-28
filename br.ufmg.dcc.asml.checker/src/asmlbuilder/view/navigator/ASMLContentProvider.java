package asmlbuilder.view.navigator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.navigator.CommonViewer;

import asmlbuilder.Activator;
import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.ASMLNature;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.ASMLModel;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class ASMLContentProvider implements ITreeContentProvider, IResourceChangeListener {

	private static final Object[] NO_CHILDREN = {};
	private ASMLModel[] _customProjectParents;
	private Viewer _viewer;

	public ASMLContentProvider() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		//_viewer.refresh();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] children = null;
		if (IWorkspaceRoot.class.isInstance(parentElement)) {
			if (_customProjectParents == null) {
				_customProjectParents = initializeParent(parentElement);
			}
			children = _customProjectParents;
		} else if (ASMLModel.class.isInstance(parentElement)) {
			EList<AbstractComponent> components = ((ASMLModel) parentElement).getComponents();
			List<ComponentInstance> childrenInstances = new ArrayList<ComponentInstance>();
			if (components != null) {
				for (AbstractComponent abstractComponent : components) {
					Set<ComponentInstance> instances2 = abstractComponent.getInstances();
					childrenInstances.addAll(instances2);
				}
			}
			children = childrenInstances.toArray();
		} else if (ComponentInstance.class.isInstance(parentElement)) {
			ComponentInstance componentInstance = (ComponentInstance) parentElement;
			IResource resource = componentInstance.getResource();
			IResource[] members = new IResource[] {};
			if (IFolder.class.isInstance(resource)) {
				IFolder folder = (IFolder) resource;
				try {
					members = folder.members();
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
			List<ComponentInstance> childrenInstances = new ArrayList<ComponentInstance>();
			for (IResource iResource : members) {
				ASMLContext asmlContext = Activator.getAsmlProcessor().getAsmlContext();
				ComponentInstance componentInstanceByIResourceName = asmlContext.getComponentInstanceByIResourceName(iResource);
				if (componentInstanceByIResourceName != null)
					childrenInstances.add(componentInstanceByIResourceName);
			}
			children = childrenInstances.toArray();
		} else {
			children = NO_CHILDREN;
		}
		return children;
	}

	private ASMLModel[] initializeParent(Object parentElement) {
		IWorkspaceRoot root = (IWorkspaceRoot) parentElement;
		IProject[] projects = root.getProjects();

		List<ASMLModel> list = new Vector<ASMLModel>();
		for (int i = 0; i < projects.length; i++) {
			try {
				IProject iProject = projects[i];
				if (iProject.isOpen())
					if (iProject.getNature(ASMLNature.NATURE_ID) != null) {
						ASMLModel asmlModel = Activator.getAsmlProcessor().getAsmlContext().getAsmlModel(iProject);
						list.add(asmlModel);
					}
			} catch (CoreException e) {
				// Go to the next IProject
			}
		}

		ASMLModel[] result = new ASMLModel[list.size()];
		list.toArray(result);

		return result;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		_viewer = viewer;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object getParent(Object element) {
		Object parent = null;
		if (ASMLModel.class.isInstance(element)) {
			parent = ((ASMLModel) element).getProject().getWorkspace();
		} else if (ComponentInstance.class.isInstance(element)) {
			parent = ((ComponentInstance) element).getComponent().eContainer();
		}
		return parent;
	}

	@Override
	public boolean hasChildren(Object element) {
		boolean hasChildren = false;
		try {
			if (IWorkspaceRoot.class.isInstance(element)) {
				hasChildren = ((IWorkspaceRoot) element).getProjects().length > 0;
			} else if (ASMLModel.class.isInstance(element)) {
				hasChildren = ((ASMLModel) element).getComponents().size() > 0;
			} else if (ComponentInstance.class.isInstance(element)) {
				ComponentInstance componentInstance = (ComponentInstance) element;
				if (componentInstance.getComponent() != null) {
					AbstractComponent component = ((ComponentInstance) element).getComponent();
					hasChildren = component.getAllComponentInstances().size() > 0;
				} else {
					hasChildren = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hasChildren;
	}

}

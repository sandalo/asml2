package asmlbuilder.matching;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.JavaModelException;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.constants.ASMLConstant;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.ASMLModel;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.Attribute;
import br.ufmg.dcc.asml.aSMLModel.MetaModule;
import br.ufmg.dcc.asml.aSMLModel.View;

public class ModuleMatching extends AbstraticMatching implements IMatching {

	public ModuleMatching(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public boolean matching(ComponentInstance resource, AbstractComponent component) {
		if (resource.getResource() instanceof IFolder) {
			try {
				String[] resourceSegments = resource.getResource().getFullPath().segments();
				if (resource.getResource().getName().equals(component.getName())) {
					String fisicalPathComponent = getFullPathComponent(component, false);
					String[] componenteSegments = fisicalPathComponent.split("\\.");
					if (componenteSegments.length != resourceSegments.length)
						return false;
					return comparePath(resourceSegments, componenteSegments);
				} else {
					String nameSpace = getNameSpace(component);
					if (!nameSpace.equals("")) {
						int position = getPositionInNameSpace(resource.getResource(), component);
						if (position == -1)
							return false;
						String fisicalPathComponent = getFullPathComponent(component, true);
						String[] componenteSegments = fisicalPathComponent.split("\\.");
						String[] componenteSegmentsAux = new String[position + 1];
						System.arraycopy(componenteSegments, 0, componenteSegmentsAux, 0, componenteSegmentsAux.length);// Discarta
						boolean comparePath = comparePath(resourceSegments, componenteSegmentsAux);
						return comparePath;
					}
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;

		/*
		 * if ((component instanceof Module) && resource instanceof IFolder) {
		 * Module module = (Module) component; boolean isNameSapce =
		 * isNameSpace(resource, module); if (isNameSapce) { return true; } else
		 * { String resourceName = resource.getName(); String fullPath =
		 * resource.getFullPath().toString().replaceAll("/", "."); if
		 * (fullPath.endsWith(module.getName())) { return true; } boolean
		 * basicMatching = resourceName.equals(module.getName()) ||
		 * module.getName().contains(resourceName + ".") ||
		 * module.getName().contains("." + resourceName); return basicMatching;
		 * } } return false;
		 */}

	private boolean comparePath(String[] resourceSegments, String[] componenteSegments) {
		for (int i = resourceSegments.length - 1; i >= 0; i--) {
			String string = componenteSegments[i];
			if (string.equals("MetaModule")) {
				continue;
			}
			String string2 = resourceSegments[i];
			if (!string.equals(string2)) {
				return false;
			}
		}
		return true;
	}

	public static String getFullPathComponent(AbstractComponent componentAux, boolean withNameSpace) {
		EObject eObject = componentAux;
		String fisicalPathComponent = "";
		if (withNameSpace) {
			while (eObject != null && !(eObject instanceof View)) {
				/**
				 * Este token(MetaModule) será utilizado para que a lógica
				 * ignore a coparações com resources físicos, pois os meta
				 * modulos // são / abstratos
				 */
				if (eObject instanceof MetaModule) {
					String nameSpace = ModuleMatching.getNameSpace((AbstractComponent) eObject);
					if (nameSpace.equals(""))
						fisicalPathComponent = ((AbstractComponent) eObject).getName() + "." + fisicalPathComponent;
					else
						fisicalPathComponent = nameSpace + "." + fisicalPathComponent;
				}
				eObject = eObject.eContainer();
			}
		} else {
			while (eObject != null && !(eObject instanceof View)) {
				/**
				 * Este token(MetaModule) será utilizado para que a lógica
				 * ignore a coparações com resources físicos, pois os meta
				 * modulos // são / abstratos
				 */
				if (eObject instanceof MetaModule) {
					fisicalPathComponent = "{?}" + "." + fisicalPathComponent;
				} else {
					fisicalPathComponent = ((AbstractComponent) eObject).getName() + "." + fisicalPathComponent;
				}
				eObject = eObject.eContainer();
			}
		}
		return fisicalPathComponent;
	}

	public static boolean isNameSpace(IResource resource, AbstractComponent abstractComponent) {
		boolean isNameSapce = false;
		EList<Attribute> attributes = abstractComponent.getAttributes();
		if (!attributes.isEmpty() && attributes.get(0).getName().equals("namespace")) {
			String resourceName = resource.getName();
			Attribute attribute = attributes.get(0);
			String[] names = attribute.getValue().split("\\.");
			for (String name : names) {
				if (resourceName.equals(name)) {
					isNameSapce = true;
					QualifiedName qualifiedName = new QualifiedName(ASMLConstant.BUILDER_ID, "namespace");
					try {
						resource.getPersistentProperties().put(qualifiedName, "true");
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return isNameSapce;
	}

	public static int getPositionInNameSpace(IResource resource, AbstractComponent abstractComponent) {
		String value = getFullPathComponent(abstractComponent, true);
		String nameSpace = getNameSpace(abstractComponent);
		String[] names = value.split("\\.");
		int initial = names.length - 1;
		int final_ = initial - nameSpace.split("\\.").length;
		for (int i = initial; i > final_; i--) {
			if (resource.getName().equals(names[i])) {
				return i;
			}
		}
		return -1;
	}

	public static String getNameSpace(AbstractComponent abstractComponent) {
		if (abstractComponent == null)
			return "";
		if (abstractComponent.getMatching() == null){
			if (abstractComponent.getName() == null)
				return "";
			else
				return abstractComponent.getName();
		}else{
			return abstractComponent.getMatching();
		}
	}

/*	public static boolean isJavaPackage(IResource resource, ASMLContext asmlContext) {
		IPackageFragment packageFragment;
		try {
			packageFragment = asmlContext.getJavaProject().findPackageFragment(resource.getFullPath());
			if (packageFragment == null)
				return false;
			packageFragment.getElementName();
			if (packageFragment.getElementName().equals("")) {
				return false;
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return true;
	}
*/
	public static int getResourceLevel(IResource resource) throws JavaModelException {
		return resource.getFullPath().segmentCount() - 1;
	}

	public static int geModuleLevel(EObject module) {
		int level = 1;
		EObject parent;
		parent = module.eContainer();
		while (parent != null && parent instanceof ASMLModel) {
			EList<Attribute> attributes = null;
			attributes = ((AbstractComponent) (parent)).getAttributes();
			if (!attributes.isEmpty() && attributes.get(0).getName().equals("namespace")) {
				Attribute attribute = attributes.get(0);
				String[] names = attribute.getValue().split("\\.");
				level = level + names.length;
			} else {
				level++;
			}
			parent = (EObject) parent.eContainer();
		}
		return level;
	}

}

package asmlbuilder.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;

import br.ufmg.dcc.asml.ComponentInstance;

public class ASMLResourceDeltaVisitor extends ASMLResourceVisitor implements IResourceDeltaVisitor {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse .core.resources.IResourceDelta)
	 */

	public ASMLResourceDeltaVisitor(ASMLContext aSMLContext) {
		super(aSMLContext);
	}

	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if ((resource.getFileExtension() + "").equals("class")) {
			return false;
		}
		boolean deep = deep(resource);
		boolean ignoreResource = ignoreResource(resource);

		if (ignoreResource && deep) {
			return false;
		}

		if (ignoreResource) {
			return true;
		}

		ComponentInstance componentInstance = null;
		switch (delta.getKind()) {
		case IResourceDelta.ADDED:
			componentInstance = (ComponentInstance) asmlContext.getComponentInstanceByIResourceName(resource);
			if (componentInstance != null)
//				throw new RuntimeException("Erro  ao adiconar novo recurso para uma instancia já existente, se o recurso é novo não deveria existir instancia de componente associado ao recurso");
				asmlContext.removeComponentInstance(componentInstance);
			componentInstance = ComponentInstance.createInstance(resource, false, null);
			asmlContext.addComponentInstance(componentInstance);
			break;
		case IResourceDelta.REMOVED:
			componentInstance = (ComponentInstance) asmlContext.getComponentInstanceByIResourceName(resource);
			if (componentInstance == null)
				return true;
			asmlContext.removeComponentInstance(componentInstance);
			break;
		case IResourceDelta.CHANGED:
			componentInstance = (ComponentInstance) asmlContext.getComponentInstanceByIResourceName(resource);
			if (componentInstance == null)
				return true;
			componentInstance.setResource(resource);
			break;
		}
		if (resource instanceof IFile && resource.getFileExtension().equals("java"))
			if (delta.getKind() != IResourceDelta.REMOVED)
				parse(componentInstance);
		return true;
	}
}

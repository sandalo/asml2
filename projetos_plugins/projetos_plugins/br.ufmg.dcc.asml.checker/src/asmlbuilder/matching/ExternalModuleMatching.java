package asmlbuilder.matching;

import asmlbuilder.builder.ASMLContext;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class ExternalModuleMatching extends AbstraticMatching implements IMatching {

	public ExternalModuleMatching(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public boolean matching(ComponentInstance resource, AbstractComponent component) {//TODO: Rever implementação, tentar indentificar external modules através de jars
/*		if ((component instanceof ExternalModule) && resource.getResource() instanceof IFolder) {
			try {
				boolean isNameSapce = ModuleMatching.isNameSpace(resource.getResource(), component);
				if (isNameSapce) {
					return true;
				} else {
					EObject parent = component.eContainer();
					while (parent != null && parent instanceof Module) {
						if (ModuleMatching.isNameSpace(resource.getResource(), (Module) parent)) {
							return false;
						}
						parent = (EObject) parent.eContainer();
					}
					if (ModuleMatching.isJavaPackage(resource.getResource(), asmlContext) && !ModuleMatching.isNameSpace(resource.getResource(), component)) {
						int level = ModuleMatching.geModuleLevel(component);
						int level2 = ModuleMatching.getResourceLevel(resource.getResource());
						if (level == level2)
							return true;
						else
							return false;
					}
				}
				return false;
			} catch (JavaModelException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
*/
	return false;	
	}
}
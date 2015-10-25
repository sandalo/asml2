package asmlbuilder.restriction.extend;

import java.util.Set;

import org.eclipse.jdt.core.dom.TypeDeclaration;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class OnlyCanExtends extends RestricionChecker {

	public OnlyCanExtends(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(Restriction restriction) {
		onlyComponentACanExtendComponentB(restriction);
	}

	private void onlyComponentACanExtendComponentB(Restriction restriction) {
		AbstractComponent componentA =  (AbstractComponent) restriction.eContainer();
		AbstractComponent componentB = null;//restriction.getComponentB();
		int lineNumber = 0;
		for (ComponentInstance instance : asmlContext.getComponentInstances()) {
			boolean extend = false;
			boolean isA = false;
			Set<ComponentInstanceReference> references = instance.getDependencies(RelactionType.EXTEND);
			for (ComponentInstanceReference reference : references) {
				ComponentInstance componentInstanceReferenced = reference.getComponentInstanceReferenced();
				extend = componentInstanceReferenced.extendsAtLeastOneOf(componentB);
				if (extend) {
					isA = componentInstanceReferenced.instanceOf(componentA);
					if (!isA) {
						lineNumber = reference.getLineNumber();
						String defaultMessage = "Somente  classes do tipo  " + componentA.getName() + " podem herdar de classe do tipo " + componentB.getName();
						addViolation(restriction, lineNumber, instance, defaultMessage);
					}
				}
			}
		}
	}

}

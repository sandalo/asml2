package asmlbuilder.restriction.implement;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation.DependecyType;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class OnlyCanImplement extends RestricionChecker {

	public OnlyCanImplement(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(AbstractComponent componentA, Restriction restriction, List<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations) {
		onlyComponentACanImplementComponentB(restriction);
	}

	private void onlyComponentACanImplementComponentB(Restriction restriction) {
		AbstractComponent componentA = (AbstractComponent) restriction.eContainer();
		AbstractComponent componentB = null;//restriction.getComponentB();
		int lineNumber = 0;
		for (ComponentInstance instance : asmlContext.getComponentInstances()) {
			boolean extend = false;
			boolean isA = false;
			Set<ComponentInstanceReference> references = instance.getDependencies(RelactionType.IMPLEMENT);
			for (ComponentInstanceReference reference : references) {
				ComponentInstance componentInstanceReferenced = reference.getComponentInstanceReferenced();
				extend = componentInstanceReferenced.extendsAtLeastOneOf(componentB);
				if (extend) {
					isA = componentInstanceReferenced.instanceOf(componentA);
					if (!isA) {
						lineNumber = reference.getLineNumber();
						String defaultMessage = "Somente  classes do tipo  " + componentA.getName() + " podem herdar de classe do tipo " + componentB.getName();
						addViolation(restriction, lineNumber, instance, defaultMessage,IMarker.SEVERITY_ERROR, DependecyType.COMPILE,"ONLY_CAN_IMPLEMENTS");
					}
				}
			}
		}
	}

}

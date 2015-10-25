package asmlbuilder.restriction.useannotation;

import java.util.Set;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class UseAnnotation extends RestricionChecker {

	public UseAnnotation(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(Restriction restriction) {
			componentACannotUseAnnotationCompontB(restriction);
	}

	private void componentACannotUseAnnotationCompontB(Restriction restriction) {
		AbstractComponent componentA =  (AbstractComponent) restriction.eContainer();
		AbstractComponent componentB = null;//restriction.getComponentB();
		Set<ComponentInstance> instancesOfA = componentA.getInstances();
		int lineNumber = 1;
		for (ComponentInstance instanceOfA : instancesOfA) {
			Set<ComponentInstanceReference> references = instanceOfA.getDependencies(RelactionType.USEANOTATION);
			for (ComponentInstanceReference reference : references) {
				ComponentInstance componentInstanceReferenced = reference.getComponentInstanceReferenced();
				if (componentInstanceReferenced!=null) {
					if (componentInstanceReferenced.instanceOf(componentB)) {
						lineNumber = reference.getLineNumber();
						addViolation(restriction, lineNumber, instanceOfA, "Classes do componete " + componentA.getName() + " não podem usar anotações: " + componentB.getName());
					}
				}
			}
		}
	}
}

package asmlbuilder.restriction.useannotation;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IMarker;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation.DependecyType;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class UseAnnotation extends RestricionChecker {

	public UseAnnotation(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(AbstractComponent componentA, Restriction restriction, List<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations) {
			componentACannotUseAnnotationCompontB(restriction);
	}

	private void componentACannotUseAnnotationCompontB(Restriction restriction) {
		AbstractComponent componentA =  (AbstractComponent) restriction.eContainer();
		AbstractComponent componentB = (AbstractComponent) restriction.getComponentB().iterator().next();
		Set<ComponentInstance> instancesOfA = componentA.getInstances();
		int lineNumber = 1;
		for (ComponentInstance instanceOfA : instancesOfA) {
			Set<ComponentInstanceReference> references = instanceOfA.getDependencies(RelactionType.USEANOTATION);
			for (ComponentInstanceReference reference : references) {
				ComponentInstance componentInstanceReferenced = reference.getComponentInstanceReferenced();
				if (componentInstanceReferenced!=null) {
					if (componentInstanceReferenced.instanceOf(componentB)) {
						lineNumber = reference.getLineNumber();
						addViolation(restriction, lineNumber, instanceOfA, "Classes do componete " + componentA.getName() + " n�o podem usar anota��es: " + componentB.getName(),IMarker.SEVERITY_ERROR, DependecyType.COMPILE,"CANNOT_USE_ANNOTATION");
					}
				}
			}
		}
	}
}

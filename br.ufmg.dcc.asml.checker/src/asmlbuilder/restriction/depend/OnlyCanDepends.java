package asmlbuilder.restriction.depend;

import java.util.Set;

import org.eclipse.core.resources.IMarker;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation.DependecyType;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class OnlyCanDepends extends RestricionChecker {

	public OnlyCanDepends(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(Restriction restriction) {
		onlyComponentACanDependCompontB(restriction);
	}

	void onlyComponentACanDependCompontB(Restriction restriction) {
		AbstractComponent componentA =  (AbstractComponent) restriction.eContainer();
		AbstractComponent componentB = (AbstractComponent) restriction.getComponentB().iterator().next();
		Set<ComponentInstance> allInstances = asmlContext.getComponentInstances();
		for (ComponentInstance componentInstance : allInstances) {
			Set<ComponentInstanceReference> references = componentInstance.getDependencies();
			for (ComponentInstanceReference reference : references) {
				ComponentInstance componentInstanceReferenced = reference.getComponentInstanceReferenced();
				ComponentInstance componentInstanceOwner = reference.getComponentInstanceDependent();
				if(componentInstanceReferenced ==null)
					continue;
				AbstractComponent componentOwner = componentInstanceOwner.getComponent();
				AbstractComponent componentReferenced = componentInstanceReferenced.getComponent();
				if(!componentOwner.equals(componentA) && (componentReferenced.equals(componentB)) || componentReferenced.isChild(componentB)){
					addViolation(restriction, reference.getLineNumber(), componentInstance, "Componente não pode depender de "+componentB.getName(),IMarker.SEVERITY_ERROR, DependecyType.COMPILE,"ONLY_CAN_DEPENDS");
				}
			}
		}
	}
}

package asmlbuilder.restriction.access;

import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jdt.core.dom.MethodInvocation;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation.DependecyType;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class CannotAccess extends RestricionChecker {

	public CannotAccess(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(Restriction restriction) {
		componentACannnotAccessCompontB(restriction);
	}

	void componentACannnotAccessCompontB(Restriction restriction) {
		AbstractComponent componentA =  (AbstractComponent) restriction.eContainer();
		AbstractComponent componentB = null;//restriction.getComponentB();
		for (ComponentInstance componentInstance : componentA.getAllComponentInstances()) {
			Set<ComponentInstanceReference> references = componentInstance.getDependencies(RelactionType.ACCESS);
			for (ComponentInstanceReference reference : references) {
				ComponentInstance componentInstanceReferenced = reference.getComponentInstanceReferenced();
				if (componentInstanceReferenced == null)
					continue;
				AbstractComponent componentReferenced = componentInstanceReferenced.getComponent();
				if ((componentReferenced.equals(componentB)) || componentReferenced.isChild(componentB)) {
					addViolation(restriction, reference.getLineNumber(), componentInstance, "Componente não pode acessas métodos de " + componentB.getName(),IMarker.SEVERITY_ERROR, DependecyType.COMPILE,"CANNOT_ACCESS");
				}
			}
		}
	}

}

package asmlbuilder.restriction.declare;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.EList;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation.DependecyType;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;
import br.ufmg.dcc.asml.aSMLModel.WildCard;

public class CannotDeclare extends RestricionChecker {

	public CannotDeclare(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(AbstractComponent componentA, Restriction restriction,  List<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations) {
		componentACannnotDeclareCompontB(restriction);
	}

	void componentACannnotDeclareCompontB(Restriction restriction) {
		AbstractComponent componentA = (AbstractComponent) restriction.eContainer();
		EList<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations = restriction.getComponentB();
		for (ComponentsBinRestrictionDeclareation ComponentsBinRestrictionDeclareation : componentsBinRestrictionDeclareations) {
			for (ComponentInstance componentInstance : componentA.getAllComponentInstances()) {
				Set<ComponentInstanceReference> references = componentInstance.getDependencies(RelactionType.DECLARE);
				for (ComponentInstanceReference reference : references) {
					ComponentInstance componentInstanceReferenced = reference.getComponentInstanceReferenced();
					if (componentInstanceReferenced == null)
						continue;
					AbstractComponent componentReferenced = componentInstanceReferenced.getComponent();
					if(componentReferenced==null)
						continue;
					AbstractComponent componentB = ComponentsBinRestrictionDeclareation.getComponentB();
					if ((componentReferenced.equals(componentB))) {
						addViolation(restriction, reference.getLineNumber(), componentInstance, "Componente não pode declar " + componentB.getName(),IMarker.SEVERITY_ERROR, DependecyType.COMPILE, "CANNOT_DECLARE");
					}
					if (ComponentsBinRestrictionDeclareation.getWildcard().equals(WildCard.PACKAGE_AND_SUB_PACKAGE) && componentReferenced.isChild(componentB)) {
						addViolation(restriction, reference.getLineNumber(), componentInstance, "Componente não pode declar " + componentB.getName(),IMarker.SEVERITY_ERROR, DependecyType.COMPILE,"CANNOT_DECLARE");
					}
				}
			}
		}
	}

}

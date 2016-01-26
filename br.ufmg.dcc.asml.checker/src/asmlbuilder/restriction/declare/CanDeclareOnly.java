package asmlbuilder.restriction.declare;

import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.IType;

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

public class CanDeclareOnly extends RestricionChecker {

	public CanDeclareOnly(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(Restriction restriction) {
		componentACanDeclareOnlyCompontB(restriction);
	}

	void componentACanDeclareOnlyCompontB(Restriction restriction) {
		AbstractComponent componentA = (AbstractComponent) restriction.eContainer();
		Set<ComponentInstance> allInstancesOfA = componentA.getAllComponentInstances();
		String fullyQualifiedName = "";
		for (ComponentInstance componentInstanceA : allInstancesOfA) {
			IResource resource = componentInstanceA.getResource();
			if ((resource.getFileExtension() + "").equals("java")) {
				Set<ComponentInstanceReference> references = componentInstanceA.getDependencies(RelactionType.DECLARE);
				for (ComponentInstanceReference reference : references) {
					boolean valideReference = false;
					ComponentInstance componentInstanceReferenced = reference.getComponentInstanceReferenced();
					if (componentInstanceReferenced == null) {
						continue;//TODO - Resolver problema componentInstanceReferenced sem componenteInstancia
					}
					AbstractComponent component = componentInstanceReferenced.getComponent();
					if(component==null)
						continue;
					if(component.isChild(componentA))
						continue;
					EList<ComponentsBinRestrictionDeclareation> componentesB = restriction.getComponentB();
					fullyQualifiedName = componentInstanceReferenced.getType().getFullyQualifiedName();
					componenteB: for (ComponentsBinRestrictionDeclareation componentsBinRestrictionDeclareation : componentesB) {
						if(componentsBinRestrictionDeclareation.getWildcard().equals(WildCard.PACKAGE) || componentsBinRestrictionDeclareation.getWildcard() == null){
							if (componentsBinRestrictionDeclareation.getComponentB().containsType(fullyQualifiedName)) {
								valideReference = true;
								break componenteB;
							}
						}else if(componentsBinRestrictionDeclareation.getWildcard().equals(WildCard.PACKAGE_AND_SUB_PACKAGE)) {
							if (componentsBinRestrictionDeclareation.getComponentB().fullContainsType(fullyQualifiedName)) {
								valideReference = true;
								break componenteB;
							}
						} 
					}
					if (!valideReference) {
						String defaultMessage = " Classes do componente " + componentA.getName() + " não podem declarar "+ fullyQualifiedName+".";
								//"\n Classes do componente " + componentA.getName() + " podem declarar somente classes do(s) componente(s) :\n" + getComponentNames(restriction);
						addViolation(restriction, reference.getLineNumber(), reference.getComponentInstanceDependent(), defaultMessage, IMarker.SEVERITY_ERROR, DependecyType.COMPILE ,"CAN_DECLARE_ONLY");
					}
				}
			}
		}
	}
}

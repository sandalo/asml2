package asmlbuilder.restriction.declare;

import java.util.List;
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
	public void checker(AbstractComponent componentA, Restriction restriction,  List<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations) {
		componentACanDeclareOnlyCompontB(componentA, restriction, componentsBinRestrictionDeclareations);
	}

	void componentACanDeclareOnlyCompontB(AbstractComponent componentA, Restriction restriction, List<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations) {
//		AbstractComponent componentA = (AbstractComponent) restriction.eContainer();
		Set<ComponentInstance> allInstancesOfA = componentA.getInstances();
		String fullyQualifiedName = "";
		for (ComponentInstance componentInstanceA : allInstancesOfA) {
			IResource resource = componentInstanceA.getResource();
			if ((resource.getFileExtension() + "").equals("java")) {
				Set<ComponentInstanceReference> references = componentInstanceA.getDependencies(RelactionType.DECLARE);
				for (ComponentInstanceReference reference : references) {
					if(reference.isVerified(CanDeclareOnly.class.getName()))
						continue;
					boolean isViolataion = true;
					ComponentInstance componentInstanceReferenced = reference.getComponentInstanceReferenced();
					if (componentInstanceReferenced == null) {
						continue;//TODO - Resolver problema componentInstanceReferenced sem componenteInstancia
					}
					AbstractComponent component = componentInstanceReferenced.getComponent();
					if(component==null)
						continue;
					if(component.isChild(componentA))
						continue;
					//EList<ComponentsBinRestrictionDeclareation> componentesB = restriction.getComponentB();
					fullyQualifiedName = componentInstanceReferenced.getType().getFullyQualifiedName();
					componenteB: for (ComponentsBinRestrictionDeclareation componentsBinRestrictionDeclareation : componentsBinRestrictionDeclareations) {
						if(componentsBinRestrictionDeclareation.getWildcard().equals(WildCard.PACKAGE) || componentsBinRestrictionDeclareation.getWildcard() == null){
							if (componentsBinRestrictionDeclareation.getComponentB().containsType(fullyQualifiedName)) {
								isViolataion = false;
								break componenteB;
							}
						}else if(componentsBinRestrictionDeclareation.getWildcard().equals(WildCard.PACKAGE_AND_SUB_PACKAGE)) {
							if (componentsBinRestrictionDeclareation.getComponentB().fullContainsType(fullyQualifiedName)) {
								isViolataion = false;
								break componenteB;
							}
						} 
					}
					if (isViolataion) {
						String defaultMessage = "Classes  do componente  " + componentA.getName() + " não podem declarar "+ fullyQualifiedName+".";
						if(!reference.getComponentInstanceDependent().isSubClasse(reference.getComponentInstanceReferenced()))
							addViolation(restriction, reference.getLineNumber(), reference.getComponentInstanceDependent(), defaultMessage, IMarker.SEVERITY_ERROR, DependecyType.COMPILE ,"CAN_DECLARE_ONLY");
					}
					reference.verified(CanDeclareOnly.class.getName());
				}
			}
		}
	}
}

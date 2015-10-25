package asmlbuilder.restriction.implement;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class MustImplement extends RestricionChecker {

	public MustImplement(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(Restriction restriction) {
		anyComponentAMustImplementCompontB(restriction);
	}

	private void anyComponentAMustImplementCompontB(Restriction restriction) {
		AbstractComponent componentA = (AbstractComponent) restriction.eContainer();
		EList<AbstractComponent> componentesB = restriction.getComponentB();
		boolean extend = false;
		for (AbstractComponent componentB : componentesB) {
			int lineNumber = 0;
			for (ComponentInstance instancesOfA : componentA.getAllComponentInstances()) {
				Set<ComponentInstanceReference> referencesOfInstaceOfA = instancesOfA.getDependencies(RelactionType.IMPLEMENT);
				for (ComponentInstanceReference typeDeclarationInResourceA : referencesOfInstaceOfA) {
					ComponentInstance resourceDeclaredInA = typeDeclarationInResourceA.getComponentInstanceDependent();
					extend = resourceDeclaredInA.extendsAtLeastOneOf(componentB);
					if (extend) {
						break;
					}
					lineNumber = typeDeclarationInResourceA.getLineNumber();
				}
				if (!extend) {
					String typeName2 = componentB.getName();
					String defaultMessage = " Classes do tipo " + componentA.getName() + " devem implementar a classe " + typeName2;
					addViolation(restriction,lineNumber, instancesOfA, defaultMessage);
				}
			}
		}
	}
}

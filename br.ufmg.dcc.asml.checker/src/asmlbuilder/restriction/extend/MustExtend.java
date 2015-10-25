package asmlbuilder.restriction.extend;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class MustExtend extends RestricionChecker {

	public MustExtend(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(Restriction restriction) {
		anyComponentAMustExtendCompontB(restriction);
	}

	private void anyComponentAMustExtendCompontB(Restriction restriction) {
		AbstractComponent componentA = (AbstractComponent) restriction.eContainer();
		int lineNumber = 0;
		for (ComponentInstance instancesOfA : componentA.getAllComponentInstances()) {
			boolean extend = false;
			String typeName2 = "";
			if (instancesOfA.getResource() instanceof IFile) {
				Set<ComponentInstanceReference> referencesOfInstaceOfA = instancesOfA.getDependencies(RelactionType.EXTEND);
				for (ComponentInstanceReference typeDeclarationInResourceA : referencesOfInstaceOfA) {
					ComponentInstance resourceDeclaredInA = typeDeclarationInResourceA.getComponentInstanceDependent();
					AbstractComponent componentB = restriction.getComponentB().get(0);
					extend = resourceDeclaredInA.extendsAtLeastOneOf(componentB);
					if (!extend) {
						typeName2 = componentB.getName();
						lineNumber = typeDeclarationInResourceA.getLineNumber();
						String defaultMessage = "Classes  do tipo   " + componentA.getName() + " devem herdar de classes " + typeName2;
						addViolation(restriction, lineNumber, instancesOfA, defaultMessage);
					}
				}
			}
		}
	}
}

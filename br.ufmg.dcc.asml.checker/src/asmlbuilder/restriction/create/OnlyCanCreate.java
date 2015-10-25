package asmlbuilder.restriction.create;

import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.ITypeBinding;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class OnlyCanCreate extends RestricionChecker {

	public OnlyCanCreate(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(Restriction restriction) {
		onlyComponentACanCreateCompontB(restriction);
	}

	private void onlyComponentACanCreateCompontB(Restriction restriction) {
		AbstractComponent componentA =  (AbstractComponent) restriction.eContainer();
		AbstractComponent componentB = null;//restriction.getComponentB();
		Set<ComponentInstance> allInstances = asmlContext.getComponentInstances();
		int lineNumber = 1;
		for (ComponentInstance componentInstance : allInstances) {
			if ((componentInstance.getResource().getFileExtension() + "").equals("java")) {
				Set<ComponentInstanceReference> asmlASTNodes = componentInstance.getDependencies(RelactionType.CREATE);
				if (asmlASTNodes == null || asmlASTNodes.isEmpty())
					continue;
				for (ComponentInstanceReference asmlastNode : asmlASTNodes) {
					ClassInstanceCreation classInstanceCreation = (ClassInstanceCreation) asmlastNode.getAstNode();
					lineNumber = asmlastNode.getLineNumber();
					String nameOfClasseInstanciate = getNameOfClasseInstanciate(classInstanceCreation);
					boolean isB_component = componentB.containsType(nameOfClasseInstanciate);
					if (isB_component) {
						String nameOfClasseInvocator = componentInstance.getType().getFullyQualifiedName();
						boolean isA_component = componentA.containsType(nameOfClasseInvocator);
						if (!isA_component) {
							String message = "";
							if (restriction.getMessage() != null)
								message = restriction.getMessage();
							else
								message = "Somente classes do tipo " + componentA.getName() + " podem criar " + componentB.getName();
							asmlContext.getViolations().add(new Violation(componentInstance.getResource(), message, lineNumber, IMarker.SEVERITY_ERROR));
						}
					}
				}
			}
		}
	}

	protected String getNameOfClasseInstanciate(ClassInstanceCreation classInstanceCreation) {
		ITypeBinding typeBinding = classInstanceCreation.getType().resolveBinding();
		if (typeBinding == null)
			return "";
		String name = typeBinding.getQualifiedName();
		return name;
	}
}

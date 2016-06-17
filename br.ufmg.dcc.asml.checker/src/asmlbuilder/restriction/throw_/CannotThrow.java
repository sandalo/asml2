package asmlbuilder.restriction.throw_;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.ThrowStatement;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation.DependecyType;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class CannotThrow extends RestricionChecker {

	public CannotThrow(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(AbstractComponent componentA, Restriction restriction,  List<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations) {
		anyComponentACannotThrowCompontB(restriction);
	}

	void anyComponentACannotThrowCompontB(Restriction restriction) {
		AbstractComponent componentA =  (AbstractComponent) restriction.eContainer();
		AbstractComponent componentB = (AbstractComponent) restriction.getComponentB().iterator().next();
		Set<ComponentInstance> allInstances = componentA.getAllComponentInstances();
		int lineNumber = 1;
		for (ComponentInstance componentInstance : allInstances) {
			IResource resource = componentInstance.getResource();
			if (resource instanceof IFile) {
				Set<ComponentInstanceReference> throwStatementFromResource = componentInstance.getDependencies(RelactionType.THROW);
				for (ComponentInstanceReference throwStatementResource : throwStatementFromResource) {
					String nameOfClassAccessed = getNameOfClasseThrow((ThrowStatement) throwStatementResource.getAstNode());
					if (nameOfClassAccessed.equals(""))
						continue;
					lineNumber = componentInstance.getCompilationUnitAST().getLineNumber(throwStatementResource.getAstNode().getStartPosition());
					if (componentB.containsType(nameOfClassAccessed)) {
						addViolation(restriction, lineNumber, componentInstance, "Componentes do tipo " + componentA.getName() + " não podem lançar exceções do tipo: " + componentB.getName(), IMarker.SEVERITY_ERROR, DependecyType.COMPILE, "CANNOT_THROW");
					}
				}
			}
		}
	}

	protected String getNameOfClasseThrow(ThrowStatement throwStatement) {
		ITypeBinding typeBinding = throwStatement.getExpression().resolveTypeBinding();
		if (typeBinding == null)
			return "";
		String nameOfClassthrowStatement = typeBinding.getQualifiedName();
		return nameOfClassthrowStatement;
	}

}

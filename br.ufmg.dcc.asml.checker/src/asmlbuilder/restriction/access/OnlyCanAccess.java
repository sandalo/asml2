package asmlbuilder.restriction.access;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation.DependecyType;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.GroupClause;
import br.ufmg.dcc.asml.aSMLModel.PermissionClause;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class OnlyCanAccess extends RestricionChecker {

	public OnlyCanAccess(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(AbstractComponent componentA, Restriction restriction,  List<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations) {
			onlyComponentACanAccessCompontB(restriction);
	}
	

	void onlyComponentACanAccessCompontB(Restriction restriction) {
		AbstractComponent componentA =  (AbstractComponent) restriction.eContainer();
		AbstractComponent componentB = null;//restriction.getComponentB();
		Set<ComponentInstance> allInstances = asmlContext.getComponentInstances();
		int lineNumber = 1;
		for (ComponentInstance componentInstance : allInstances) {
			IResource resource = componentInstance.getResource();
			if ((resource.getFileExtension() + "").equals("java")) {
				Set<ComponentInstanceReference> methodsInvocationsFromResource = componentInstance.getDependencies(RelactionType.ACCESS);
				for2: for (ComponentInstanceReference methodInvocationResource : methodsInvocationsFromResource) {
					String nameOfClassAccessed = getNameOfClasseAccessed(methodInvocationResource);
					if (nameOfClassAccessed.equals(""))
						continue;
					lineNumber = componentInstance.getCompilationUnitAST().getLineNumber(methodInvocationResource.getAstNode().getStartPosition());
					if (asmlContext.getInstanceByName(componentB, nameOfClassAccessed) != null) {
						Set<ComponentInstance> resourcesOfA = componentA.getAllComponentInstances();
						for (ComponentInstance resourceThatCanAcessResourceB : resourcesOfA) {
							if (resource.equals(resourceThatCanAcessResourceB.getResource())) {
								break for2;
							}
						}
						addViolation(restriction, lineNumber, componentInstance, "Somente classes do componente " + componentA.getName() + " podem acessar classes do componete " + componentB.getName(), IMarker.SEVERITY_ERROR, DependecyType.COMPILE,"ONLY_CAN_ACESS");
					}
				}
			}
		}
	}

	protected String getNameOfClasseAccessed(ComponentInstanceReference methodInvocationResource) {
		MethodInvocation methodInvocation = (MethodInvocation) methodInvocationResource.getAstNode();
		ITypeBinding typeBinding = methodInvocation.getExpression().resolveTypeBinding();
		if (typeBinding == null)
			return "";
		String nameOfClassAccessed = typeBinding.getJavaElement().getElementName();
		return nameOfClassAccessed;
	}

}

package asmlbuilder.restriction.declare;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation.DependecyType;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class OnlyCanDeclare extends RestricionChecker {

	public OnlyCanDeclare(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(Restriction restriction) {
		onlyComponentACanDeclareCompontB(restriction);
	}

	void onlyComponentACanDeclareCompontB(Restriction restriction) {
		AbstractComponent componentA =  (AbstractComponent) restriction.eContainer();
		AbstractComponent componentB = null;//restriction.getComponentB();
		Set<ComponentInstance> allInstances = asmlContext.getComponentInstances();
		int lineNumber = 1;
		for (ComponentInstance componentInstance : allInstances) {
			IResource resource = componentInstance.getResource();
			if (resource instanceof IFile) {
				if ((resource.getFileExtension() + "").equals("java")) {
					Set<ComponentInstanceReference> fieldDeclarationFromResource = componentInstance.getDependencies(RelactionType.DECLARE);
					for2: for (ComponentInstanceReference fieldDeclaration : fieldDeclarationFromResource) {
						String nameOfClassDeclared = getNameOfClasseDeclared((FieldDeclaration) fieldDeclaration.getAstNode());
						if (nameOfClassDeclared.equals(""))
							continue;
						lineNumber = fieldDeclaration.getLineNumber();
						if (componentB.containsType(nameOfClassDeclared)) {
							Set<ComponentInstance> resourcesOfA = componentA.getAllComponentInstances();
							for (ComponentInstance resourceThatCanAcessResourceB : resourcesOfA) {
								if (resource.equals(resourceThatCanAcessResourceB.getResource())) {
									break for2;
								}
							}
							addViolation(restriction, lineNumber, componentInstance, "Somente classes do componente " + componentA.getName() + " podem declarar classes do componete " + componentB.getName(),IMarker.SEVERITY_ERROR, DependecyType.COMPILE,"ONLY_CAN_DECLARE");
						}
					}
				}
			}
		}
	}

	protected String getNameOfClasseDeclared(FieldDeclaration fieldDeclaration) {
		ITypeBinding typeBinding = fieldDeclaration.getType().resolveBinding();
		if (typeBinding == null)
			return "";
		String name = typeBinding.getQualifiedName();
		return name;
	}

}

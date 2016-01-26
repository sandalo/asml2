package asmlbuilder.restriction.requires;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.EList;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation.DependecyType;
import asmlbuilder.matching.ModuleMatching;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class MustRequires extends RestricionChecker {

	public MustRequires(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public void checker(Restriction restriction) {
		anyComponentAMustRequiresCompontB(restriction);
	}

	private void anyComponentAMustRequiresCompontB(Restriction restriction) {
		AbstractComponent componentA = (AbstractComponent) restriction.eContainer();
		Set<ComponentInstance> instancesA = componentA.getInstances();
		EList<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations = restriction.getComponentB();
		exrenal_for: for (ComponentInstance componentInstanceA : instancesA) {
			for (ComponentsBinRestrictionDeclareation componentsBinRestrictionDeclareation : componentsBinRestrictionDeclareations) {
				Set<ComponentInstance> instancesB = componentsBinRestrictionDeclareation.getComponentB().getInstances();
				for (ComponentInstance componentInstanceB : instancesB) {
					if (componentInstanceA.getRawName().equalsIgnoreCase(componentInstanceB.getRawName())) {
						if (componentInstanceA.getResource() != null && componentInstanceA.getResource() instanceof IFile) {
							boolean isSimetric = isSimetric(componentInstanceA, componentInstanceB);
							if (!isSimetric) {
								String message = "O componente requerido " + getComponentNames(componentsBinRestrictionDeclareations) + " existe mas o nome qualificado esta em disacordo com o componente " + componentA.getName();
								addViolation(restriction, 1, componentInstanceA, message, IMarker.SEVERITY_WARNING, DependecyType.STRUCTURAL,"INVALIDE - REQUIRES");
								continue exrenal_for;
							}
						}
						componentInstanceB.addComponentInstancesThatRequireMe(componentInstanceA);
						continue exrenal_for;
					}
				}
			}
			String message = "Todo componente " + componentA.getName() + " requer um componente " + getComponentNames(componentsBinRestrictionDeclareations) + " de mesmo nome. Descrição do componente " + componentA.getName();
			addViolation(restriction, 1, componentInstanceA, message,IMarker.SEVERITY_ERROR, DependecyType.COMPILE,"REQUIRES");
		}
	}

	private String getComponentNames(EList<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations) {
		String name = "";
		boolean primeiraIteracao = true;
		for (ComponentsBinRestrictionDeclareation abstractComponent : componentsBinRestrictionDeclareations) {
			if (!primeiraIteracao)
				name = name + " ou ";
			name = name + abstractComponent.getComponentB().getName();
			primeiraIteracao = false;
		}
		return name;
	}

	private boolean isSimetric(ComponentInstance componentInstanceA, ComponentInstance componentInstanceB) {
		boolean isSimetric = true;
		String fullPathComponent = ModuleMatching.getFullPathComponent(componentInstanceA.getComponent(), true);
		String[] fullPathComponentSegments = fullPathComponent.split("\\.");
		String[] ASegments = componentInstanceA.getResource().getFullPath().segments();
		String[] BSegments = componentInstanceB.getResource().getFullPath().segments();
		int contA = ASegments.length - 2;
		int contB = BSegments.length - 2;
		for (int i = fullPathComponentSegments.length - 2; i >= 0; i--) {
			if (!fullPathComponentSegments[i].contains("?")) {
				contA--;
				contB--;
				continue;
			}
			if (!ASegments[contA].equals(BSegments[contB])) {
				isSimetric = false;
				break;
			}
			contA--;
			contB--;
		}
		return isSimetric;
	}

	public String removeTokens(String name) {
		Set<String> tokes = asmlContext.getSufixAndPrefixNameConventionConvention();
		for (String toke : tokes) {
			name = name.replace(toke, "");
		}
		return name;
	}

	public String removeFileExtension(String name, String fileExtension) {
		if (fileExtension != null)
			name = name.replace("." + fileExtension, "");
		return name;
	}

}

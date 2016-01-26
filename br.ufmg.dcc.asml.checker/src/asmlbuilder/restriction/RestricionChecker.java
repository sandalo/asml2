package asmlbuilder.restriction;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.EList;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation;
import asmlbuilder.builder.Violation.DependecyType;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public abstract class RestricionChecker {
	protected ASMLContext asmlContext;

	public RestricionChecker(ASMLContext asmlContext) {
		this.asmlContext = asmlContext;
	}

	public abstract void checker(Restriction restriction);


	protected void addViolation(Restriction restriction, int lineNumber, ComponentInstance componentInstance, String defaultMessage, DependecyType dependecyType, String violation_type) {
		if(componentInstance.isExternal())
			return;
		if (restriction.getMessage() != null)
			defaultMessage = restriction.getMessage();
		asmlContext.getViolations().add(new Violation(componentInstance.getResource(), defaultMessage, lineNumber, IMarker.SEVERITY_ERROR, dependecyType, violation_type));
	}
	
	protected void addViolation(Restriction restriction, int lineNumber, ComponentInstance componentInstance, String defaultMessage, int severity, DependecyType dependecyType, String violation_type) {
		if(componentInstance.isExternal())
			return;
		if (restriction.getMessage() != null)
			defaultMessage = restriction.getMessage();
		asmlContext.getViolations().add(new Violation(componentInstance.getResource(), defaultMessage, lineNumber, severity, dependecyType, violation_type));
	}

	
	
	public static String getComponentNames(Restriction restriction) {
		EList<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations = restriction.getComponentB();
		String name = "";
		for (ComponentsBinRestrictionDeclareation componentsBinRestrictionDeclareation : componentsBinRestrictionDeclareations) {
			name = name +",\n "+componentsBinRestrictionDeclareation.getComponentB().getFullName();
		}
		return name.substring(1);
	}

}

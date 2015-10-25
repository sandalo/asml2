package asmlbuilder.restriction;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.EList;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public abstract class RestricionChecker {
	protected ASMLContext asmlContext;

	public RestricionChecker(ASMLContext asmlContext) {
		this.asmlContext = asmlContext;
	}

	public abstract void checker(Restriction restriction);


	protected void addViolation(Restriction restriction, int lineNumber, ComponentInstance componentInstance, String defaultMessage) {
		if(componentInstance.isExternal())
			return;
		if (restriction.getMessage() != null)
			defaultMessage = restriction.getMessage();
		asmlContext.getViolations().add(new Violation(componentInstance.getResource(), defaultMessage, lineNumber, IMarker.SEVERITY_ERROR));
	}
	
	public static String getComponentNames(Restriction restriction) {
		EList<AbstractComponent> components = restriction.getComponentB();
		String name = "";
		for (AbstractComponent abstractComponent : components) {
			name = name +", "+abstractComponent.getName();
		}
		return name.substring(1);
	}

}

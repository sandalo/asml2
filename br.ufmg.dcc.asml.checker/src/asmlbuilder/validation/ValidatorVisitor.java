package asmlbuilder.validation;

import java.lang.reflect.Constructor;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;

import asmlbuilder.Activator;
import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.Violation;
import asmlbuilder.builder.Violation.DependecyType;
import asmlbuilder.restriction.RestricionChecker;
import asmlbuilder.view.preferences.PreferenceConstants;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentVisitor;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class ValidatorVisitor implements ComponentVisitor {

	private ASMLContext asmlContext;

	public ValidatorVisitor(ASMLContext asmlContext) {
		this.asmlContext = asmlContext;
	}

	@Override
	public void visit(AbstractComponent abstractComponent) {
		if (Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_SHOW_RESTRCTION_VALIDATIONS))
			validateComponentRestrictions(abstractComponent);
		if (Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_SHOW_STRUCTURAL_VIOLATIONS))
			validateLocalization(abstractComponent);
	}

	void validateComponentRestrictions(AbstractComponent abstractComponent) {
		EList<Restriction> restrictions = abstractComponent.getRestrictions();
		for (Restriction restriction : restrictions) {
			String classRestriction = "";
			classRestriction = getRestrictionCheckerClass(restriction);
			RestricionChecker restricionChecker = asmlContext.getAsmlBinder().getBindRestrictionChecker().get(classRestriction);
			if (restricionChecker == null) {
				restricionChecker = instanciateChecker(classRestriction, restricionChecker);
			}
			restricionChecker.checker(restriction);
		}

	}

	private RestricionChecker instanciateChecker(String classRestriction, RestricionChecker restricionChecker) {
		Class<?> forName = null;
		try {
			forName = Class.forName(classRestriction);
			Constructor<?> constructor;
			try {
				constructor = forName.getConstructor(ASMLContext.class);
				restricionChecker = (RestricionChecker) constructor.newInstance(asmlContext);
			} catch (Exception e) {
				e.printStackTrace();
			}
			asmlContext.getAsmlBinder().getBindRestrictionChecker().put(classRestriction, restricionChecker);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return restricionChecker;
	}

	private String getRestrictionCheckerClass(Restriction restriction) {
		String classRestriction;
		classRestriction = "_" + restriction.getGroupClause() + "_" + restriction.getPermissionClause() + "_" + restriction.getRelactionType() + "_" + restriction.getGroupClauseB();
		classRestriction = classRestriction.replaceAll("\\$null", "");
		char[] classRestrictionChar = classRestriction.toCharArray();
		classRestriction = "";
		boolean upper = false;
		for (int i = 0; i < classRestrictionChar.length; i++) {
			if (classRestrictionChar[i] != '_') {
				if (upper) {
					classRestriction = classRestriction + (classRestrictionChar[i] + "").toUpperCase();
					upper = false;
				} else {
					classRestriction = classRestriction + (classRestrictionChar[i] + "");
				}
			} else {
				upper = true;
			}
		}
		String aux = "asmlbuilder.restriction." + restriction.getRelactionType().getLiteral() + "." + classRestriction;
		return aux;
	}

	void validateLocalization(AbstractComponent abstractComponent) {
		Set<ComponentInstance> intancesOfComponent = abstractComponent.getInstances();
		for (ComponentInstance instanceOfComponent : intancesOfComponent) {
			if (!localizacaoCorreta(abstractComponent, instanceOfComponent.getResource())) {
				AbstractComponent eContainer = (AbstractComponent) abstractComponent.eContainer();
				String message = "O componente  " + abstractComponent.getName() + " deveria estar localizado de acordo com a definição: " + eContainer.getFullName();
				asmlContext.getViolations().add(new Violation(instanceOfComponent.getResource(), message, 1, IMarker.SEVERITY_ERROR, DependecyType.STRUCTURAL,"INVALID LOCALIZATION"));
			}
		}
	}

	private boolean localizacaoCorreta(AbstractComponent component, IResource resource) {
		try {
			if (resource == null)
				return true;
			/*
			 * if(resource instanceof IFolder) return true;
			 */String[] segments = resource.getFullPath().segments();
			if (segments.length == 1)
				return true;
			AbstractComponent componentPai = null;
			if (component.eContainer() instanceof AbstractComponent)
				componentPai = (AbstractComponent) component.eContainer();
			else
				return true;
			Set<ComponentInstance> instancesParent = componentPai.getInstances();
			System.out.println();
			for (ComponentInstance componentInstance : instancesParent) {
				String string = segments[segments.length - 2];
				String name = componentInstance.getResource().getName();
				if (string.equals(name)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Erro: localizacaoCorreta");
		}
		return false;
	}
}

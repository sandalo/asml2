package asmlbuilder.restriction.handle;

import java.util.List;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.restriction.RestricionChecker;
import asmlbuilder.restriction.access.OnlyCanAccess;
import asmlbuilder.restriction.declare.OnlyCanDeclare;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class OnlyCanHandle extends RestricionChecker {

	private OnlyCanAccess componentAAccessCompontB;
	private OnlyCanDeclare componentADeclareCompontB;

	public OnlyCanHandle(ASMLContext asmlContext) {
		super(asmlContext);
		this.componentAAccessCompontB = new OnlyCanAccess(asmlContext);
		this.componentADeclareCompontB = new OnlyCanDeclare(asmlContext);
	}

	@Override
	public void checker(AbstractComponent componentA, Restriction restriction,  List<ComponentsBinRestrictionDeclareation> componentsBinRestrictionDeclareations) {
		componentAAccessCompontB.checker(componentA,restriction, componentsBinRestrictionDeclareations);
		componentADeclareCompontB.checker(componentA, restriction, componentsBinRestrictionDeclareations);
	}
}

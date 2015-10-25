package asmlbuilder.builder;

import br.ufmg.dcc.asml.ComponentVisitor;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class TokensNameConventionVisitor implements ComponentVisitor {

	private ASMLContext asmlContext;

	public TokensNameConventionVisitor(ASMLContext asmlContext) {
		this.asmlContext = asmlContext;
		asmlContext.clearSufixAndPrefixNameConventionConvention();
	}
	
	@Override
	public void visit(AbstractComponent abstractComponent) {
		asmlContext.addMatchNameConvention(abstractComponent);
	}

}

package asmlbuilder.matching;

import asmlbuilder.builder.ASMLContext;


public abstract class AbstraticMatching implements IMatching {
    protected ASMLContext asmlContext;
    
    public AbstraticMatching(ASMLContext asmlContext){
    	this.setAsmlContext(asmlContext);
    }
	public ASMLContext getAsmlContext() {
		return asmlContext;
	}
	
	private void setAsmlContext(ASMLContext asmlContext) {
		this.asmlContext = asmlContext;
	}
	
}

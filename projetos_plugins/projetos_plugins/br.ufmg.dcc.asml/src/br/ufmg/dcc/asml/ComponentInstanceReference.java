package br.ufmg.dcc.asml;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTNode;

import br.ufmg.dcc.asml.aSMLModel.RelactionType;

public class ComponentInstanceReference {
	Map<String, Boolean> validate = new HashMap<String, Boolean>();
	private ASTNode astNode;
	private ComponentInstance componentInstanceDependent;
	private ComponentInstance componentInstanceReferenced;
	private RelactionType relactionType;
	public ASTNode getAstNode() {
		return astNode;
	}

	public void setAstNode(ASTNode astNode) {
		this.astNode = astNode;
	}

	public ComponentInstance getComponentInstanceDependent() {
		return componentInstanceDependent;
	}

	public void setComponentInstance(ComponentInstance componentInstance) {
		this.componentInstanceDependent = componentInstance;
	}

	public int getLineNumber() {
		int lineNumber;
		ASTNode astNode = (ASTNode) getAstNode();
		lineNumber = componentInstanceDependent.getCompilationUnitAST().getLineNumber(astNode.getStartPosition());
		return lineNumber;
	}

	public void setComponentInstanceReferenced(ComponentInstance componentInstanceReferenced) {
		this.componentInstanceReferenced = componentInstanceReferenced;
	}

	
	public ComponentInstance getComponentInstanceReferenced() {
		return componentInstanceReferenced;
	}


	
	@Override
	public String toString() {
		if (getAstNode() != null)
			return "" + getAstNode().toString();
		return "";
	}

	public RelactionType getRelactionType() {
		return relactionType;
	}

	public void setRelactionType(RelactionType relactionType) {
		this.relactionType = relactionType;
	}

	
	public Boolean isVerified(String key){
		if(!validate.containsKey(key))
			return false;
		return validate.get(key);
	}
	
	public void verified(String key){
		validate.put(key,true);
	}

}

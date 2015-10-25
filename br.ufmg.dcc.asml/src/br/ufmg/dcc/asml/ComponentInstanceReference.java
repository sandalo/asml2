package br.ufmg.dcc.asml;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import br.ufmg.dcc.asml.aSMLModel.RelactionType;

public class ComponentInstanceReference {
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

}

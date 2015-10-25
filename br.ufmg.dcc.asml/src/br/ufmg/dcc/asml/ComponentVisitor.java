package br.ufmg.dcc.asml;

import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;


public interface ComponentVisitor{
	public void visit(AbstractComponent abstractComponent);
}

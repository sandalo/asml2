package br.ufmg.dcc.asml.ui.syntaxcoloring;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;

import br.ufmg.dcc.asml.aSMLModel.ClassMatching;

public class ASMLSemanticHighlightingCalculator extends
		DefaultSemanticHighlightingCalculator {
	@Override
	public void provideHighlightingFor(final XtextResource _resource,
			IHighlightedPositionAcceptor acceptor) {
		if (_resource == null)
			return;
		TreeIterator<Object> it = EcoreUtil.getAllContents(_resource, true);
		while (it.hasNext()) {
			Object o = it.next();  
			if (o instanceof ClassMatching) {
				ClassMatching expressionNameConvention = (ClassMatching) o;
				ICompositeNode n = NodeModelUtils.getNode(expressionNameConvention);
				acceptor.addPosition(n.getOffset(),n.getLength(),ASMLSemanticHighlightingConfiguration.METHOD);
			}
		}
	}

}
package br.ufmg.dcc.asml.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class ASMLSemanticHighlightingConfiguration extends DefaultHighlightingConfiguration {
	public final static String METHOD = "CrossReference";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(METHOD, "Method",crossReferenceTextStyle());
	}

	@Override
	public TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setBackgroundColor(new RGB(255, 255, 255));
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}

	public TextStyle crossReferenceTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(SWT.ITALIC);
		textStyle.setColor(new RGB(100, 100, 100));
		return textStyle;
	}
}

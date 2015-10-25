package br.ufmg.dcc.asml.formatting;

import java.util.List;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

import br.ufmg.dcc.asml.services.ASMLModelGrammarAccess;

public class ASMLModelFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		ASMLModelGrammarAccess f = (ASMLModelGrammarAccess) getGrammarAccess();

		c.setAutoLinewrap(300);

		// c.setLinewrap().before(f.getRestrictionAccess().getCommaKeyword_4_1());
		// c.setIndentationIncrement().before(f.getRestrictionAccess().getComponentBAbstractComponentCrossReference_4_0_0());

		List<Keyword> findKeywords = f.getRestrictionAccess().findKeywords(",");
		for (Keyword keyword : findKeywords) {
			c.setLinewrap().after(keyword);
		}

		// find common keywords an specify formatting for them
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("{", "}")) {
			c.setSpace("").before(pair.getFirst()); //$NON-NLS-1$
			// indentation between
			c.setLinewrap().after(pair.getFirst());
			c.setIndentation(pair.getFirst(), pair.getSecond());
			c.setLinewrap().before(pair.getSecond());
			c.setLinewrap().after(pair.getSecond());
		}

		for (Keyword key : f.findKeywords(";")) {
			c.setNoSpace().before(key);
			c.setLinewrap().after(key);
		}

		for (Keyword key : f.findKeywords(",")) {
			c.setNoSpace().before(key);
		}
	}
}

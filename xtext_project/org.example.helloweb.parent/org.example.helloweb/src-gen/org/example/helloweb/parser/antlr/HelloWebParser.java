/*
 * generated by Xtext 2.31.0
 */
package org.example.helloweb.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.example.helloweb.parser.antlr.internal.InternalHelloWebParser;
import org.example.helloweb.services.HelloWebGrammarAccess;

public class HelloWebParser extends AbstractAntlrParser {

	@Inject
	private HelloWebGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalHelloWebParser createParser(XtextTokenStream stream) {
		return new InternalHelloWebParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "SensorConfig";
	}

	public HelloWebGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(HelloWebGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

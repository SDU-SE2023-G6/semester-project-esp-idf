/*
 * generated by Xtext 2.31.0
 */
package org.example.helloweb.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class HelloWebAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/example/helloweb/parser/antlr/internal/InternalHelloWeb.tokens");
	}
}

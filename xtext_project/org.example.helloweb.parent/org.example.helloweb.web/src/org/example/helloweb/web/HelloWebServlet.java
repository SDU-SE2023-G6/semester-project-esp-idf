/*
 * generated by Xtext 2.33.0
 */
package org.example.helloweb.web;

import com.google.inject.Injector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import org.eclipse.xtext.util.DisposableRegistry;
import org.eclipse.xtext.web.servlet.XtextServlet;

/**
 * Deploy this class into a servlet container to enable DSL-specific services.
 */
@WebServlet(name = "XtextServices", urlPatterns = "/xtext-service/*")
public class HelloWebServlet extends XtextServlet {
	
	private static final long serialVersionUID = 1L;
	
	DisposableRegistry disposableRegistry;
	
	public void init() throws ServletException {
		super.init();
		Injector injector = new HelloWebWebSetup().createInjectorAndDoEMFRegistration();
		this.disposableRegistry = injector.getInstance(DisposableRegistry.class);
	}
	
	public void destroy() {
		if (disposableRegistry != null) {
			disposableRegistry.dispose();
			disposableRegistry = null;
		}
		super.destroy();
	}
	
}

/*
 * generated by Xtext 2.31.0
 */
package org.example.helloweb.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;

@ComposedChecks(validators = {NamesAreUniqueValidator.class, HelloWebValidator.class})
public abstract class AbstractHelloWebValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(org.example.helloweb.helloWeb.HelloWebPackage.eINSTANCE);
		return result;
	}
}

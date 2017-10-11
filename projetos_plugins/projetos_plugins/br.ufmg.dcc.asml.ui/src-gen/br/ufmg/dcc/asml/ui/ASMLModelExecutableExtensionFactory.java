/*
 * generated by Xtext
 */
package br.ufmg.dcc.asml.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import br.ufmg.dcc.asml.ui.internal.ASMLModelActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ASMLModelExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ASMLModelActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ASMLModelActivator.getInstance().getInjector(ASMLModelActivator.BR_UFMG_DCC_ASML_ASMLMODEL);
	}
	
}

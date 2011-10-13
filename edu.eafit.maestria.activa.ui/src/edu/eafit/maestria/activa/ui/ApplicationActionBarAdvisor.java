package edu.eafit.maestria.activa.ui;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}
	
	private IWorkbenchAction quitAction;
	
	protected void makeActions(IWorkbenchWindow window) {
		// Creates the actions and registers them. Registering also 
		// provides automatic disposal of the actions when the window is closed.
		quitAction = ActionFactory.QUIT.create(window);
		register(quitAction);
	}

}

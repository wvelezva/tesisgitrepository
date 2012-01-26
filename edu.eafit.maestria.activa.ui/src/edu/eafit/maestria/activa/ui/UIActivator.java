package edu.eafit.maestria.activa.ui;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import edu.eafit.maestria.activa.model.Project;


public class UIActivator extends AbstractUIPlugin {

	private static Project project;
	
	
	// The shared instance.
    private static UIActivator plugin;
    
    
    
	public UIActivator() {
		 plugin = this;
	}
	
	 @Override
    public void stop(BundleContext context) throws Exception {
        super.stop(context);
        plugin = null;
    }
	 
	public static UIActivator getDefault(){
		return plugin;
	}
	
	public static void setProject(Project project) {
		UIActivator.project = project;
	}
	
	public static Project getProject(){
		return UIActivator.project;
	}
}

package edu.eafit.maestria.activa.ui;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


public class UIActivator extends AbstractUIPlugin {

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

}

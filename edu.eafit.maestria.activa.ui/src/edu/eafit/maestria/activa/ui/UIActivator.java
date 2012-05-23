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
		plugin = null;
		super.stop(context);
	}

	public static UIActivator getDefault() {
		return plugin;
	}

	public static void stop() {
		try {
			plugin.stop(getDefault().getBundle().getBundleContext());
		} catch (Exception e) {
			//This print cannot be replaced by a logUtil because the building of the object failed at the initialization
			e.printStackTrace();
		}
	}

}

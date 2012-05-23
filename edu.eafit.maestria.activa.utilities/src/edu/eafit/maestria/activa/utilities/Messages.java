package edu.eafit.maestria.activa.utilities;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS{
	
	//the bundle_name is not just an id, is the package where the messages_*.properties is located
	private static final String BUNDLE_NAME = "edu.eafit.maestria.activa.utilities";

	//Config
	public static String CONFIG_FILE_LOCATION_ERROR;
	public static String CONFIG_FILE_LOADING_ERROR;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
}

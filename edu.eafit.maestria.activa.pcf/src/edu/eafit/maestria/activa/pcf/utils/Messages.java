package edu.eafit.maestria.activa.pcf.utils;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS{
	
	//the bundle_name is not just an id, is the package where the messages_*.properties is located
	private static final String BUNDLE_NAME = "edu.eafit.maestria.activa.pcf.messages";

	//PCF
	public static String PROPERTIES;
	public static String RESOURCES;

	public static String ERROR_EXPORTING_PCF;
	public static String ERROR_EXPORTING_DETAIL_TEMPLATE;
		
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
}
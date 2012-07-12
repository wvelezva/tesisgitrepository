package edu.eafit.maestria.activa.tva.utils;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS{
	
	//the bundle_name is not just an id, is the package where the messages_*.properties is located
	private static final String BUNDLE_NAME = "edu.eafit.maestria.activa.tva.messages";

	//TVA
	public static String PROPERTIES;
	public static String RESOURCES;
	
	public static String ERROR_EXPORTING_TVA;
	public static String ERROR_IMPORTING_TVA;
	public static String ERROR_CREATING_FILE;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
}
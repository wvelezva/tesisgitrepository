package edu.eafit.maestria.activa.dao.hibernate;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	//the bundle_name is not just an id, is the package where the messages_*.properties is located
	private static final String BUNDLE_NAME = "edu.eafit.maestria.activa.dao.hibernate.messages";
	
	public static String ERROR_OBJECT_DOESNT_EXIST;
	public static String EAGERLY_FLUSHING_HIBERNATE_SESSION;
	public static String THREAD_BOUND_SESSION;
	public static String NOT_CLOSING_PREBOUND_SESSION;
	public static String TAG_NOT_EXISTS;
	public static String UNABLE_TO_PROCESS_DOCUMENT;
		
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
}

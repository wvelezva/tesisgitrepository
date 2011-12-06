package edu.eafit.maestria.activa.services;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public final class ActivaConfig
{
	private static final String CONFIG_FILE = "bin/conf.xml";

	public static final String DOCUMENTS_BASEDIR = "resources.basedir";

	public static Configuration config;
	
	static {
		reloadConfig();
	}
	
	/**
	 * Do not allow creation of an instance of this object
	 */
	private ActivaConfig()
	{
	}
	
	/**
	 * reload all the configuration
	 * 
	 * @author juan.maya
	 */
	public static synchronized void reloadConfig()
	{
		XMLConfiguration tempconfig = null;
		java.net.URL configURL = ActivaConfig.class.getClassLoader().getResource(CONFIG_FILE);
		if (configURL == null) {
			//logger.fatal("Unable to find resource for config file [" + CONFIG_FILE + "]");
		}
		else {
			//try {
				try {
					tempconfig = new XMLConfiguration(configURL);
				} catch (ConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			}
//			catch (ConfigurationException e) {
//				//logger.error("Unable to Load SMS config file [" + CONFIG_FILE + "]:", e);
//				tempconfig = null;
//			}
		}
		config = tempconfig;
	}
}
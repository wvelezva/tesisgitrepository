package edu.eafit.maestria.activa.utilities;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public final class ActivaConfig
{
	private static final LogUtil logger = LogUtil.getInstance(Activator.getDefault().getBundle().getSymbolicName(), ActivaConfig.class);
	
	private static final String CONFIG_FILE = "conf.xml";

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
	 */
	public static synchronized void reloadConfig()
	{
		XMLConfiguration tempconfig = null;
		//FIXME la linea siguiente es un ejemplo para cargar un archivo
		//ClassLoader.getSystemResourceAsStream("conf/jdbc.properties")
		java.net.URL configURL = ActivaConfig.class.getClassLoader().getResource(CONFIG_FILE);
		if (configURL == null) {
			logger.logFatal("Unable to find resource for config file [" + CONFIG_FILE + "]");
		}
		else {
			try {
				tempconfig = new XMLConfiguration(configURL);
			} catch (ConfigurationException e) {
				logger.logFatal("Unable to Load SMS config file [" + CONFIG_FILE + "]:", e);
			}
		}
		config = tempconfig;
	}
}
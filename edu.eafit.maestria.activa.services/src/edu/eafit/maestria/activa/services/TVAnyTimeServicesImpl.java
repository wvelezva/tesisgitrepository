package edu.eafit.maestria.activa.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.model.TVAnyTime;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class TVAnyTimeServicesImpl implements ITVAnyTimeServices{
	
	private final LogUtil logger = LogUtil.getInstance(ModelActivator.getDefault().getBundle().getSymbolicName(), TVAnyTimeServicesImpl.class);
	
	private static TVAnyTimeServicesImpl tvaServicesImpl;
	private XStream xs;
	
	private TVAnyTimeServicesImpl(){
		xs = new XStream();
		xs.processAnnotations(TVAnyTime.class);
	}
	
	public static ITVAnyTimeServices getInstance(){
		if (tvaServicesImpl == null)
			tvaServicesImpl = new TVAnyTimeServicesImpl();
		return tvaServicesImpl;
	}

	@Override
	public TVAnyTime loadTVAnyTime(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveTVAnyTime(TVAnyTime tva) {
		FileOutputStream fs = null;
		try {
			if (tva.isModified()) {
	        	fs = new FileOutputStream(tva.getSource());
		        xs.toXML(tva, fs);
		        tva.resetModified();
			}
        } catch (FileNotFoundException e) {
            logger.logError(e);
            return false;
        } finally {
        	if (fs != null)
				try {
					fs.close();
				} catch (IOException e) {
					logger.logWarning(e);
				}
        }
        
        return true;
	}
}

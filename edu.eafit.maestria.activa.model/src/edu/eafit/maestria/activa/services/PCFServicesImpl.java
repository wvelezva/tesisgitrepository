package edu.eafit.maestria.activa.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.model.PCF;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class PCFServicesImpl implements IPCFServices{
	
	private final LogUtil logger = LogUtil.getInstance(ModelActivator.getDefault().getBundle().getSymbolicName(), PCFServicesImpl.class);
	
	private static PCFServicesImpl pcfServicesImpl;
	private XStream xs;
	
	private PCFServicesImpl(){
		xs = new XStream();
		xs.processAnnotations(PCF.class);
	}
	
	public static IPCFServices getInstance(){
		if (pcfServicesImpl == null)
			pcfServicesImpl = new PCFServicesImpl();
		return pcfServicesImpl;
	}

	@Override
	public PCF loadPCF(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean savePCF(PCF pcf) {
		FileOutputStream fs = null;
		try {
			if (pcf.isModified()) {
	        	fs = new FileOutputStream(pcf.getSource());
		        xs.toXML(pcf, fs);
		        pcf.resetModified();
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

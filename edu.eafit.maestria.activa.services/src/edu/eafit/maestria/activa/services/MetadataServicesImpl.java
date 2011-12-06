package edu.eafit.maestria.activa.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import edu.eafit.maestria.activa.model.Metadata;
import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class MetadataServicesImpl implements IMetadataServices{
	
	private final LogUtil logger = LogUtil.getInstance(ModelActivator.getDefault().getBundle().getSymbolicName(), MetadataServicesImpl.class);
	
	private static MetadataServicesImpl metadataServicesImpl;
	private XStream xs;
	
	private MetadataServicesImpl(){
		xs = new XStream();
		xs.processAnnotations(Metadata.class);
	}
	
	public static IMetadataServices getInstance(){
		if (metadataServicesImpl == null)
			metadataServicesImpl = new MetadataServicesImpl();
		return metadataServicesImpl;
	}

	@Override
	public Metadata loadMetadata(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveMetadata(Metadata metadata) {
		FileOutputStream fs = null;
		try {
			if (metadata.isModified()) {
	        	fs = new FileOutputStream(metadata.getSource());
		        xs.toXML(metadata, fs);
		        metadata.resetModified();
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

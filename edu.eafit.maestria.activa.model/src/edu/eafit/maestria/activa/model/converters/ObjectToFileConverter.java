package edu.eafit.maestria.activa.model.converters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import edu.eafit.maestria.activa.utilities.LogUtil;

public abstract class ObjectToFileConverter implements Converter {
	
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		Convertable convertable = getNewConvertable();
		try {
            FileInputStream fis = new FileInputStream(reader.getValue());
            getXStreamProcessor().fromXML(fis, convertable);
        } catch (FileNotFoundException e) {
            getLogger().logError(e);
            return null;
        }
		return convertable;
	}
	
	public abstract Convertable getNewConvertable();

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext ctx) {
		Convertable convertable = (Convertable) source;
		if (convertable.getSource() != null) 
			writer.setValue(convertable.getSource().getAbsolutePath());
		else
			writer.setValue("");
		
		save(convertable);
	}

	public void save(Convertable convertable){
		if (convertable.isModified()){
			XStream xs = getXStreamProcessor();
			FileOutputStream fs = null;
			try {
        		fs = new FileOutputStream(convertable.getSource());
	        	xs.toXML(convertable, fs);
	        	convertable.resetModified();
	        } catch (FileNotFoundException e) {
	            getLogger().logError(e);
	        } finally {
	        	if (fs != null)
					try {
						fs.close();
					} catch (IOException e) {
						getLogger().logWarning(e);
					}
	        }
		} 
	}

	public abstract XStream getXStreamProcessor();
	public abstract LogUtil getLogger();
}

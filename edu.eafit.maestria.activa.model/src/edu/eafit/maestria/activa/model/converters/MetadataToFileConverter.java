package edu.eafit.maestria.activa.model.converters;

import java.io.File;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

import edu.eafit.maestria.activa.model.Metadata;
import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class MetadataToFileConverter extends ObjectToFileConverter {

	private XStream xs;
	
	public MetadataToFileConverter(){
		xs = new XStream();
		xs.setClassLoader(ModelActivator.class.getClassLoader());
		xs.processAnnotations(Metadata.class);
	}
	
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		Metadata metadata = new Metadata();
		metadata.setSource(new File(reader.getValue()));
		return metadata;
	}

	@Override
	public boolean canConvert(Class clazz) {
		return clazz.equals(Metadata.class);
	}
	
	@Override
	public XStream getXStreamProcessor() {
		return xs;
	}

	@Override
	public LogUtil getLogger() {
		return null;
	}

	@Override
	public Convertable getNewConvertable() {
		return new Metadata();
	}

}

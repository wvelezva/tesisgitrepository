package edu.eafit.maestria.activa.model.converters;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.model.TVAnyTime;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class TVAnyTimeToFileConverter extends ObjectToFileConverter {

	private XStream xs;
	
	public TVAnyTimeToFileConverter(){
		xs = new XStream();
		xs.setClassLoader(ModelActivator.class.getClassLoader());
		xs.processAnnotations(TVAnyTime.class);
	}
	
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		return new TVAnyTime();
	}

	@Override
	public boolean canConvert(Class clazz) {
		return clazz.equals(TVAnyTime.class);
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
		return new TVAnyTime();
	}

}

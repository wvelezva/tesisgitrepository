package edu.eafit.maestria.activa.model.converters;

import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

import edu.eafit.maestria.activa.model.TVAnyTime;

public class TVAnyTimeToFileConverter extends ObjectToFileConverter {

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		return new TVAnyTime();
	}

	@Override
	public boolean canConvert(Class clazz) {
		return clazz.equals(TVAnyTime.class);
	}

}

package edu.eafit.maestria.activa.model.converters;

import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

import edu.eafit.maestria.activa.model.Metadata;

public class MetadataToFileConverter extends ObjectToFileConverter {

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		return new Metadata();
	}

	@Override
	public boolean canConvert(Class clazz) {
		return clazz.equals(Metadata.class);
	}

}

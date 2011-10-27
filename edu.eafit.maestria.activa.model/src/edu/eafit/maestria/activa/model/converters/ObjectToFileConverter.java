package edu.eafit.maestria.activa.model.converters;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public abstract class ObjectToFileConverter implements Converter {

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext ctx) {
		Convertable convertable = (Convertable) source;
		if (convertable.getSource() != null) 
			writer.setValue(convertable.getSource().getName());
		else
			writer.setValue("");
	}

}

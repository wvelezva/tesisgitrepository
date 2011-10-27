package edu.eafit.maestria.activa.model.converters;

import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

import edu.eafit.maestria.activa.model.Video;

public class VideoToFileConverter extends ObjectToFileConverter {

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		return new Video();
	}

	@Override
	public boolean canConvert(Class clazz) {
		return clazz.equals(Video.class);
	}

}

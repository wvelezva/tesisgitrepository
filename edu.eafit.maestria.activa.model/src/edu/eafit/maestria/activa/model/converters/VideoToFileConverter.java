package edu.eafit.maestria.activa.model.converters;

import com.thoughtworks.xstream.XStream;

import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class VideoToFileConverter extends ObjectToFileConverter {

	private XStream xs;
	
	public VideoToFileConverter(){
		xs = new XStream();
		xs.setClassLoader(ModelActivator.class.getClassLoader());
		xs.processAnnotations(Video.class);
	}
	
	@Override
	public boolean canConvert(Class clazz) {
		return clazz.equals(Video.class);
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
		return new Video();
	}

}

package edu.eafit.maestria.activa.model.converters;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.model.PCF;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class PCFToFileConverter extends ObjectToFileConverter {

	private XStream xs;
	//private LogUtil logger = LogUtil.getInstance(ModelActivator.getDefault().getBundle().getSymbolicName(), PCFToFileConverter.class);
	
	public PCFToFileConverter(){
		xs = new XStream();
		xs.setClassLoader(ModelActivator.class.getClassLoader());
		xs.processAnnotations(PCF.class);
	}
	
	
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
		return new PCF();
	}
	
	@Override
	public boolean canConvert(Class clazz) {
		return clazz.equals(PCF.class);
	}

	@Override
	public XStream getXStreamProcessor() {
		return xs;
	}

	@Override
	public LogUtil getLogger() {
//		return logger;
		return null;
	}


	@Override
	public Convertable getNewConvertable() {
		return new PCF();
	}
}

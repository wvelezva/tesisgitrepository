package edu.eafit.maestria.activa.model;

import java.io.File;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.eafit.maestria.activa.model.converters.Convertable;

public class TVAnyTime implements Convertable, Modifiable{
	
	private File source;
	@XStreamOmitField
	private boolean modified;

	public File getSource() {
		return source;
	}
	
	@Override
	public void setSource(File src) {
		source = src;
	}
	
	@Override
	public boolean isModified() {
		return modified;
	}

}

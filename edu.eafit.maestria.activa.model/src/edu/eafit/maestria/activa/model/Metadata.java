package edu.eafit.maestria.activa.model;

import java.io.File;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.eafit.maestria.activa.model.converters.Convertable;

@XStreamAlias("metadata")
public class Metadata implements Convertable{
	private File source;
	
	@XStreamOmitField
	private boolean modified;
	
	@Override
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
	
	@Override
	public void resetModified(){
		modified=false;
	}
}

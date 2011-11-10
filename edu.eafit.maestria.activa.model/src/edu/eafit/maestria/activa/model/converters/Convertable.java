package edu.eafit.maestria.activa.model.converters;

import java.io.File;

import edu.eafit.maestria.activa.model.Modifiable;

public interface Convertable extends Modifiable{
	public File getSource();
	public void setSource(File src);
}

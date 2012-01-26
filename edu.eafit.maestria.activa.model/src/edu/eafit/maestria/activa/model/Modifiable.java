package edu.eafit.maestria.activa.model;

public interface Modifiable {
	public boolean isModified();
	public void setModified();
	public void resetModified();
}

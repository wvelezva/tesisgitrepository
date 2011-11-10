package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.model.PCF;

public interface IPCFServices {

	public PCF loadPCF(String name);
	public boolean savePCF(PCF pcf);
}

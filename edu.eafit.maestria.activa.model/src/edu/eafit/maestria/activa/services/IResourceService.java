package edu.eafit.maestria.activa.services;
import java.io.File;


public interface IResourceService {
	public String getHashedPath(long resourceId);
	public File getBaseDir();
}

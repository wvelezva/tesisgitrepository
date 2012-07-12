package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.model.Project;

public interface IMetadataServices {

	public Object loadMetadata(String name);
	public boolean saveMetadata(Project project);
}

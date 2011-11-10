package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.model.Metadata;

public interface IMetadataServices {

	public Metadata loadMetadata(String name);
	public boolean saveMetadata(Metadata metadata);
}

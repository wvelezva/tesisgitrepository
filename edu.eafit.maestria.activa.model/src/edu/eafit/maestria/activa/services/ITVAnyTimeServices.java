package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.model.TVAnyTime;

public interface ITVAnyTimeServices {

	public TVAnyTime loadTVAnyTime(String name);
	public boolean saveTVAnyTime(TVAnyTime tva);
}

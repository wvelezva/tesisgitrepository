package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.model.Video;

public interface IVideoServices {

	public Video loadVideo(String name);
	public boolean saveVideo(Video video);
}

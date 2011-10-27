package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.model.Project;

public interface IProjectServices {

	public Project loadProject(String name);
	public boolean saveProject(Project project);
}

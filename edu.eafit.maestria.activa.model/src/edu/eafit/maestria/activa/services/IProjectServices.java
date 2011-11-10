package edu.eafit.maestria.activa.services;

import java.io.File;

import edu.eafit.maestria.activa.model.Project;

public interface IProjectServices {

	public Project loadProject(String name);
	public boolean saveProject(Project project);
	public Project newProject(String projectName, File sourceVideo,	File projectDir);
}

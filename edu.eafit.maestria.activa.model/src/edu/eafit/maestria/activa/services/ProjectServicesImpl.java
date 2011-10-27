package edu.eafit.maestria.activa.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;

import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class ProjectServicesImpl implements IProjectServices{

	private final LogUtil logger = LogUtil.getInstance(ModelActivator.getDefault().getBundle().getSymbolicName(), ProjectServicesImpl.class);
	
	private static ProjectServicesImpl projectServicesImpl;
	
	private ProjectServicesImpl(){
		
	}
	
	public static IProjectServices getInstance(){
		if (projectServicesImpl == null)
			projectServicesImpl = new ProjectServicesImpl();
		return projectServicesImpl;
	}
	
	public Project loadProject(String name){
		XStream xs = new XStream();
		Project project = new Project();
		
		try {
            FileInputStream fis = new FileInputStream(name);
            xs.fromXML(fis, project);

            //print the data from the object that has been read
            logger.logInfo(project.toString());

        } catch (FileNotFoundException e) {
            logger.logError(e);
            return null;
        }
		
		return project;
	}
	
	public boolean saveProject(Project project){
		XStream xs = new XStream();
		xs.processAnnotations(Project.class);
        //Write to a file in the file system
        try {
            FileOutputStream fs = new FileOutputStream(project.getSource());
            xs.toXML(project, fs);
        } catch (FileNotFoundException e) {
            logger.logError(e);
            return false;
        }
        
        return true;
	}
	
}

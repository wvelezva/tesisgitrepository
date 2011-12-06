package edu.eafit.maestria.activa.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.XStream;

import edu.eafit.maestria.activa.model.Metadata;
import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.model.PCF;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.model.Scene;
import edu.eafit.maestria.activa.model.TVAnyTime;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.utilities.Constants;

public class ProjectServicesImpl implements IProjectServices{

	//private final LogUtil logger = LogUtil.getInstance(ModelActivator.getDefault().getBundle().getSymbolicName(), ProjectServicesImpl.class);
	
	private static ProjectServicesImpl projectServicesImpl;
//	private IMetadataServices metadataServices;
//	private IPCFServices pcfServices;
//	private ITVAnyTimeServices tvaServices;
//	private IVideoServices videoServices;
	
	private XStream xs;
	
	private ProjectServicesImpl(){
		xs = new XStream();
		xs.processAnnotations(Project.class);
		xs.setClassLoader(ModelActivator.class.getClassLoader());
//		metadataServices = MetadataServicesImpl.getInstance();
//		pcfServices = PCFServicesImpl.getInstance();
//		tvaServices = TVAnyTimeServicesImpl.getInstance();
//		videoServices = VideoServicesImpl.getInstance();
	}
	
	public static IProjectServices getInstance(){
		if (projectServicesImpl == null)
			projectServicesImpl = new ProjectServicesImpl();
		return projectServicesImpl;
	}
	
	public Project loadProject(String name){
		Project project = new Project();
		String srcFile = name + System.getProperty("file.separator") + StringUtils.substringAfterLast(name, System.getProperty("file.separator")) + Constants.File.PROJECT_FILE_EXTENSION;
		try {
			FileInputStream fis = new FileInputStream(srcFile);
            xs.fromXML(fis, project);
        } catch (FileNotFoundException e) {
            //logger.logError(e);
            return null;
        }
		
		return project;
	}
	
	public boolean saveProject(Project project){
		if (project.isModified()){
			//Write to a file in the file system
			FileOutputStream fs = null;
			try {
        		fs = new FileOutputStream(project.getSource());
	        	xs.toXML(project, fs);
	        } catch (FileNotFoundException e) {
	            //logger.logError(e);
	            return false;
	        } finally {
	        	if (fs != null)
					try {
						fs.close();
					} catch (IOException e) {
						//logger.logWarning(e);
					}
	        }
		}
        
        return true;
	}

	@Override
	public Project newProject(String projectName, File sourceVideo,	File projectDir) {
		Project project = null;
		if (projectDir.mkdirs()) {
			File projectFile = new File(projectDir, projectName + Constants.File.PROJECT_FILE_EXTENSION);
			
			project = new Project();
			project.setID(String.valueOf(System.currentTimeMillis()));
			project.setSource(projectFile);
			project.setName(projectName);
			
			Metadata metadata = new Metadata();
			metadata.setSource(new File(projectDir, projectName + Constants.File.METADATA_FILE_EXTENSION));
			project.setMetadata(metadata);
			
			PCF pcf= new PCF();
			pcf.setSource(new File(projectDir, projectName + Constants.File.PCF_FILE_EXTENSION));
			project.setPcf(pcf);
			
			TVAnyTime tva = new TVAnyTime();
			tva.setSource(new File(projectDir, projectName + Constants.File.TVANYTIME_FILE_EXTENSION));
			project.setTva(tva);
			
			Video video = new Video();
			video.setVideo(sourceVideo);
			video.setSource(new File(projectDir, projectName + Constants.File.VIDEO_FILE_EXTENSION));
			video.setSnapshotDirectory(new File(projectDir, Constants.File.SNAPSHOT_DIRECTORY));
			Scene scene = new Scene();
			scene.setId(1);
			video.addScene(scene);
			project.setVideo(video);
			
			saveProject(project);
		}
		
		return project;
	}
	
	public static void main(String[] args){
		IProjectServices ps = ProjectServicesImpl.getInstance();
		Project pj = ps.loadProject("/Users/wvelezva/activa_projects/otra");
		System.out.println(pj);
	}
	
}

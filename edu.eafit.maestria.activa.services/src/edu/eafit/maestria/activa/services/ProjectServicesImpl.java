package edu.eafit.maestria.activa.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.XStream;

import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.Metadata;
import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.model.Scene;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class ProjectServicesImpl implements IProjectServices{

	private static final LogUtil logger = LogUtil.getInstance(ModelActivator.getDefault().getBundle().getSymbolicName());
	
	private XStream xs;
	private IEntityServices entityServices;
	private IMetadataServices metadataServices;
	
	public ProjectServicesImpl(IEntityServices entityServices, IMetadataServices metadataServices){
		xs = new XStream();
		xs.processAnnotations(Project.class);
		xs.setClassLoader(ModelActivator.class.getClassLoader());
		this.entityServices = entityServices;
		this.metadataServices = metadataServices;
	}
	
	public Project loadProject(String name){
		Project project = new Project();
		String srcFile = name + File.separator + StringUtils.substringAfterLast(name, File.separator) + Constants.File.PROJECT_FILE_EXTENSION;
		try {
			FileInputStream fis = new FileInputStream(srcFile);
            xs.fromXML(fis, project);
        } catch (FileNotFoundException e) {
            logger.error(e);
            return null;
        }
		
		try {
			project.getMetadata().setContent(metadataServices.loadMetadata(project.getMetadata().getSource().getAbsolutePath()));
		} catch (Exception e){
			logger.warning(e);
		}
		
		return project;
	}
	
	public boolean saveProject(Project project){
		for (Animation animation : project.getVideo().getAllAnimations()) { 
			if (animation != null && animation.getEntity() != null) {
				IEntity entity = animation.getEntity();
				long entityId = entity.getEntityId();
				entityServices.save(entity);
				if (entityId != entity.getEntityId()) {
					animation.setEntityId(entity.getEntityId());
					project.getVideo().setModified();
				}
			}
		}

		if (project.isModified()){
			//Write to a file in the file system
			FileOutputStream fs = null;
			try {
        		fs = new FileOutputStream(project.getSource());
	        	xs.toXML(project, fs);
	        } catch (FileNotFoundException e) {
	            logger.error(e);
	            return false;
	        } finally {
	        	if (fs != null)
					try {
						fs.close();
					} catch (IOException e) {
						logger.warning(e);
					}
	        }
			
		}
		//FIXME esto debe estar dentro del anterior if (solo para probar el save de metadata esta aca)
		metadataServices.saveMetadata(project); 
		
        
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
	
}

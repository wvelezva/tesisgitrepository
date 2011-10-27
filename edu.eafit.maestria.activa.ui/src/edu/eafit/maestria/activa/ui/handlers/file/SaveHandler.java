package edu.eafit.maestria.activa.ui.handlers.file;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.model.Metadata;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.model.TVAnyTime;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.services.IProjectServices;
import edu.eafit.maestria.activa.services.ProjectServicesImpl;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class SaveHandler extends AbstractHandler implements IHandler {

	private final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), SaveHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Project project = new Project();
		project.setID("un.id");
		File tempFile;
		try {
			tempFile = File.createTempFile("location", ".project");
			project.setSource(tempFile);
			project.setMetadata(new Metadata());
			project.setName("");
			project.setTva(new TVAnyTime());
			project.setVideo(new Video());
			IProjectServices projectService = ProjectServicesImpl.getInstance();
			projectService.saveProject(project);
		} catch (IOException e) {
			logger.logFatal(Messages.COMMAND_FILE_SAVE_ERROR, e);
		}
		return project;
	}

}

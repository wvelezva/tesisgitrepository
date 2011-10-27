package edu.eafit.maestria.activa.ui.handlers.file;

import java.io.File;

import org.eclipse.jface.wizard.Wizard;

import edu.eafit.maestria.activa.model.Metadata;
import edu.eafit.maestria.activa.model.PCF;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.model.TVAnyTime;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.services.IProjectServices;
import edu.eafit.maestria.activa.services.ProjectServicesImpl;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.Constants;

public class NewWizard extends Wizard {

	private NewWizardPage newWizardPage;
	
	public NewWizard() {
		setWindowTitle(Messages.COMMAND_FILE_NEW_WIZARD_TITLE);
	}

	@Override
	public void addPages() {
		newWizardPage = new NewWizardPage();
		addPage(newWizardPage);
	}

	@Override
	public boolean performFinish() {
		String projectName =  newWizardPage.getProjectName();
		File projectDir = newWizardPage.getProjectLocation();
		File sourceVideo = new File(newWizardPage.getSourceVideo());
		if (projectDir.mkdirs()) {
			File projectFile = new File(projectDir, projectName + Constants.File.PROJECT_FILE_EXTENSION);
			
			IProjectServices projectServices = ProjectServicesImpl.getInstance();
			Project project = new Project();
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
			video.setSource(sourceVideo);
			project.setVideo(video);
		
			return projectServices.saveProject(project);
		}
		return false;
	}

}

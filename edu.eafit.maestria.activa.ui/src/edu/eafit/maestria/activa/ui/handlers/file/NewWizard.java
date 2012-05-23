package edu.eafit.maestria.activa.ui.handlers.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.PlatformUI;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.services.IProjectServices;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class NewWizard extends Wizard {

	private static final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName());
	private NewWizardPage newWizardPage;
	
	public NewWizard() {
		super();
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
		IProjectServices projectServices = (IProjectServices) Container.get(IProjectServices.class);
		Project project = projectServices.newProject(projectName, sourceVideo, projectDir);
		if (project == null) {
			try {
				FileUtils.deleteDirectory(projectDir);
			} catch (IOException e) {
				
			}
			logger.fatal(new Exception(Messages.COMMAND_FILE_NEW_WIZARD_PROJECT_NULL));
			PlatformUI.getWorkbench().close();
		}
		
		ActivaPlayer.getInstance().prepareNewMedia(project.getVideo());
		projectServices.saveProject(project);
		Container.setProject(project);
		
		return true;
	}

}

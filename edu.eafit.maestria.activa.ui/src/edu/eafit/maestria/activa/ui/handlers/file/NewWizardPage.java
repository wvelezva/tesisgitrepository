package edu.eafit.maestria.activa.ui.handlers.file;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.Constants;

public class NewWizardPage extends WizardPage {
	
	private Text projectNameText;
	private Text sourceVideoText;
	private Button objectDetectionCheck;
	private Button sceneDetectionCheck;

	private String supportedFormats;
	private IPreferenceStore store = UIActivator.getDefault().getPreferenceStore();
	private boolean projectNameValid = false;
	/**
	 * Create the wizard.
	 */
	public NewWizardPage() {
		super("wizardPage");
		setImageDescriptor(ResourceManager.getPluginImageDescriptor(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/Folder Add-01 48.png"));
		setTitle(Messages.COMMAND_FILE_NEW_PAGE_WIZARD_TITLE);
		setDescription(Messages.COMMAND_FILE_NEW_PAGE_WIZARD_DESCRIPTION);
		supportedFormats = store.getString(Constants.Preferences.SUPPORTED_FORMATS);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.BORDER);
		
		Label projectNameLabel = new Label(container, SWT.NONE);
		projectNameLabel.setBounds(31, 24, 108, 14);
		projectNameLabel.setText(Messages.COMMAND_FILE_NEW_WIZARD_PROJECT_NAME);
		
		projectNameText = new Text(container, SWT.BORDER);
		projectNameText.setBounds(145, 21, 415, 19);
		
		projectNameText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (projectNameText.getText().isEmpty()) {
					setErrorMessage(Messages.COMMAND_FILE_NEW_WIZARD_PROJECT_NAME_EMPTY);
					setPageComplete(false);
					projectNameValid = false;
				} else {
					if (getProjectLocation().exists()) {
						setErrorMessage(Messages.COMMAND_FILE_NEW_WIZARD_PROJECT_NAME_INVALID);
						setPageComplete(false);
						projectNameValid = false;
					} else {
						setErrorMessage(null);
						projectNameValid = true;
					}
					
					if (projectNameValid && !sourceVideoText.getText().isEmpty()) {
						setErrorMessage(null);
						setPageComplete(true);
					}
				}
			}

		});
		
		projectNameText.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (projectNameText.getText().isEmpty()) {
					setErrorMessage(Messages.COMMAND_FILE_NEW_WIZARD_PROJECT_NAME_EMPTY);
					setPageComplete(false);
					projectNameValid = false;
				}
			}
			
		});
		
		Label sourceVideoLabel = new Label(container, SWT.NONE);
		sourceVideoLabel.setBounds(31, 63, 105, 14);
		sourceVideoLabel.setText(Messages.COMMAND_FILE_NEW_WIZARD_SOURCE_VIDEO);
		
		sourceVideoText = new Text(container, SWT.BORDER);
		sourceVideoText.setEditable(false);
		sourceVideoText.setBounds(145, 60, 309, 19);
		
		Group grpDetection = new Group(container, SWT.NONE);
		grpDetection.setText(Messages.COMMAND_FILE_NEW_WIZARD_GROUP);
		grpDetection.setBounds(20, 99, 540, 80);
		
		objectDetectionCheck = new Button(grpDetection, SWT.CHECK);
		objectDetectionCheck.setEnabled(false);
		objectDetectionCheck.setBounds(10, 10, 526, 18);
		objectDetectionCheck.setText(Messages.COMMAND_FILE_NEW_WIZARD_OBJECT_DETECTION);
		
		sceneDetectionCheck = new Button(grpDetection, SWT.CHECK);
		sceneDetectionCheck.setEnabled(false);
		sceneDetectionCheck.setBounds(10, 34, 526, 18);
		sceneDetectionCheck.setText(Messages.COMMAND_FILE_NEW_WIZARD_SCENE_DETECTION);
		
		Button chooseVideo = new Button(container, SWT.NONE);
		chooseVideo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				FileDialog fileDialog = new FileDialog(getShell());
				fileDialog.setText(Messages.COMMAND_FILE_NEW_SOURCE_VIDEO_OPEN_DIALOG);
				fileDialog.setFilterExtensions(StringUtils.split(supportedFormats, ","));
				
				// Open Dialog and save result of selection
				sourceVideoText.setText(fileDialog.open());
				
				if (!sourceVideoText.getText().isEmpty() && projectNameValid)
					setPageComplete(true);
				else
					setPageComplete(false);
			}
		});
		
		chooseVideo.setBounds(466, 56, 94, 28);
		chooseVideo.setText(Messages.COMMAND_FILE_NEW_SOURCE_VIDEO_BUTTON);

		setControl(container);
		setPageComplete(false);
	}

	public File getProjectLocation(){
		String projectLocation = store.getString(Constants.Preferences.WORKSPACE) + System.getProperty("file.separator") + projectNameText.getText();
		return new File(projectLocation);
	}
	
	public String getProjectName(){
		return projectNameText.getText();
	}
	
	public String getSourceVideo(){
		return sourceVideoText.getText();
	}
}

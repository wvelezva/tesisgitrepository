package edu.eafit.maestria.activa.ui.preferences;

import java.io.File;

import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.Constants;

public class GeneralPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private DirectoryFieldEditor directoryFieldEditor;
	
	public GeneralPage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(UIActivator.getDefault().getPreferenceStore());
		setDescription(Messages.PREFERENCES_GENERAL_DESCRIPTION);
	}

	// checkState allow you to perform validations
	@Override
	protected void checkState() {
		//super.checkState();
		if (!isDirValid()) {
			setErrorMessage(directoryFieldEditor.getErrorMessage());
			setValid(false);
		} else { 
			setErrorMessage(null);
			setValid(true);
		}
	}

	private boolean isDirValid() {
		String directory = directoryFieldEditor.getStringValue();
		if (!directory.isEmpty()) {
			File file = new File(directory);
			if (file.isDirectory()) {
				directoryFieldEditor.setErrorMessage(null);
				return true;
			}else{
				directoryFieldEditor.setErrorMessage(Messages.PREFERENCES_GENERAL_ERROR_WORKSPACE_INVALID);
				return false;
			}
		} else {
			directoryFieldEditor.setErrorMessage(Messages.PREFERENCES_GENERAL_ERROR_WORKSPACE_EMPTY);
			return false;
		}
	}
	
	@Override
	public boolean performOk() {
		checkState();
		if (isValid())
			return super.performOk();
		
		return false;
	}
	
	@Override
	public void createFieldEditors() {
		directoryFieldEditor = new DirectoryFieldEditor(Constants.Preferences.WORKSPACE, Messages.PREFERENCES_GENERAL_WORKSPACE, getFieldEditorParent());
		directoryFieldEditor.setEmptyStringAllowed(false);
		//directoryFieldEditor.setChangeButtonText("Abra cadaba");
		isDirValid();
		addField(directoryFieldEditor);
	}

}

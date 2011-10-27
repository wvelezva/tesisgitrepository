package edu.eafit.maestria.activa.ui.preferences;

import java.io.File;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class Initializer extends AbstractPreferenceInitializer {

	private static LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), Initializer.class);
	
	public Initializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = UIActivator.getDefault().getPreferenceStore();
		initializeWorkspace(store);
		//initializeFormats(store);
	}

	private void initializeWorkspace(IPreferenceStore store) {
		String workingDirectoryPath = System.getProperty("user.home") + System.getProperty("file.separator") + "activa_projects";
		File dir = new File(workingDirectoryPath);
		boolean canWritePref = true;
		if (!dir.exists())
			canWritePref = dir.mkdir();
		else if (!dir.isDirectory()) {
			logger.logError(Messages.PREFERENCES_GENERAL_ERROR_WORKSPACE_INVALID);
			canWritePref = false;
		}
			
		if (canWritePref)
			store.setDefault(Constants.Preferences.WORKSPACE, workingDirectoryPath);
	}
	
//	private void initializeFormats(IPreferenceStore store) {
//		store.setDefault(Constants.Preferences.SUPPORTED_FORMATS, "");
//	}

}

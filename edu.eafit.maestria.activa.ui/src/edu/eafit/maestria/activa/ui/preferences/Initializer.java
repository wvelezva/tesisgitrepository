package edu.eafit.maestria.activa.ui.preferences;

import java.io.File;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class Initializer extends AbstractPreferenceInitializer {

	private static final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName());
	
	public Initializer() {}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = UIActivator.getDefault().getPreferenceStore();
		initializeWorkspace(store);
	}

	private void initializeWorkspace(IPreferenceStore store) {
		String workingDirectoryPath = System.getProperty("user.home") + File.separator + Constants.Preferences.HOME;
		File dir = new File(workingDirectoryPath);
		boolean canWritePref = true;
		if (!dir.exists())
			canWritePref = dir.mkdir();
		else if (!dir.isDirectory()) {
			logger.error(Messages.PREFERENCES_GENERAL_ERROR_WORKSPACE_INVALID);
			canWritePref = false;
		}
			
		if (canWritePref)
			store.setDefault(Constants.Preferences.WORKSPACE, workingDirectoryPath);
	}

}

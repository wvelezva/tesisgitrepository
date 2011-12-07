package edu.eafit.maestria.activa.ui;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import edu.eafit.maestria.activa.ui.player.ActivaPlayer;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        //configurer.setInitialSize(new Point(1000, 800));
        //configurer.setShowCoolBar(true);
        //configurer.setShowStatusLine(true);
        configurer.setShowProgressIndicator(true);
    }
    
    //FIXME aca es donde se debe crear un dialogo modal al salir para preguntarle al usuario en caso de no estar salvado el proyecto
    public boolean preWindowShellClose() {
    	return super.preWindowShellClose();
    }
    
    public void dispose() {
    	ActivaPlayer.getInstance().release();
    }
    
}

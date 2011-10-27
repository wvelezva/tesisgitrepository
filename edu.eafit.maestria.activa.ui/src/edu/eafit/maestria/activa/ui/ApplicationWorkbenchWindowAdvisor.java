package edu.eafit.maestria.activa.ui;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

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
    
}

package edu.eafit.maestria.activa.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextService;

import edu.eafit.maestria.activa.ui.player.Player;

public class Perspective implements IPerspectiveFactory {

	/**
	 * The ID of the perspective as specified in the extension.
	 */
	public static final String ID = "activa.ui.perspective";

	public void createInitialLayout(IPageLayout layout) {
//		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
//			   public void run() {
//			    ((IContextService) PlatformUI.getWorkbench()
//			     .getService(IContextService.class))
//			      .activateContext("activa.context");
//			   }
//			});
		
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);

		IFolderLayout folder = layout.createFolder("messages", IPageLayout.TOP, 0.75f, editorArea);
		folder.addPlaceholder(Player.ID + ":*");
		folder.addView(Player.ID);
		
		IFolderLayout scenes = layout.createFolder("scenes", IPageLayout.BOTTOM, 0.25f, editorArea);
		scenes.addPlaceholder(NavigationView.ID+ ":*");
		scenes.addView(NavigationView.ID);
		
		IViewLayout viewLayout = layout.getViewLayout(Player.ID);
		viewLayout.setCloseable(false);
		viewLayout.setMoveable(false);
		
		IViewLayout navigationLayout = layout.getViewLayout(NavigationView.ID);
		navigationLayout.setCloseable(false);
		navigationLayout.setMoveable(false);
	}
}

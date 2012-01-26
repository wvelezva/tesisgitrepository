package edu.eafit.maestria.activa.ui.player.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.services.AnimationUtils;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.ui.player.Player;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class LoadEntityHandler extends AbstractHandler implements IHandler {

	LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), LoadEntityHandler.class);
	
	public static final String commandId = "activa.ui.command.player.loadEntity";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<Animation> selected = new ArrayList<Animation>();
		AnimationUtils.getSelected(ActivaPlayer.getInstance().getOverlay().getAnimations(), selected);
		if (selected.size() == 1) {
			final Animation animation= selected.get(0);
			Display.getDefault().syncExec(new Runnable () {
				@Override
				public void run(){
					IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
					IWorkbenchPage page = window.getActivePage();
					((Player) page.findView(Player.ID)).loadEntity(animation);
				}
			});
		}
		
		return null;
	}

}

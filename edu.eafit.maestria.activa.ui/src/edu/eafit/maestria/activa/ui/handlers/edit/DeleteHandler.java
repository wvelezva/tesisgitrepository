package edu.eafit.maestria.activa.ui.handlers.edit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.services.AnimationUtils;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.ui.player.Overlay;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class DeleteHandler extends AbstractHandler implements IHandler {

	LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), DeleteHandler.class);
	
	public static final String commandId = "activa.ui.command.player.delete";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<Animation> selected = new ArrayList<Animation>();
		Overlay overlay = ActivaPlayer.getInstance().getOverlay();
		AnimationUtils.getSelected(overlay.getAnimations(), selected);
		
		for (Animation animation : selected) {
			Container.getProject().getVideo().deleteShape(ActivaPlayer.getInstance().getCurrentFrame(), animation);
		}
		
		overlay.repaint();
		
		return null;
	}

}

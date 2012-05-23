package edu.eafit.maestria.activa.ui.handlers.detect;

import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.services.AnimationUtils;
import edu.eafit.maestria.activa.tracking.Tracker;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.ui.utils.Messages;

public abstract class TrackerHandler extends AbstractHandler implements IHandler {

	private ActivaPlayer activaPlayer = ActivaPlayer.getInstance();
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		List<Animation> selected = new ArrayList<Animation>();
		AnimationUtils.getSelected(activaPlayer.getOverlay().getAnimations(), selected);
		if (selected == null || selected.isEmpty()) {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event), getMethodName(), Messages.TRACKING_NO_OBJECT_SELECTED);
			return null;
		}
		Animation animation = selected.get(0);
		
		Shape shape = animation.getShape(activaPlayer.getCurrentFrame());
		long currentTime = activaPlayer.getCurrentTime();
		
		BufferedImage template = activaPlayer.getTemplate(shape.getBounds());
		
		Video video = Container.getProject().getVideo();
		Tracker tracker = new Tracker(video.getVideo());
		List<Shape> matches = track(tracker, currentTime, shape, template, true);
		tracker.release();
		
		if (matches != null && !matches.isEmpty()){
			animation.setShapes(matches, activaPlayer.getCurrentFrame()+1);
			for (int i = activaPlayer.getCurrentFrame()+1; i < (activaPlayer.getCurrentFrame() + 1) + matches.size(); i++){
				video.addAnimation(i, animation);
			}
		} else {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event), getMethodName(), Messages.TRACKING_NO_MATCHES);
		}
		return null;
	}

	public abstract String getMethodName();
	
	public abstract List<Shape> track(Tracker tracker, long currentTime, Shape shape, BufferedImage template, boolean saveImg);
}

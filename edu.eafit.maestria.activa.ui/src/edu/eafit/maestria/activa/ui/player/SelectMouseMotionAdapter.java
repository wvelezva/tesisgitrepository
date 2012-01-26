package edu.eafit.maestria.activa.ui.player;

import java.awt.Point;
import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.services.AnimationUtils;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class SelectMouseMotionAdapter extends ActivaMouseMotionAdapter {

	LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), SelectMouseMotionAdapter.class);
	
	private Overlay overlay;
	private Point delta = new Point();

	public void setOverlay(Overlay overlay) {
		this.overlay = overlay;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (overlay.isSelecting()) {
			overlay.getMouseRect().setBounds(
					Math.min(overlay.getMousePt().x, e.getX()),
					Math.min(overlay.getMousePt().y, e.getY()),
					Math.abs(overlay.getMousePt().x - e.getX()),
					Math.abs(overlay.getMousePt().y - e.getY()));
			AnimationUtils.selectRect(overlay.getAnimations(), overlay.getMouseRect(), overlay.getCurrentFrame());
			
			
		} else {
			delta.setLocation(e.getX() - overlay.getMousePt().x, e.getY() - overlay.getMousePt().y);
			AnimationUtils.updatePosition(overlay.getAnimations(), delta, overlay.getCurrentFrame());
			overlay.setMousePt(e.getPoint());
			loadEntity();
		}
		overlay.repaint();
	}

}
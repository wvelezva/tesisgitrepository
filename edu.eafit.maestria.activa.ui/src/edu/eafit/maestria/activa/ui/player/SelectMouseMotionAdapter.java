package edu.eafit.maestria.activa.ui.player;

import java.awt.Point;
import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.services.AnimationUtils;

public class SelectMouseMotionAdapter extends ActivaMouseMotionAdapter {

	private Overlay overlay;
	private Point delta = new Point();
	private ActivaPlayer activaPlayer = ActivaPlayer.getInstance();

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
			AnimationUtils.selectRect(overlay.getAnimations(), overlay.getMouseRect(), activaPlayer.getCurrentFrame());
			
			
		} else {
			delta.setLocation(e.getX() - overlay.getMousePt().x, e.getY() - overlay.getMousePt().y);
			AnimationUtils.updatePosition(overlay.getAnimations(), delta, activaPlayer.getCurrentFrame());
			overlay.setMousePt(e.getPoint());
			loadEntity();
		}
		overlay.repaint();
	}

}
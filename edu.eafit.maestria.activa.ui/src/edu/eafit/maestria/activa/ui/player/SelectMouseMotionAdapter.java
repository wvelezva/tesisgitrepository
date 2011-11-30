package edu.eafit.maestria.activa.ui.player;

import java.awt.Point;
import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.model.Node;

public class SelectMouseMotionAdapter extends ActivaMouseMotionAdapter {

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
			Node.selectRect(overlay.getNodes(), overlay.getMouseRect(), overlay.getCurrentFrame());
		} else {
			delta.setLocation(e.getX() - overlay.getMousePt().x, e.getY() - overlay.getMousePt().y);
			Node.updatePosition(overlay.getNodes(), delta, overlay.getCurrentFrame());
			overlay.setMousePt(e.getPoint());
		}
		overlay.repaint();
	}

}
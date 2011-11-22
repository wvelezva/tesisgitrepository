package edu.eafit.maestria.activa.ui.player;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class ActivaMouseMotionAdapter extends MouseMotionAdapter{
	/**
	 * 
	 */
	private Overlay overlay;

	/**
	 * @param sobre
	 */
	ActivaMouseMotionAdapter(Overlay overlay) {
		this.overlay = overlay;
	}

	Point delta = new Point();

    @Override
    public void mouseDragged(MouseEvent e) {
    	if (overlay.selecting) {
            overlay.mouseRect.setBounds(
                Math.min(overlay.mousePt.x, e.getX()),
                Math.min(overlay.mousePt.y, e.getY()),
                Math.abs(overlay.mousePt.x - e.getX()),
                Math.abs(overlay.mousePt.y - e.getY()));
            Node.selectRect(overlay.nodes, overlay.mouseRect);
        } else {
            delta.setLocation(
                e.getX() - overlay.mousePt.x,
                e.getY() - overlay.mousePt.y);
            Node.updatePosition(overlay.nodes, delta);
            overlay.mousePt = e.getPoint();
        }
        overlay.repaint();
    }
	
}
package edu.eafit.maestria.activa.ui.player;

import java.awt.Point;
import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.model.Node;

public class MoveMouseMotionAdapter extends ActivaMouseMotionAdapter{
	/**
	 * 
	 */
	private Overlay overlay;

	public void setOverlay(Overlay overlay) {
		this.overlay = overlay;
	}
	
	Point delta = new Point();

    @Override
    public void mouseDragged(MouseEvent e) {
    	delta.setLocation(e.getX() - overlay.getMousePt().x,e.getY() - overlay.getMousePt().y);
        Node.updatePosition(overlay.getNodes(), delta, overlay.getCurrentFrame());
        overlay.setMousePt(e.getPoint());
        
        overlay.repaint();
    }
	
}
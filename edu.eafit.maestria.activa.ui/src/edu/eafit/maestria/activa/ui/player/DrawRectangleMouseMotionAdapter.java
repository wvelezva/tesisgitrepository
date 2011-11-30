package edu.eafit.maestria.activa.ui.player;

import java.awt.event.MouseEvent;

public class DrawRectangleMouseMotionAdapter extends ActivaMouseMotionAdapter{

	private Overlay overlay;
	
	public void setOverlay(Overlay overlay) {
		this.overlay = overlay;
	}
	

    @Override
    public void mouseDragged(MouseEvent e) {
    	if (overlay.isDrawing()) {
            overlay.getMouseRect().setBounds(
                Math.min(overlay.getMousePt().x, e.getX()),
                Math.min(overlay.getMousePt().y, e.getY()),
                Math.abs(overlay.getMousePt().x - e.getX()),
                Math.abs(overlay.getMousePt().y - e.getY()));
        } 
        overlay.repaint();
    }
	
}
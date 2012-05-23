package edu.eafit.maestria.activa.ui.player;

import java.awt.event.MouseEvent;

public class DrawPolygonMouseMotionAdapter extends ActivaMouseMotionAdapter{

	private Overlay overlay;
	
	public void setOverlay(Overlay overlay) {
		this.overlay = overlay;
	}
	
    @Override
    public void mouseMoved(MouseEvent e) {
    	overlay.repaint();
    }
	
}
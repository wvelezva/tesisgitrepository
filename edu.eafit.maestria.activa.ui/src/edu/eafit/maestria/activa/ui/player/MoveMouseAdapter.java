package edu.eafit.maestria.activa.ui.player;

import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.services.AnimationUtils;

public class MoveMouseAdapter extends ActivaMouseAdapter{
	
	private Overlay overlay;

	public void setOverlay(Overlay overlay) {
		this.overlay = overlay;
		this.overlay.setDrawing(false);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		overlay.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e){
		ActivaPlayer.getInstance().pause();
		overlay.setMousePt(e.getPoint());
		if (AnimationUtils.selectOne(overlay.getAnimations(), overlay.getMousePt(), overlay.getCurrentFrame())) {
            overlay.setSelecting(false);
        } else {
            AnimationUtils.selectNone(overlay.getAnimations());
            overlay.setSelecting(true);
        }
		
		overlay.repaint();
	}

}
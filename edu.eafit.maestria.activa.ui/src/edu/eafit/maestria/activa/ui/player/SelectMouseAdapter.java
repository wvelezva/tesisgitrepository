package edu.eafit.maestria.activa.ui.player;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.services.AnimationUtils;

public class SelectMouseAdapter extends ActivaMouseAdapter{
	
	private Overlay overlay;
	private ActivaPlayer activaPlayer = ActivaPlayer.getInstance();

	public SelectMouseAdapter(){
		
	}
	
	public void setOverlay(Overlay overlay) {
		this.overlay = overlay;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		overlay.setSelecting(false);
		overlay.setMouseRect(new Rectangle(0, 0, 0, 0));

		if (e.isPopupTrigger()) {
			overlay.showPopup(e.getComponent(), e.getX(), e.getY());
		} 
		
		loadEntity();
		
		overlay.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e){
		activaPlayer.pause();
		
		overlay.setMousePt(e.getPoint());
		if (e.isShiftDown()) {
            AnimationUtils.selectToggle(overlay.getAnimations(), overlay.getMousePt(), activaPlayer.getCurrentFrame());
        } else if (e.isPopupTrigger()) {
			AnimationUtils.selectOne(overlay.getAnimations(), overlay.getMousePt(), activaPlayer.getCurrentFrame());
			overlay.showPopup(e.getComponent(), e.getX(), e.getY());
		} else if (AnimationUtils.selectOne(overlay.getAnimations(), overlay.getMousePt(), activaPlayer.getCurrentFrame())) {
            overlay.setSelecting(false);
        } else {
            AnimationUtils.selectNone(overlay.getAnimations());
            overlay.setSelecting(true);
        }
        overlay.repaint();
	}
}
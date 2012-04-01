package edu.eafit.maestria.activa.ui.player;

import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.ShapeKind;
import edu.eafit.maestria.activa.services.AnimationUtils;

public class DrawRectangleMouseAdapter extends ActivaMouseAdapter{
	
	private Overlay overlay;
	private ActivaPlayer activaPlayer= ActivaPlayer.getInstance();

	public void setOverlay(Overlay overlay) {
		this.overlay = overlay;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		overlay.setDrawing(false);
		if (e.isPopupTrigger()) {
			showPopup(e);
		} else {
			AnimationUtils.selectNone(overlay.getAnimations());
            Animation n = new Animation(overlay.getMouseRect(), overlay.getCurrentColor(), ShapeKind.RECTANGLE, activaPlayer.getCurrentFrame());
            n.setSelected(true);
            overlay.add(n);
            loadEntity();
		}
		overlay.getMouseRect().setBounds(0, 0, 0, 0);
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
			showPopup(e);
		} else {
            AnimationUtils.selectNone(overlay.getAnimations());
            overlay.setDrawing(true);
        }
        overlay.repaint();
	}
	
	private void showPopup(MouseEvent e) {
		overlay.showPopup(e.getComponent(), e.getX(), e.getY());
	}

}
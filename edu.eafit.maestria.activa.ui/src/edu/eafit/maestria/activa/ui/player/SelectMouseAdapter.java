package edu.eafit.maestria.activa.ui.player;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.model.Node;

public class SelectMouseAdapter extends ActivaMouseAdapter{
	
	private Overlay overlay;

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
		
		overlay.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e){
		ActivaPlayer.getInstance().pause();
		
		overlay.setMousePt(e.getPoint());
		if (e.isShiftDown()) {
            Node.selectToggle(overlay.getNodes(), overlay.getMousePt(), overlay.getCurrentFrame());
        } else if (e.isPopupTrigger()) {
			Node.selectOne(overlay.getNodes(), overlay.getMousePt(), overlay.getCurrentFrame());
			overlay.showPopup(e.getComponent(), e.getX(), e.getY());
		} else if (Node.selectOne(overlay.getNodes(), overlay.getMousePt(), overlay.getCurrentFrame())) {
            overlay.setSelecting(false);
        } else {
            Node.selectNone(overlay.getNodes());
            overlay.setSelecting(true);
        }
        overlay.repaint();
	}
}
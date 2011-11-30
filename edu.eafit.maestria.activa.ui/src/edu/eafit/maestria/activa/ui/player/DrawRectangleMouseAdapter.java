package edu.eafit.maestria.activa.ui.player;

import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.model.Node;
import edu.eafit.maestria.activa.model.ShapeKind;

public class DrawRectangleMouseAdapter extends ActivaMouseAdapter{
	
	private Overlay overlay;

	public void setOverlay(Overlay overlay) {
		this.overlay = overlay;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		overlay.setDrawing(false);
		if (e.isPopupTrigger()) {
			showPopup(e);
		} else {
			Node.selectNone(overlay.getNodes());
            Node n = new Node(overlay.getMouseRect(), overlay.getCurrentColor(), ShapeKind.RECTANGLE, overlay.getCurrentFrame());
            n.setSelected(true);
            overlay.add(n);
		}
		overlay.getMouseRect().setBounds(0, 0, 0, 0);
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
			showPopup(e);
		} else {
            Node.selectNone(overlay.getNodes());
            overlay.setDrawing(true);
        }
        overlay.repaint();
	}
	
	private void showPopup(MouseEvent e) {
		overlay.showPopup(e.getComponent(), e.getX(), e.getY());
	}

}
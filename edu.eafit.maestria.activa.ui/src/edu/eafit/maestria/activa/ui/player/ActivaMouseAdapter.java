package edu.eafit.maestria.activa.ui.player;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ActivaMouseAdapter extends MouseAdapter{
	
	private Overlay overlay;

	/**
	 * @param sobre
	 */
	ActivaMouseAdapter(Overlay overlay) {
		this.overlay = overlay;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		overlay.selecting = false;
		if (e.isPopupTrigger()) {
			showPopup(e);
		} else {
			Node.selectNone(overlay.nodes);
            Node n = new Node(overlay.mouseRect, Color.red, ShapeKind.RECTANGLE);
            n.setSelected(true);
            overlay.nodes.add(n);
		}
		overlay.mouseRect.setBounds(0, 0, 0, 0);
		overlay.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e){
		//ActivaPlayer.getInstance().pause();
		
		overlay.mousePt = e.getPoint();
		
		if (e.isShiftDown()) {
            Node.selectToggle(overlay.nodes, overlay.mousePt);
        } else if (e.isPopupTrigger()) {
			Node.selectOne(overlay.nodes, overlay.mousePt);
			showPopup(e);
		} else if (Node.selectOne(overlay.nodes, overlay.mousePt)) {
            overlay.selecting = false;
        } else {
            Node.selectNone(overlay.nodes);
            overlay.selecting = true;
        }
        overlay.repaint();
	}
	
	private void showPopup(MouseEvent e) {
		overlay.popup.show(e.getComponent(), e.getX(), e.getY());
	}

}
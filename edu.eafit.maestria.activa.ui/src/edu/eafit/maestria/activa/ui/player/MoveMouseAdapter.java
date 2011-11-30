package edu.eafit.maestria.activa.ui.player;

import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.model.Node;

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
		if (Node.selectOne(overlay.getNodes(), overlay.getMousePt(), overlay.getCurrentFrame())) {
            overlay.setSelecting(false);
        } else {
            Node.selectNone(overlay.getNodes());
            overlay.setSelecting(true);
        }
		
		//Node.selectOne(overlay.getNodes(), overlay.getMousePt());
        
        overlay.repaint();
	}

}
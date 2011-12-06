package edu.eafit.maestria.activa.ui.player;

import java.awt.Polygon;
import java.awt.event.MouseEvent;

import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.ShapeKind;
import edu.eafit.maestria.activa.services.AnimationUtils;

public class DrawPolygonMouseAdapter extends ActivaMouseAdapter{
	
	private Overlay overlay;
	
	
	public void setOverlay(Overlay overlay) {
		this.overlay = overlay;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		ActivaPlayer.getInstance().pause();
		
		overlay.setMousePt(e.getPoint());
		
		if (e.isShiftDown()) {
            AnimationUtils.selectToggle(overlay.getAnimations(), overlay.getMousePt(), overlay.getCurrentFrame());
        } else if (e.isPopupTrigger()) {
			AnimationUtils.selectOne(overlay.getAnimations(), overlay.getMousePt(), overlay.getCurrentFrame());
			overlay.showPopup(e.getComponent(), e.getX(), e.getY());
		} else {
            AnimationUtils.selectNone(overlay.getAnimations());
            overlay.setDrawing(true);
        }
		if (isCompleted()) {
			overlay.getPolygon().addPoint(overlay.getPolygon().xpoints[0], overlay.getPolygon().ypoints[0]);
			AnimationUtils.selectNone(overlay.getAnimations());
            Animation n = new Animation(overlay.getPolygon(), overlay.getCurrentColor(), ShapeKind.POLYGON, overlay.getCurrentFrame());
            n.setSelected(true);
            overlay.add(n);
            
            overlay.setPolygon(new Polygon());
		} else {
			overlay.getPolygon().addPoint(e.getPoint().x, e.getPoint().y);
		}
        overlay.repaint();
	}

	private boolean isCompleted() {
		if (overlay.getPolygon().npoints >= 3 ) {
			double distance = overlay.getMousePt().distance(overlay.getPolygon().xpoints[0], overlay.getPolygon().ypoints[0]);
			if (distance < 20)
				return true;
		}
		return false;
	}

}
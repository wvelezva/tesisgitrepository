package edu.eafit.maestria.activa.ui.handlers.detect;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import edu.eafit.maestria.activa.tracking.OpticalFlowTracker;
import edu.eafit.maestria.activa.tracking.Tracker;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;

public class OpticalFlowHandler extends TrackerHandler {

	private ActivaPlayer activaPlayer = ActivaPlayer.getInstance();
	
	@Override
	public String getMethodName() {
		return "Optical Flow";
	}
	@Override
	public List<Shape> track(Tracker tracker, long currentTime, Shape shape,	BufferedImage template, boolean saveImages) {
		
		Polygon polygon = (Polygon)shape;
		Polygon fixedPolygon = new Polygon();
		for (int i = 0; i < polygon.npoints; i++){
			fixedPolygon.addPoint(activaPlayer.adjustXToVideo(polygon.xpoints[i]), activaPlayer.adjustYToVideo(polygon.ypoints[i]));
		}
		
		List<List<Point>> matches = new OpticalFlowTracker().track(currentTime, fixedPolygon, template, saveImages);
		
		List<Shape> shapes = new ArrayList<Shape>();
		if (matches != null & !matches.isEmpty()) {
			for (List<Point> points : matches) {
				Polygon poly = new Polygon();
				for (Point point: points){
					poly.addPoint(activaPlayer.adjustVideoToX(point.x), activaPlayer.adjustVideoToY(point.y));
				}
				shapes.add(poly);	
			}
		}
		return shapes;
	}
	
	
}

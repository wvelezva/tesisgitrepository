package edu.eafit.maestria.activa.ui.handlers.detect;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import edu.eafit.maestria.activa.tracking.ObjectFinderExecutor;
import edu.eafit.maestria.activa.tracking.Tracker;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;

public class ObjectFinderHandler extends TrackerHandler {

	private static final String METHOD_NAME = "Object Finder";
	private ActivaPlayer activaPlayer = ActivaPlayer.getInstance();

	@Override
	public String getMethodName() {
		return METHOD_NAME;
	}

	@Override
	public List<Shape> track(Tracker tracker, long currentTime, Shape shape, BufferedImage template, boolean saveImg) {
		Rectangle rectangle = null;
		if (shape instanceof Rectangle)
			rectangle = (Rectangle)shape;
		else
			rectangle = shape.getBounds();
		int[] params = fix(rectangle);
		List<Point> matches = new ObjectFinderExecutor().track(tracker, currentTime, params, template, true);
		if (matches != null && !matches.isEmpty()) 
			return fix(matches, rectangle);
		
		return null;
	}

	private int[] fix(Rectangle rectangle) {
		int[] fixed = new int[4];
		fixed[0] = activaPlayer.adjustXToVideo(rectangle.x);
		fixed[1] = activaPlayer.adjustYToVideo(rectangle.y);
		fixed[2] = activaPlayer.adjustXToVideoNoCorrection(rectangle.width);
		fixed[3] = activaPlayer.adjustYToVideoNoCorrection(rectangle.height);
		return fixed;
	}

	private List<Shape> fix(List<Point> matches, Rectangle rectangle) {
		List<Shape> shapes = new ArrayList<Shape>();
		for (Point p : matches) {
			Rectangle r = new Rectangle(activaPlayer.adjustVideoToX(p.x), activaPlayer.adjustVideoToY(p.y), rectangle.width, rectangle.height);
			
			shapes.add(r);
		}
		return shapes;
	}
}

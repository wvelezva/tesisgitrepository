package edu.eafit.maestria.activa.services;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.ShapeKind;

public class AnimationUtils {
	
	 /** Collected all the selected animations in list. */
    public static void getSelected(List<Animation> list, List<Animation> selected) {
        if (list == null)
        	return;
        
    	selected.clear();
        for (Animation n : list) {
            if (n.isSelected()) {
                selected.add(n);
            }
        }
    }

    /** Select no animations. */
    public static void selectNone(List<Animation> list) {
    	if (list == null)
    		return;
    	
        for (Animation n : list) {
            n.setSelected(false);
        }
    }

    /** Select a single animation; return true if not already selected. */
    public static boolean selectOne(List<Animation> list, Point p, int currentFrame) {
    	if (list == null)
    		return false;
    	
        for (Animation n : list) {
            if (n.contains(p, currentFrame)) {
                if (!n.isSelected()) {
                    AnimationUtils.selectNone(list);
                    n.setSelected(true);
                }
                return true;
            }
        }
        return false;
    }

    /** Select each animation in r for the given frame. */
    public static void selectRect(List<Animation> list, Rectangle r, int currentFrame) {
    	if (list == null)
    		return;
    	
    	for (Animation n : list) {
            n.setSelected(r.intersects(n.getShape(currentFrame).getBounds2D()));
        }
    }

    /** Toggle selected state of each animation containing p for the given frame. */
    public static void selectToggle(List<Animation> list, Point p, int currentFrame) {
    	if (list == null)
    		return;
    	
        for (Animation n : list) {
            if (n.contains(p, currentFrame)) {
                n.setSelected(!n.isSelected());
            }
        }
    }

    /** Update each animation shape's position by d (delta) for the given frame if selected. */
    public static void updatePosition(List<Animation> list, Point delta, int currentFrame) {
    	if (list == null)
    		return;
    	
        for (Animation n : list) {
            if (n.isSelected()) {
            	n.getKind().changeLocation(n.getShape(currentFrame), delta);
                
            }
        }
    }

    /** Update each animation shape's radius r for the given frame if selected. */
    public static void updateRadius(List<Animation> list, Dimension d, int currentFrame) {
    	if (list == null)
    		return;
    	
        for (Animation n : list) {
            if (n.isSelected()) {
                n.getShape(currentFrame).getBounds().setSize(d);
            }
        }
    }

    /** Update each animation's color for the given frame if selected. */
    public static void updateColor(List<Animation> list, Color color) {
    	if (list == null)
    		return;
    	
        for (Animation n : list) {
            if (n.isSelected()) {
                n.setColor(color);
            }
        }
    }

    /** Update each animation's kind if selected. */
    public static void updateKind(List<Animation> list, ShapeKind kind) {
    	if (list == null)
    		return;
    	
        for (Animation n : list) {
            if (n.isSelected()) {
                n.setKind(kind);
            }
        }
    }
}

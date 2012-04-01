package edu.eafit.maestria.activa.model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * The animation cannot be splited, it has to be consecutive, it should have a shape for every frame it belongs to
 * @author wvelezva
 *
 */
@XStreamAlias("animation")
public class Animation {
		
    private Color color;
    private ShapeKind kind;
    private int frameStart;
    private int frameEnd;
    private long entityId;

    @XStreamOmitField
    private IEntity entity;
    
    @XStreamImplicit
    private List<Shape> shapes;

    @XStreamOmitField
    private boolean selected = false;

    /** Construct a new animation. */
    public Animation(Shape r, Color color, ShapeKind kind, int frameStart) {
        this.color = color;
        this.kind = kind;
        shapes = new ArrayList<Shape>();
        shapes.add(this.kind.getNewShape(r));
        this.frameStart = frameStart;
        this.frameEnd = frameStart;
    }

    public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
    public Shape getShape(int frame) {
    	if (frame<=frameStart)
    		return shapes.get(0);
    	else if (frame < frameEnd)
    		return shapes.get(frame-frameStart);
    	else
    		return shapes.get(shapes.size()-1);
	}

	/** Return true if the shape contains p for the given frame. */
    public boolean contains(Point p, int currentFrame) {
        return getShape(currentFrame).contains(p);
    }

    /** Return true if this animations is selected. */
    public boolean isSelected() {
        return selected;
    }

    /** Mark this animations as slected. */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

	public ShapeKind getKind() {
		return kind;
	}

	public void setKind(ShapeKind kind) {
		this.kind = kind;
	}

	public IEntity getEntity() {
		return entity;
	}

	public void setEntity(IEntity entity) {
		this.entity = entity;
		if (entity != null && entityId==0)
			entityId=entity.getEntityId(); 
	}

	public long getEntityId() {
		if (entity != null && entityId != entity.getEntityId())
			 entityId = entity.getEntityId();
		
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	public void cloneShape(boolean next) {
		if (next) {
			Shape lastShape = shapes.get(shapes.size()-1);
			Shape newShape = kind.getNewShape(lastShape);
			shapes.add(newShape);
			frameEnd++;
		} else {
			Shape firstShape = shapes.get(0);
			Shape newShape = kind.getNewShape(firstShape);
			shapes.add(newShape);
			frameStart--;
		}
		
	}

	/**
	 * Deletes the shapes from the currentFrame to the frameEnd from the animation 
	 * @param currentFrame
	 */
	public void deleteShape(int currentFrame) {
		int init = currentFrame - frameStart;
		shapes.subList(init, shapes.size()).clear();

		frameEnd = currentFrame-1 < frameStart ? frameStart : currentFrame-1;
	}

	/**
	 * sets the lists of shapes at currrenFrame position
	 * currentFrame must be between frameStart and FrameEnd+1
	 * @param newShapes
	 * @param currentFrame
	 */
	public void setShapes(List<Shape> newShapes, int currentFrame) {
		if (currentFrame <= frameStart)
			return;
		
		if (currentFrame > frameEnd + 1)
			return;
		
		for (Shape newShape : newShapes){
			if (currentFrame <= frameEnd)
				shapes.add(currentFrame-frameStart, newShape);
			else {
				shapes.add(newShape);
				frameEnd++;
			}
			currentFrame ++;
		}
		
	}
	
}
package edu.eafit.maestria.activa.model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

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
        private List<Shape> shape;

        @XStreamOmitField
        private boolean selected = false;

        /** Construct a new animation. */
        public Animation(Shape r, Color color, ShapeKind kind, int frameStart) {
            this.color = color;
            this.kind = kind;
            shape = new ArrayList<Shape>();
            shape.add(this.kind.getNewShape(r));
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
        		return shape.get(0);
        	else if (frame < frameEnd)
        		return shape.get(frame-frameStart);
        	else
        		return shape.get(shape.size()-1);
		}

		public void setShape(Shape shape, int frame) {
			int pos = frame - frameStart;
			int actualSize = this.shape.size();
			while (actualSize < pos) {
				this.shape.add(this.shape.get(this.shape.size()-1));
				actualSize = this.shape.size();
			}
			this.shape.add(pos, shape);
			frameEnd = actualSize;
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
		
		
    }
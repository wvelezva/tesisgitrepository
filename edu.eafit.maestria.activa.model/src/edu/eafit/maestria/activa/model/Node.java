package edu.eafit.maestria.activa.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

public class Node {

        private Color color;
		private ShapeKind kind;
        private boolean selected = false;
        private List<Shape> shape;
        private int frameStart;
        private int frameEnd;

        /** Construct a new node. */
        public Node(Shape r, Color color, ShapeKind kind, int frameStart) {
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

		/** Return true if this node contains p. */
        public boolean contains(Point p, int currentFrame) {
            return getShape(currentFrame).contains(p);
        }

        /** Return true if this node is selected. */
        public boolean isSelected() {
            return selected;
        }

        /** Mark this node as slected. */
        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        /** Collected all the selected nodes in list. */
        public static void getSelected(List<Node> list, List<Node> selected) {
            if (list == null)
            	return;
            
        	selected.clear();
            for (Node n : list) {
                if (n.isSelected()) {
                    selected.add(n);
                }
            }
        }

        /** Select no nodes. */
        public static void selectNone(List<Node> list) {
        	if (list == null)
        		return;
        	
            for (Node n : list) {
                n.setSelected(false);
            }
        }

        /** Select a single node; return true if not already selected. */
        public static boolean selectOne(List<Node> list, Point p, int currentFrame) {
        	if (list == null)
        		return false;
        	
            for (Node n : list) {
                if (n.contains(p, currentFrame)) {
                    if (!n.isSelected()) {
                        Node.selectNone(list);
                        n.setSelected(true);
                    }
                    return true;
                }
            }
            return false;
        }

        /** Select each node in r. */
        public static void selectRect(List<Node> list, Rectangle r, int currentFrame) {
        	if (list == null)
        		return;
        	
        	for (Node n : list) {
                n.setSelected(r.intersects(n.getShape(currentFrame).getBounds2D()));
            }
        }

        /** Toggle selected state of each node containing p. */
        public static void selectToggle(List<Node> list, Point p, int currentFrame) {
        	if (list == null)
        		return;
        	
            for (Node n : list) {
                if (n.contains(p, currentFrame)) {
                    n.setSelected(!n.isSelected());
                }
            }
        }

        /** Update each node's position by d (delta). */
        public static void updatePosition(List<Node> list, Point delta, int currentFrame) {
        	if (list == null)
        		return;
        	
            for (Node n : list) {
                if (n.isSelected()) {
                	n.kind.changeLocation(n.getShape(currentFrame), delta);
                    
                }
            }
        }

        /** Update each node's radius r. */
        public static void updateRadius(List<Node> list, Dimension d, int currentFrame) {
        	if (list == null)
        		return;
        	
            for (Node n : list) {
                if (n.isSelected()) {
                    n.getShape(currentFrame).getBounds().setSize(d);
                }
            }
        }

        /** Update each node's color. */
        public static void updateColor(List<Node> list, Color color) {
        	if (list == null)
        		return;
        	
            for (Node n : list) {
                if (n.isSelected()) {
                    n.color = color;
                }
            }
        }

        /** Update each node's kind. */
        public static void updateKind(List<Node> list, ShapeKind kind) {
        	if (list == null)
        		return;
        	
            for (Node n : list) {
                if (n.isSelected()) {
                    n.kind = kind;
                }
            }
        }
    }
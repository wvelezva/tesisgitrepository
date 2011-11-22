package edu.eafit.maestria.activa.ui.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

public class Node {

        private Color color;
        private ShapeKind kind;
        private boolean selected = false;
        private Rectangle b = new Rectangle();

        /** Construct a new node. */
        public Node(Rectangle r, Color color, ShapeKind kind) {
            this.color = color;
            this.kind = kind;
            b.setBounds(r.getBounds());
        }

        
        /** Draw this node. */
        public void draw(Graphics2D g2) {
        	
            g2.setPaint(this.color);
            if (this.kind == ShapeKind.POLYGON) {
                //g.drawPolygon(b.x, b.y, b.width, b.height);
            	g2.drawRect(b.x, b.y, b.width, b.height);
            } else if (this.kind == ShapeKind.RECTANGLE) {
                g2.draw(b);
                //g2.fill(b);
            }
            if (selected) {
                g2.setColor(Color.darkGray);
                g2.draw(b);
            }
        }

        /** Return this node's location. */
        public Point getLocation() {
            return b.getLocation();
        }

        /** Return true if this node contains p. */
        public boolean contains(Point p) {
            return b.contains(p);
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
            selected.clear();
            for (Node n : list) {
                if (n.isSelected()) {
                    selected.add(n);
                }
            }
        }

        /** Select no nodes. */
        public static void selectNone(List<Node> list) {
            for (Node n : list) {
                n.setSelected(false);
            }
        }

        /** Select a single node; return true if not already selected. */
        public static boolean selectOne(List<Node> list, Point p) {
            for (Node n : list) {
                if (n.contains(p)) {
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
        public static void selectRect(List<Node> list, Rectangle r) {
            for (Node n : list) {
                n.setSelected(r.contains(n.b.getLocation()));
            }
        }

        /** Toggle selected state of each node containing p. */
        public static void selectToggle(List<Node> list, Point p) {
            for (Node n : list) {
                if (n.contains(p)) {
                    n.setSelected(!n.isSelected());
                }
            }
        }

        /** Update each node's position by d (delta). */
        public static void updatePosition(List<Node> list, Point d) {
            for (Node n : list) {
                if (n.isSelected()) {
                    n.b.setLocation(d);
                }
            }
        }

        /** Update each node's radius r. */
        public static void updateRadius(List<Node> list, Dimension d) {
            for (Node n : list) {
                if (n.isSelected()) {
                    n.b.setSize(d);
                }
            }
        }

        /** Update each node's color. */
        public static void updateColor(List<Node> list, Color color) {
            for (Node n : list) {
                if (n.isSelected()) {
                    n.color = color;
                }
            }
        }

        /** Update each node's kind. */
        public static void updateKind(List<Node> list, ShapeKind kind) {
            for (Node n : list) {
                if (n.isSelected()) {
                    n.kind = kind;
                }
            }
        }
    }
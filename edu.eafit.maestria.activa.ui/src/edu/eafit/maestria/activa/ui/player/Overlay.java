package edu.eafit.maestria.activa.ui.player;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPopupMenu;

import com.sun.awt.AWTUtilities;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.Animation;

public class Overlay extends Window {

	private static final long serialVersionUID = 1L;
	
	private List<Animation> animations = new ArrayList<Animation>();
	private int currentFrame;
	private Point mousePt = new Point(0, 0);
    private Rectangle mouseRect = new Rectangle();
    private Polygon polygon = new Polygon();
    private boolean drawing = false;
    private boolean selecting = false;
    private JPopupMenu popup = new JPopupMenu();
    private Stroke drawStroke = new BasicStroke(3,BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
    private float[] dashes = {10.0F, 3.0F};
    private Stroke selectStroke = new BasicStroke(1,BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashes, 0.0f);
    
    private Color currentColor = Color.red;
    
	public Overlay(Window owner) {
		super(owner);
		//super(owner, WindowUtils.getAlphaCompatibleGraphicsConfiguration());
		AWTUtilities.setWindowOpaque(this, false);
//		setBackground(Color.blue);
//		AWTUtilities.setWindowOpacity(this, 0.9f);
		setLayout(null);
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if (Container.getProject() == null)
			return;
		
		Graphics2D g2 = (Graphics2D) g;
		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		List<Animation> animationsToPaint = getAnimationsToPaint();
		if (animationsToPaint != null) {
			for (Animation n : animationsToPaint) {
				g2.setPaint(n.getColor());
				g2.setStroke(drawStroke);
				g2.draw(n.getShape(currentFrame));
			}
			for (Animation n : animationsToPaint) {
				if (n.isSelected()) {
					g2.setColor(Color.darkGray);
		            g2.setStroke(selectStroke);
		            g2.draw(n.getShape(currentFrame).getBounds());
				}
			}
		}

		if (isDrawing()) {
			g2.setColor(currentColor);
			g2.setStroke(drawStroke);
        	g2.draw(mouseRect);
        	g2.draw(polygon);
        }
		
		if (isSelecting()) {
			g2.setColor(Color.darkGray);
			g2.setStroke(selectStroke);
        	g2.draw(mouseRect);
        }
		
	}
	
	public List<Animation> getAnimations() {
		return animations;
	}

	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	public boolean isDrawing() {
		return drawing;
	}

	public void setDrawing(boolean drawing) {
		this.drawing = drawing;
	}

	public Rectangle getMouseRect() {
		return mouseRect;
	}

	public void setMouseRect(Rectangle mouseRect) {
		this.mouseRect = mouseRect;
	}

	public Point getMousePt() {
		return mousePt;
	}

	public void setMousePt(Point mousePt) {
		this.mousePt = mousePt;
	}

	public void showPopup(Component component, int x, int y) {
		this.popup.show(component, x, y);
	}

	public boolean isSelecting() {
		return selecting;
	}

	public void setSelecting(boolean selecting) {
		this.selecting = selecting;
	}

	public Polygon getPolygon() {
		return polygon;
	}

	public void setPolygon(Polygon poly) {
		this.polygon = poly;
	}

	public void setCurrentFrame(int currentFrame) {
		if (Container.getProject() != null) {
			animations = Container.getProject().getVideo().getAnimationsByFrame(currentFrame);
		}
		this.currentFrame = currentFrame;  
		this.repaint();
	}
	
	public void add(Animation n) {
		if (animations == null) {
			animations = new ArrayList<Animation>();
			Container.getProject().getVideo().setAnimations(currentFrame, animations);
		}
		Container.getProject().getVideo().addAnimation(currentFrame, n);
		
	}

	private List<Animation> getAnimationsToPaint() {
		List<Animation> animationsToPaint = new ArrayList<Animation>();
		int init = currentFrame;
		int end = currentFrame;

		/*if (ActivaPlayer.getInstance().getPlayer().isPlaying()) {
			init = currentFrame - 12;
			if (init < 0)
				init = 0;
		
			end = currentFrame + 12;
		
			if (end > Container.getProject().getVideo().getTotalFrames())
				end = Container.getProject().getVideo().getTotalFrames();
		}*/
		
		if (Container.getProject().getVideo().getAnimations() != null) {
			for (int i = init; i <= end; i ++){
				List<Animation> animationsByFrame = Container.getProject().getVideo().getAnimationsByFrame(i);
				if (animationsByFrame != null)
					animationsToPaint.addAll(animationsByFrame);
			}
		}
		return animationsToPaint;
	}

	
}

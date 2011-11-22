package edu.eafit.maestria.activa.ui.player;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPopupMenu;

import com.sun.awt.AWTUtilities;

public class Overlay extends Window {

	private static final long serialVersionUID = 1L;
	List<Node> nodes = new ArrayList<Node>();
	Point mousePt = new Point(0, 0);
    Rectangle mouseRect = new Rectangle();
    boolean selecting = false;
    JPopupMenu popup = new JPopupMenu();
    private Color color = Color.red;
    private Stroke stroke;
    GradientPaint gp;
    
	public Overlay(Window owner) {
		super(owner);//, WindowUtils.getAlphaCompatibleGraphicsConfiguration());
		AWTUtilities.setWindowOpaque(this, false);
		//setBackground(Color.white);
		//AWTUtilities.setWindowOpacity(this, 0.1f);
		setLayout(null);
		
		stroke = new BasicStroke(3,BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        gp = new GradientPaint(180.0f, 280.0f, new Color(255,
				255, 255, 255), 250.0f, 380.0f, new Color(255, 255, 0, 0));
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(stroke);
		g2.setPaint(Color.red);

		for (Node n : nodes) {
            n.draw(g2);
        }

		if (selecting) {
        	g2.setColor(Color.black);
        	g2.draw(mouseRect);
        }
        
//        g2.drawOval(50, 80, 100, 100);
//        g2.drawOval(200, 180, 100, 100);
//        g2.drawOval(350, 300, 100, 100);
	}
}

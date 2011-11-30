package edu.eafit.maestria.activa.model;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;

public enum ShapeKind {
	RECTANGLE("Rectangle") {
		@Override
		public Shape getNewShape(Shape s){
			return new Rectangle(s.getBounds());
		}

		@Override
		public void changeLocation(Shape s, Point delta) {
			Rectangle r = (Rectangle) s;
			r.translate(delta.x, delta.y);
		}
		
	},
	POLYGON("Polygon"){
		@Override
		public Shape getNewShape(Shape s){
			Polygon p = (Polygon) s;
			return new Polygon(p.xpoints, p.ypoints, p.npoints);
		}

		@Override
		public void changeLocation(Shape s, Point delta) {
			Polygon p = (Polygon) s;
			p.translate(delta.x, delta.y);
		}
	};
	
	private String value;
	
	private ShapeKind(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

	public abstract Shape getNewShape(Shape s);
	public abstract void changeLocation(Shape s, Point delta);
}

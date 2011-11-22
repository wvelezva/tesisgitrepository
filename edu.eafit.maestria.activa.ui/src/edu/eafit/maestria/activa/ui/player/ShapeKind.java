package edu.eafit.maestria.activa.ui.player;

public enum ShapeKind {
	RECTANGLE("Rectangle"),
	POLYGON("Polygon");
	
	private String value;
	
	private ShapeKind(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}

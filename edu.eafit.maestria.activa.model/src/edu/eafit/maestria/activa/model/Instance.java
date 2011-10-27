package edu.eafit.maestria.activa.model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.io.File;
import java.util.List;

public class Instance {
	private Item item;
	private File thumbnail;
	private Color color;
	private Shape shape;
	private Point[] position;
	private boolean visible;
	private String description;
	private long start;
	private long end;
	private List<Property> properties;
	private List<File> resources;
}
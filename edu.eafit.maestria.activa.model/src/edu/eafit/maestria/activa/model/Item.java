package edu.eafit.maestria.activa.model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.io.File;
import java.util.List;

public class Item {
	private String ID;
	private String name;
	private String description;
	private List<Property> properties;
	private List<File> resources;
	private File thumbnail;
}
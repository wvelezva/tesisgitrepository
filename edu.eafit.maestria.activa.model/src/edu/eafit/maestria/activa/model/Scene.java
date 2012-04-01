package edu.eafit.maestria.activa.model;

import java.io.File;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("scene")
public class Scene {
	@XStreamAsAttribute
	private long id;
	private File scene;
	private File thumbnail;
	private int start; //frames
	private int end;	//frames
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public File getScene() {
		return scene;
	}
	public void setScene(File scene) {
		this.scene = scene;
	}
	public File getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(File thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
}

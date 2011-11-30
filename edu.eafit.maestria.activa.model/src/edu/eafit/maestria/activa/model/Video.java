package edu.eafit.maestria.activa.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.eafit.maestria.activa.model.converters.Convertable;

@XStreamAlias("video")
public class Video implements Convertable{
	private File video;
	private File source;

	private File snapshotDirectory;
	//esto es opcional hay que ver en cual de los archivos de metadatos va o se replica
	private long length; //duration in ms
	private float fps; //frames per second
	private int totalFrames;
	private int width;
	private int height;

	private String format;
	private long size;
	private String audioCodec;
	private String audioInfo;
	private String videoCodec;
	
	@XStreamImplicit
	private List<Scene> scenes;
	
	private Map<Integer, List<Node>> nodes;
	
	@XStreamOmitField
	private boolean modified;
	
	public Video(){
	}
	
	public File getVideo() {
		return video;
	}
	public void setVideo(File video) {
		modified = true;
		this.video = video;
	}
	public File getSource() {
		return source;
	}
	public void setSource(File source) {
		modified = true;
		this.source = source;
	}
	
	public File getSnapshotDirectory() {
		return snapshotDirectory;
	}
	public void setSnapshotDirectory(File snapshotDirectory) {
		modified = true;
		this.snapshotDirectory = snapshotDirectory;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		modified = true;
		this.length = length;
		updateTotalFrames();
	}
	private void updateTotalFrames() {
		if (fps > 0 && length > 0 && totalFrames == 0)
			totalFrames = Double.valueOf(Math.floor(fps*(length/1000))).intValue();
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		modified = true;
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		modified = true;
		this.height = height;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		modified = true;
		this.format = format;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		modified = true;
		this.size = size;
	}
	public float getFps() {
		return fps;
	}
	public void setFps(float fps) {
		modified = true;
		this.fps = fps;
		updateTotalFrames();
	}
	public String getAudioCodec() {
		return audioCodec;
	}
	public void setAudioCodec(String audioCodec) {
		modified = true;
		this.audioCodec = audioCodec;
	}
	public String getAudioInfo() {
		return audioInfo;
	}
	public void setAudioInfo(String audioInfo) {
		modified = true;
		this.audioInfo = audioInfo;
	}
	public String getVideoCodec() {
		return videoCodec;
	}
	public void setVideoCodec(String videoCodec) {
		modified = true;
		this.videoCodec = videoCodec;
	}
	
	public List<Scene> getScenes() {
		return scenes;
	}
	public void setScenes(List<Scene> scenes) {
		modified = true;
		this.scenes = scenes;
	}
	public void addScene(Scene scene){
		if (scenes == null)
			scenes = new ArrayList<Scene>();
		
		scenes.add(scene);
		modified = true;
	}
	@Override
	public boolean isModified() {
		return modified;
	}
	@Override
	public void resetModified(){
		modified=false;
	}

	public Map<Integer, List<Node>> getNodes() {
		return nodes;
	}

	public void setNodes(Integer frame, List<Node> nodes) {
		if (this.nodes == null)
			this.nodes = new HashMap<Integer, List<Node>>();
		
		this.nodes.put(frame, nodes);
	}
	
	public List<Node> getNodesByFrame(Integer frame){
		if (nodes == null)
			return null;
		return nodes.get(frame);
	}
	
	public int getTotalFrames() {
		return totalFrames;
	}
	
}

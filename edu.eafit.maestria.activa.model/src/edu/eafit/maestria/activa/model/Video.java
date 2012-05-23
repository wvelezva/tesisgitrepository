package edu.eafit.maestria.activa.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.eafit.maestria.activa.model.converters.Convertable;
import edu.eafit.maestria.activa.utilities.Constants;

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
	
	private Map<Integer, List<Animation>> animations;
	
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
		Scene scene = getScenes().get(0);
		scene.setStart(0);
		scene.setEnd(totalFrames);
	}
	private void updateTotalFrames() {
		if (fps > 0 && length > 0 && totalFrames == 0)
			totalFrames = Double.valueOf(Math.ceil(fps*(length/Constants.Player.MILLIS_IN_SECONDS))).intValue();
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

	public Map<Integer, List<Animation>> getAnimations() {
		return animations;
	}

	public void setAnimations(Integer frame, List<Animation> animations) {
		modified = true;
		if (this.animations == null)
			this.animations = new HashMap<Integer, List<Animation>>();
		
		this.animations.put(frame, animations);
	}
	
	public List<Animation> getAnimationsByFrame(Integer frame){
		if (animations == null)
			return null;
		return animations.get(frame);
	}
	
	public int getTotalFrames() {
		return totalFrames;
	}
	
	public List<Animation> getAllAnimations(){
		Set<Animation> allAnimations = new HashSet<Animation>();
		if (animations != null)
			for (List<Animation> animationsByFrame : animations.values()) {
				allAnimations.addAll(animationsByFrame);
			}
		
		return new ArrayList<Animation>(allAnimations);
	}

	public void addAnimation(Integer currentFrame, Animation n) {
		if (!animations.containsKey(currentFrame))
			animations.put(currentFrame, new ArrayList<Animation>());
		
		if (!animations.get(currentFrame).contains(n))
			animations.get(currentFrame).add(n);
		modified=true;
	}
	
	public void deleteAnimation(Integer currentFrame, Animation n) {
		if (animations.containsKey(currentFrame))
			animations.get(currentFrame).remove(n);
		
		modified=true;
	}
	
	@Override
	public void setModified() {
		modified=true;		
	}

	/**
	 * if the dstFrame is empty is will be filled with the animations of the srcframe 
	 * @param srcFrame
	 * @param dstFrame
	 */
	public void copyAnimations(int srcFrame, int dstFrame) {
		if (srcFrame == dstFrame)
			return;

		if (animations.containsKey(dstFrame) && animations.get(dstFrame) != null && !animations.get(dstFrame).isEmpty())
			return;
		
		List<Animation> srcAnimations = animations.get(srcFrame);
		if (srcAnimations == null || srcAnimations.isEmpty())
			return;
		
		List<Animation> dstAnimations = new ArrayList<Animation>();
		dstAnimations.addAll(srcAnimations);
		animations.put(dstFrame, dstAnimations);
		boolean next = (dstFrame - srcFrame) > 0;
		for (Animation animation : srcAnimations){
			animation.cloneShape(next);
		}
				
		modified = true;
	}

	public void deleteShape(int currentFrame, Animation animation) {
		animation.deleteShape(currentFrame);
		List<Animation> animationsByFrame = animations.get(currentFrame++);
		while (animationsByFrame != null && !animationsByFrame.isEmpty()){
			if (animationsByFrame.remove(animation))
				animationsByFrame = animations.get(currentFrame++);
			else
				break;
		}
		modified = true;
	}

	public Scene getSceneByFrame(int frame){
		for (Scene scene : scenes){
			if (frame >= scene.getStart() && frame <= scene.getEnd())
				return scene;
		}
		return null;
	}
}

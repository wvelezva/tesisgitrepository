package edu.eafit.maestria.activa.model;

import java.io.File;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.eafit.maestria.activa.model.converters.Convertable;

public class Video implements Convertable, Modifiable{
	private File source;

	//esto es opcional hay que ver en cual de los archivos de metadatos va o se replica
	private long duration;
	private int width;
	private int height;
	private String format;
	private long size;
	private String framesRate;
	private String audioCodec;
	private String audioInfo;
	private String videoCodec;

	@XStreamOmitField
	private boolean modified;
	
	public File getSource() {
		return source;
	}
	public void setSource(File source) {
		this.source = source;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getFramesRate() {
		return framesRate;
	}
	public void setFramesRate(String framesRate) {
		this.framesRate = framesRate;
	}
	public String getAudioCodec() {
		return audioCodec;
	}
	public void setAudioCodec(String audioCodec) {
		this.audioCodec = audioCodec;
	}
	public String getAudioInfo() {
		return audioInfo;
	}
	public void setAudioInfo(String audioInfo) {
		this.audioInfo = audioInfo;
	}
	public String getVideoCodec() {
		return videoCodec;
	}
	public void setVideoCodec(String videoCodec) {
		this.videoCodec = videoCodec;
	}
	@Override
	public boolean isModified() {
		return modified;
	}

	
}

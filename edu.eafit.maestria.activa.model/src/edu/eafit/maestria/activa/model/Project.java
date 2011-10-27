package edu.eafit.maestria.activa.model;

import java.io.File;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import edu.eafit.maestria.activa.model.converters.Convertable;
import edu.eafit.maestria.activa.model.converters.MetadataToFileConverter;
import edu.eafit.maestria.activa.model.converters.PCFToFileConverter;
import edu.eafit.maestria.activa.model.converters.TVAnyTimeToFileConverter;
import edu.eafit.maestria.activa.model.converters.VideoToFileConverter;

@XStreamAlias("project")
public class Project implements Convertable, Modifiable {
	
	@XStreamAsAttribute
	private String ID;
	
	private String name;
	private File source;
	
	@XStreamConverter(VideoToFileConverter.class)
	private Video video;
	@XStreamConverter(PCFToFileConverter.class)
	private PCF pcf;
	@XStreamConverter(TVAnyTimeToFileConverter.class)
	private TVAnyTime tva;
	@XStreamConverter(MetadataToFileConverter.class)
	private Metadata metadata;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public File getSource() {
		return source;
	}
	public void setSource(File source) {
		this.source = source;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public PCF getPcf() {
		return pcf;
	}
	public void setPcf(PCF pcf) {
		this.pcf = pcf;
	}
	public TVAnyTime getTva() {
		return tva;
	}
	public void setTva(TVAnyTime tva) {
		this.tva = tva;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	@Override
	public boolean isModified() {
		return isModified(video) || isModified(pcf) || isModified(metadata) || isModified(tva);
	}
	
	private boolean isModified(Modifiable modifiable) {
		if (modifiable != null)
			return modifiable.isModified();
		return false;
	}
	
}
package edu.eafit.maestria.activa.model;
import java.io.File;
import java.sql.Timestamp;

public interface IResource {
	
	public long getResourceId();
	public void setResourceId(long resourceId);
	public String getName();
	public void setName(String name);
	public Timestamp getCdate();
	public void setCdate(Timestamp cdate);
	public File getFile();
	public void setFile(File file);
	
}

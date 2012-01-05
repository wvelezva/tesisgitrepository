package edu.eafit.maestria.activa.model;

import java.io.File;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;

import edu.eafit.maestria.activa.utilities.ActivaConfig;


@Entity
@Table(name="act_resource")
public class Resource implements IResource
{
	private static final long serialVersionUID = 1L;
	
	private long resourceId;
	private String name;
	private Timestamp cdate;
	private File file;

	private static File baseDir;
	
	@Id
	@GeneratedValue
	@Column(name="resourceid")
	@Override
	public long getResourceId()	{
		return resourceId;
	}

	/**
	 * @param id The id to set.
	 */
	public void setResourceId(long id)
	{
		this.resourceId = id;
	}
	
	
	/**
	 * @return Returns the creationDate.
	 */
	@Column(name="cdate", nullable=false)
	public Timestamp getCdate()
	{
		return cdate;
	}

	/**
	 * @param creationDate The creationDate to set.
	 */
	public void setCdate(Timestamp cdate)
	{
		this.cdate = cdate;
	}

	/**
	 * @return Returns the name.
	 */
	@Column(nullable=false)
	public String getName()
	{
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Returns the file object that is associated with this resource. If the
	 * resource has not been written to the db, null is returned. If the hashed
	 * dirs do not exist, they are created.
	 */
	@Transient
	public File getFile()
	{
		return doGetFile(true);
	}

	/**
	 * This should only be used for testing
	 * @param file
	 */
	public void setFile(File file)
	{
		this.file = file;
	}

	/**
	 * performs the work of getting the file
	 */
	private File doGetFile(boolean mkdirs)
	{
		if (resourceId <= 0 || StringUtils.isBlank(name))
			return null;

		if (file != null)
			return file;

		// the file path is composed as follows:
		// basedir + hashdirs + "resource_<id>" + extension
		// The extension is needed to help virus scanners figure out
		// what kind of file it is processing.

		File baseDir = getBaseDir();
		String hashpath = getHashedPath(resourceId);
		
		File parent = new File(baseDir, hashpath);
		if (mkdirs)
			parent.mkdirs();

		StringBuilder buf = new StringBuilder();
		buf.append("resource_");
		buf.append(Long.toString(getResourceId()));

		int ndx = name.lastIndexOf(".");
		if (ndx > 0) {
			buf.append(name.substring(ndx).trim().toLowerCase());
		}

		file = new File(parent, buf.toString());
		return file;
	}

	/**
	 * force the class to re-evaluate the file. Probably due to a name change.
	 * This should only be called from within DocumentServices.
	 */
	public void resetFile()
	{
		this.file = null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o == null) {
			// The given object is not valid
			return false;
		}
		else if (this == o) {
			// References are identical
			return true;
		}
		else if (o.getClass() != this.getClass()) {
			// We are not even dealing with the same class
			return false;
		}
		else {
			return this.getResourceId() == ((Resource) o).getResourceId();
		}
	}
	
	@Override
	public int hashCode()
	{
		return new HashCodeBuilder(17, 37).append(getResourceId()).toHashCode();
	}
	
	/**
	 * Returns a file path for the hashed location of a given docid. The hash is
	 * built in 2 levels, where each level 2 contains up to 500 entries
	 * 
	 * @throws IllegalStateException if the id is not greater than zero
	 */
	@Transient
	private static String getHashedPath(long id)
	{
		if (id < 0)
			throw new IllegalStateException("Unable to process document hashed path for an invalid id (id=" + id + ")");

		long level1 = id / 250000;
		long level2 = (id % 250000) / 500;

		StringBuilder pathbuf = new StringBuilder();
		pathbuf.append(File.separator);
		pathbuf.append(Long.toString(level1));
		pathbuf.append(File.separator);
		pathbuf.append(Long.toString(level2));

		return pathbuf.toString();
	}
	
	/**
	 * @return
	 */
	@Transient
	public File getBaseDir()
	{
		if(baseDir != null)
			return baseDir;
			
		
		baseDir = new File(ActivaConfig.config.getString(ActivaConfig.DOCUMENTS_BASEDIR));
		return baseDir;
	}
}

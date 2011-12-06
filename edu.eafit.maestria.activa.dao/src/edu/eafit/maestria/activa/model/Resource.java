package edu.eafit.maestria.activa.model;

import java.io.File;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import edu.eafit.maestria.activa.services.IResourceService;

@Entity
@Table(name="act_resource")
@SequenceGenerator(name = SequenceName.RESOURCE_ID, sequenceName = SequenceName.RESOURCE_ID, allocationSize = 1)
public class Resource implements IResource
{
	private static final long serialVersionUID = 1L;
	
	private long resourceId;
	private String name;
	private Timestamp cdate;
	private File file;

	private static IResourceService resourceService;
	
	public static void setResourceService(IResourceService resourceService) {
		Resource.resourceService = resourceService;
	}
	
	@Transient
	public IResourceService getResourceService() {
		if (Resource.resourceService == null) {
			//FIXME implemetar un service locator
			//ResourceInjector.activate(this);
			//Resource.resourceService =  IResourceService();
		}
		return Resource.resourceService;
	}
	
	@Id
	@GeneratedValue(generator = SequenceName.RESOURCE_ID, strategy = GenerationType.SEQUENCE)
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

		File baseDir = getResourceService().getBaseDir();
		String hashpath = getResourceService().getHashedPath(resourceId);
		
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
		//FIXME quitar el comentario siguiente cuando este en el plugin
		//return new HashCodeBuilder(17, 37).append(getResourceId()).toHashCode();
		return 0;
	}
}

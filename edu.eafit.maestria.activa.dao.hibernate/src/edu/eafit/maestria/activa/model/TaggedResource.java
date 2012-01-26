package edu.eafit.maestria.activa.model;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents a resource and its tag and tagging entity
 */
@javax.persistence.Entity
@Table(name="act_tagged_resource")
public class TaggedResource implements ITaggedResource
{
	private long taggedResourceId;
	private IResourceTag tag;
	private IResource resource;
	private IEntity entity;
	private boolean archived;
	
	public TaggedResource(){
		
	}
	
	public TaggedResource(IResourceTag tag, IResource resource)
	{
		this.tag = tag;
		this.resource = resource;
	}
	
	public TaggedResource(IResourceTag tag, IResource resource, IEntity entity)
	{
		this.tag = tag;
		this.resource = resource;
		this.entity = entity;
	}

	@Id
	@GeneratedValue
	@Column(name="tagged_resourceid")
	public long getTaggedResourceId() {
		return taggedResourceId;
	}


	public void setTaggedResourceId(long taggedResourceId) {
		this.taggedResourceId = taggedResourceId;
	}


	/**
	 * @return Returns the archived.
	 */
	public boolean getArchived()
	{
		return archived;
	}

	/**
	 * @param archived The archived to set.
	 */
	public void setArchived(boolean archived)
	{
		this.archived = archived;
	}

	/**
	 * @return Returns the resource.
	 */
	@ManyToOne(targetEntity=Resource.class)
	@JoinColumn(name="resourceid",nullable=false)
	public IResource getResource()
	{
		return resource;
	}

	/**
	 * @param resource The resource to set.
	 */
	public void setResource(IResource resource)
	{
		this.resource = resource;
	}

	/**
	 * @return Returns the tag.
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	public ResourceTag getTag()
	{
		return (ResourceTag)tag;
	}

	/**
	 * @param tag The tag to set.
	 */
	public void setTag(IResourceTag tag)
	{
		this.tag = tag;
	}
	
	@ManyToOne(targetEntity=Entity.class)
	@JoinColumn(name="entityid",nullable=false)
	public IEntity getEntity() {
		return entity;
	}

	public void setEntity(IEntity entity) {
		this.entity = entity;
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
			return (this.getResource().getResourceId() == ((TaggedResource) o).getResource().getResourceId() &&
					this.getTag().getName().equals(((TaggedResource) o).getTag().getName()));
		}
	}

	@Override
	public int hashCode()
	{
		//FIXME quitar el comentario 
//		return new HashCodeBuilder(23, 37).append(getResource() != null ? getResource().getResourceId() : 0).
//				append(getTag() != null ? getTag().getName() : "").toHashCode();
		return 0;
	}
	
}

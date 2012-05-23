package edu.eafit.maestria.activa.dao.hibernate;

import org.hibernate.Session;

import edu.eafit.maestria.activa.dao.ITaggedResourceDao;
import edu.eafit.maestria.activa.dao.hibernate.utils.BaseDaoHibernate;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.ITaggedResource;
import edu.eafit.maestria.activa.model.ResourceTag;
import edu.eafit.maestria.activa.model.TaggedResource;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class TaggedResourceDaoImpl extends BaseDaoHibernate<ITaggedResource> implements ITaggedResourceDao {

	private static final LogUtil logger = LogUtil.getInstance(DAOActivator.getDefault().getBundle().getSymbolicName());
	
	public TaggedResourceDaoImpl(Session session) {
		super(session, TaggedResource.class);
	}

	@Override
	public ITaggedResource addTaggedResource(String tag, IEntity entity, IResource resource) {
		ResourceTag resourceTag = null;
		try {
			resourceTag = ResourceTag.valueOf(tag);
		} catch (IllegalArgumentException e) {
			logger.warning(Messages.TAG_NOT_EXISTS, ResourceTag.ATTACHMENT);
		}
		if (resourceTag == null)
			resourceTag = ResourceTag.ATTACHMENT;
		TaggedResource taggedResource = new TaggedResource(resourceTag, resource, entity);
		
		entity.getTaggedResources().add(taggedResource);
		return taggedResource;
	}
}

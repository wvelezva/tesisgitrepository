package edu.eafit.maestria.activa.ui.model;

import java.io.File;
import java.sql.Timestamp;

import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.IResourceTag;
import edu.eafit.maestria.activa.model.ITaggedResource;
import edu.eafit.maestria.activa.ui.utils.Messages;

public class TaggedResourceHelper implements ITaggedResource {
	@Override
	public IResource getResource() {
		return new IResource() {
			
			@Override
			public void setResourceId(long resourceId) {}
			
			@Override
			public void setName(String name) {}
			
			@Override
			public void setFile(File file) {}
			
			@Override
			public void setCdate(Timestamp cdate) {}
			
			@Override
			public long getResourceId() {
				return 0;
			}
			
			@Override
			public String getName() {
				return "";
			}
			
			@Override
			public File getFile() {
				return null;
			}
			
			@Override
			public Timestamp getCdate() {
				return null;
			}
		};
	}

	@Override
	public void setResource(IResource resource) {}

	@Override
	public IEntity getEntity() {
		return null;
	}

	@Override
	public void setEntity(IEntity entity) {}

	@Override
	public IResourceTag getTag() {
		return new IResourceTag() {
			
			@Override
			public String getName() {
				return Messages.PROPERTIES_NEW_RESOURCE;
			}
		};
	}

	@Override
	public void setTag(IResourceTag tag) {}
}

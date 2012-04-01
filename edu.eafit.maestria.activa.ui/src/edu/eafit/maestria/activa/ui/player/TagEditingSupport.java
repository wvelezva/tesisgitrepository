package edu.eafit.maestria.activa.ui.player;

import org.eclipse.jface.viewers.TableViewer;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.ITaggedResource;
import edu.eafit.maestria.activa.services.IResourceServices;
import edu.eafit.maestria.activa.ui.model.EntityWrapper;
import edu.eafit.maestria.activa.ui.model.TaggedResourceWrapper;
import edu.eafit.maestria.activa.ui.utils.Messages;

public class TagEditingSupport extends EntityEditingSupport {

	public TagEditingSupport(TableViewer viewer) {
		super(viewer);
	}

	@Override
	protected Object getValue(Object element) {
		return ((TaggedResourceWrapper) element).getTag().getName();
	}

	@Override
	protected void setValue(Object element, Object value) {
		TaggedResourceWrapper taggedResourceWrapper = (TaggedResourceWrapper) element;
		if (Messages.PROPERTIES_NEW_RESOURCE.equals(taggedResourceWrapper.getTag().getName())) {
			if (!Messages.PROPERTIES_NEW_RESOURCE.equals((String)value)) {
				EntityWrapper entityWrapper = taggedResourceWrapper.getEntityWrapper();
				entityWrapper.getTaggedResources().remove(taggedResourceWrapper);
				
				IResourceServices resourceServices = (IResourceServices)Container.get(IResourceServices.class);
				ITaggedResource taggedResource = resourceServices.addTaggedResource((String)value, entityWrapper.getWrappedEntity(), null);
				TaggedResourceWrapper newTaggedResourceWrapper = new TaggedResourceWrapper(taggedResource, entityWrapper);
				
				entityWrapper.getTaggedResources().add(newTaggedResourceWrapper);
				entityWrapper.getTaggedResources().add(taggedResourceWrapper);
				//entityWrapper.helperProperty();
			}
		} else {
			//taggedResourceWrapper.setTag();
		}
		viewer.refresh();
	}

}

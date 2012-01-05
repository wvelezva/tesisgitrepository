package edu.eafit.maestria.activa.ui.player;

import org.eclipse.jface.viewers.TableViewer;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.IProperty;
import edu.eafit.maestria.activa.services.IPropertyServices;
import edu.eafit.maestria.activa.ui.model.EntityWrapper;
import edu.eafit.maestria.activa.ui.model.PropertyWrapper;
import edu.eafit.maestria.activa.ui.utils.Messages;

public class PropertyKeyEditingSupport extends EntityEditingSupport {

	public PropertyKeyEditingSupport(TableViewer viewer) {
		super(viewer);
	}

	@Override
	protected Object getValue(Object element) {
		return ((PropertyWrapper) element).getKey();
	}

	@Override
	protected void setValue(Object element, Object value) {
		PropertyWrapper propertyWrapper = (PropertyWrapper) element;
		if (Messages.PROPERTIES_NEW_PROPERTY.equals(propertyWrapper.getKey())) {
			if (!Messages.PROPERTIES_NEW_PROPERTY.equals((String)value)) {
				EntityWrapper entityWrapper = propertyWrapper.getEntityWrapper();
				entityWrapper.getProperties().remove(propertyWrapper);
				
				IPropertyServices propertyServices = (IPropertyServices)Container.getInstance().getComponent(IPropertyServices.class);
				IProperty property = propertyServices.addProperty((String)value, entityWrapper.getWrappedEntity());
				PropertyWrapper newPropertyWrapper = new PropertyWrapper(property, entityWrapper);
				
				entityWrapper.getProperties().add(newPropertyWrapper);
				entityWrapper.getProperties().add(propertyWrapper);
				//entityWrapper.helperProperty();
			}
		} else {
			propertyWrapper.setKey((String)value);
		}
		viewer.refresh();
	}

}

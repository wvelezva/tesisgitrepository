package edu.eafit.maestria.activa.ui.player;

import org.eclipse.jface.viewers.TableViewer;

import edu.eafit.maestria.activa.ui.model.PropertyWrapper;

public class PropertyValueEditingSupport extends EntityEditingSupport {

	public PropertyValueEditingSupport(TableViewer viewer) {
		super(viewer);
	}

	@Override
	protected Object getValue(Object element) {
		return ((PropertyWrapper) element).getValue();
	}

	@Override
	protected void setValue(Object element, Object value) {
		((PropertyWrapper) element).setValue((String)value);
		viewer.refresh();
	}

}

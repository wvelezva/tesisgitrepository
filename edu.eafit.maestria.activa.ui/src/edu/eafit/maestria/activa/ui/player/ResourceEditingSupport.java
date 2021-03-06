package edu.eafit.maestria.activa.ui.player;

import java.io.File;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.services.IResourceServices;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.model.TaggedResourceWrapper;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class ResourceEditingSupport extends EditingSupport {

	private static final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName());
	
	protected final TableViewer viewer;
	
	public ResourceEditingSupport(TableViewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		ResourceCellEditor resourceCellEditor = new ResourceCellEditor(viewer.getTable());
		return resourceCellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		IResource resource = ((TaggedResourceWrapper) element).getResource();
		if (resource != null)
			return resource.getName();
		return "";
	}

	@Override
	protected void setValue(Object element, Object value) {
		TaggedResourceWrapper taggedResourceWrapper = (TaggedResourceWrapper) element;
		
		IResourceServices resourceServices = (IResourceServices)Container.get(IResourceServices.class);
		File file = new File((String) value);
		try {
			IResource resource = resourceServices.createResource(file);
			taggedResourceWrapper.setResource(resource);
		} catch (Exception e) {
			logger.error(e, Messages.PROPERTIES_COPYING_IMG_ERROR);
		}
		
		viewer.refresh();
	}

}

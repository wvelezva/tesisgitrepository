package edu.eafit.maestria.activa.ui.model;

import java.util.List;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.IType;
import edu.eafit.maestria.activa.services.ITypeServices;

public enum ModelProvider {
	INSTANCE;

	private List<IType> types;

	private ModelProvider() {
		ITypeServices typeServices = Container.getInstance().getComponent(ITypeServices.class);
		types = typeServices.getTypes();
	}

	public List<IType> getTypes() {
		return types;
	}

}
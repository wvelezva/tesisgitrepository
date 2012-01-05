package edu.eafit.maestria.activa.ui.model;

import edu.eafit.maestria.activa.model.IProperty;
import edu.eafit.maestria.activa.ui.utils.Messages;

public class PropertyHelper implements IProperty {
	@Override
	public void setValue(String value) {}

	@Override
	public void setKey(String key) {}

	@Override
	public String getValue() {
		return "";
	}

	@Override
	public String getKey() {
		return Messages.PROPERTIES_NEW_PROPERTY;
	}
}

package edu.eafit.maestria.activa.hibernate;
/**
 * 
 */

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * Adds cdate and mdate to all persited objects
 * 
 * @author juan.maya
 */
public class TimestampInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = -6527686121383178065L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.EmptyInterceptor#onSave(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		boolean modified = false;
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		Object cdate = null;
		try {
			BeanUtils.getProperty(entity, "cdate");
		} catch (Exception e) {
		}

		if (cdate == null)
			modified = modifyProperty("cdate", currentDate, state, propertyNames);

		modified = modifyProperty("mdate", currentDate, state, propertyNames) || modified;
		return modified;
	}
	
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames,Type[] types) {
		return modifyProperty("mdate", new Timestamp(System.currentTimeMillis()), currentState, propertyNames);
	}

	/**
	 * Modify a property in an entity state array.
	 * 
	 * @param prop
	 *            the property name to modify
	 * @param value
	 *            the value to assign
	 * @param state
	 *            the current entity state array
	 * @param propertyNames
	 *            the current entity property array
	 * @return <code>true</code> if a modification was made, <code>false</code> if not
	 */
	protected boolean modifyProperty(String prop, Object value, Object[] state, String[] propertyNames) {
		boolean modified = false;
		for (int i = 0; i < propertyNames.length; i++) {
			if (propertyNames[i].equals(prop)) {
				if (state[i] != value) {
					state[i] = value;
					modified = true;
				}
			}
		}
		return modified;
	}

}

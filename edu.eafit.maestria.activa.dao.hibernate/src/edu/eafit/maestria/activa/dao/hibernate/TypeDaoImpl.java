package edu.eafit.maestria.activa.dao.hibernate;

import org.hibernate.Session;

import edu.eafit.maestria.activa.dao.ITypeDao;
import edu.eafit.maestria.activa.dao.hibernate.utils.BaseDaoHibernate;
import edu.eafit.maestria.activa.model.IType;
import edu.eafit.maestria.activa.model.Type;

public class TypeDaoImpl extends BaseDaoHibernate<IType> implements ITypeDao {

	public TypeDaoImpl(Session session) {
		super(session, Type.class);
	}
}

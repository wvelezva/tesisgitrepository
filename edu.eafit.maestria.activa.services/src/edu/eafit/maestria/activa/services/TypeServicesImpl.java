package edu.eafit.maestria.activa.services;

import java.util.List;

import edu.eafit.maestria.activa.dao.ITypeDao;
import edu.eafit.maestria.activa.model.IType;

public class TypeServicesImpl implements ITypeServices {

	private ITypeDao typeDao;
	
	public TypeServicesImpl(ITypeDao typeDao){
		this.typeDao = typeDao;
	}
	
	@Override
	public List<IType> getTypes() {
		return typeDao.getObjects();
	}

}

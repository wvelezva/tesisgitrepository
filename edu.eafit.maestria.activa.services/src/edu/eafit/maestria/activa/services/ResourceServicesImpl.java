package edu.eafit.maestria.activa.services;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import edu.eafit.maestria.activa.dao.IResourceDao;
import edu.eafit.maestria.activa.dao.ITaggedResourceDao;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.ITaggedResource;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class ResourceServicesImpl implements IResourceServices{

	private final LogUtil logger = LogUtil.getInstance(ServicesActivator.getDefault().getBundle().getSymbolicName(), ResourceServicesImpl.class);
	
	private IResourceDao resourceDao;
	private ITaggedResourceDao taggedResourceDao;
	
	public ResourceServicesImpl(IResourceDao resourceDao, ITaggedResourceDao taggedResourceDao){
		this.resourceDao = resourceDao;
		this.taggedResourceDao = taggedResourceDao;
	}
	
	@Override
	public void deleteTaggedResource(ITaggedResource taggedResource) {
		taggedResourceDao.delete(taggedResource);
		//TODO verificar que si el resource esta asociado alguna otra entidad en caso de que no borrarlo
		//tambien podria funcionar lo de orphan
		
	}
	
	@Override
	public ITaggedResource addTaggedResource(String tag, IEntity entity, IResource resource) {
		return taggedResourceDao.addTaggedResource(tag, entity, resource);
	}

	@Override
	public IResource createResource(File srcFile) {
		IResource resource = resourceDao.createResource(srcFile);
		File dstFile =  resource.getFile();
		try {
			FileUtils.copyFile(srcFile, dstFile);
		} catch (IOException e) {
			logger.logError("Can't copy the file", e);
			return null;
		}
		return resource;
	}
}

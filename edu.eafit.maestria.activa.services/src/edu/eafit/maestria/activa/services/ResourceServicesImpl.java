package edu.eafit.maestria.activa.services;
import java.io.File;

import org.apache.commons.io.FileUtils;

import edu.eafit.maestria.activa.dao.IResourceDao;
import edu.eafit.maestria.activa.dao.ITaggedResourceDao;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.ITaggedResource;

public class ResourceServicesImpl implements IResourceServices{

	private IResourceDao resourceDao;
	private ITaggedResourceDao taggedResourceDao;
	
	public ResourceServicesImpl(IResourceDao resourceDao, ITaggedResourceDao taggedResourceDao){
		this.resourceDao = resourceDao;
		this.taggedResourceDao = taggedResourceDao;
	}
	
	@Override
	public void deleteTaggedResource(ITaggedResource taggedResource) {
		taggedResourceDao.delete(taggedResource);
	}
	
	@Override
	public ITaggedResource addTaggedResource(String tag, IEntity entity, IResource resource) {
		return taggedResourceDao.addTaggedResource(tag, entity, resource);
	}

	@Override
	public IResource createResource(File srcFile) throws Exception{
		IResource resource = resourceDao.createResource(srcFile);
		File dstFile =  resource.getFile();
		FileUtils.copyFile(srcFile, dstFile);
		
		return resource;
	}
}

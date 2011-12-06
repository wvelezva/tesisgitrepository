package edu.eafit.maestria.activa.services;
import java.io.File;

import org.apache.commons.lang.StringUtils;

import edu.eafit.maestria.activa.hibernate.HibernateUtil;

public class ResourceServiceImpl implements IResourceService{

	private File baseDir;
	private String baseDirLocation;
	
	/**
	 * Returns a file path for the hashed location of a given docid. The hash is
	 * built in 2 levels, where each level 2 contains up to 500 entries
	 * 
	 * @throws IllegalStateException if the id is not greater than zero
	 */
	@Override
	public String getHashedPath(long id)
	{
		if (id < 0)
			throw new IllegalStateException("Unable to process document hashed path for an invalid id (id=" + id + ")");

		long level1 = id / 250000;
		long level2 = (id % 250000) / 500;

		StringBuilder pathbuf = new StringBuilder();
		pathbuf.append(File.separator);
		pathbuf.append(Long.toString(level1));
		pathbuf.append(File.separator);
		pathbuf.append(Long.toString(level2));

		return pathbuf.toString();
	}
	
	/**
	 * @return
	 */
	@Override
	public File getBaseDir()
	{
		if(baseDir != null)
			return baseDir;
			
		if(StringUtils.isBlank(baseDirLocation))
		{
			baseDir = new File(ActivaConfig.config.getString(ActivaConfig.DOCUMENTS_BASEDIR));
			return baseDir;
		}
		
		String baseDirValue = ActivaConfig.config.getString(baseDirLocation);
		if(StringUtils.isBlank(baseDirValue))
		{
			baseDir = new File(ActivaConfig.config.getString(ActivaConfig.DOCUMENTS_BASEDIR));
			return baseDir;
		}
			
		baseDir = new File(baseDirValue);
		return baseDir;
	}
	
	static {
		try {
			Class.forName("edu.eafit.maestria.activa.hibernate.HibernateUtil");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

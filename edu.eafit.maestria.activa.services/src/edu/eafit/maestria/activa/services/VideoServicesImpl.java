package edu.eafit.maestria.activa.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import edu.eafit.maestria.activa.model.ModelActivator;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class VideoServicesImpl implements IVideoServices{
	
	private static final LogUtil logger = LogUtil.getInstance(ModelActivator.getDefault().getBundle().getSymbolicName());
	
	private static VideoServicesImpl videoServicesImpl;
	private XStream xs;
	
	private VideoServicesImpl(){
		xs = new XStream();
		xs.processAnnotations(Video.class);
	}
	
	public static IVideoServices getInstance(){
		if (videoServicesImpl == null)
			videoServicesImpl = new VideoServicesImpl();
		return videoServicesImpl;
	}

	@Override
	public Video loadVideo(String name) {
		return null;
	}

	@Override
	public boolean saveVideo(Video video) {
		FileOutputStream fs = null;
		try {
			if (video.isModified()) {
	        	fs = new FileOutputStream(video.getSource());
		        xs.toXML(video, fs);
		        video.resetModified();
			}
        } catch (FileNotFoundException e) {
            logger.error(e);
            return false;
        } finally {
        	if (fs != null)
				try {
					fs.close();
				} catch (IOException e) {
					logger.warning(e);
				}
        }
        
        return true;
	}
}

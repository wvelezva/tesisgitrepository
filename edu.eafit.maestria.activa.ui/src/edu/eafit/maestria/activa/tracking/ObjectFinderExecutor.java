package edu.eafit.maestria.activa.tracking;

import static com.googlecode.javacv.cpp.opencv_core.CV_RGB;
import static com.googlecode.javacv.cpp.opencv_core.cvCircle;
import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_core.cvLine;
import static com.googlecode.javacv.cpp.opencv_core.cvPoint;
import static com.googlecode.javacv.cpp.opencv_core.cvRect;
import static com.googlecode.javacv.cpp.opencv_core.cvRectangle;
import static com.googlecode.javacv.cpp.opencv_core.cvResetImageROI;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.javacv.ObjectFinder;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class ObjectFinderExecutor {
	
	private static final String RECTANGLE = "rect";
	private static final String ROI = "roi";
	private static final String SCALED_TEMPLATE = "scaledTemplate";
	private static final String SCALED_FRAME = "scaledFrame";
	private static final String FRAME = "frame";
	private static final String TEMPLATE = "template";
	private static final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName());

	/* 
	 * tracks a shape specified by the coord in the params beggining in currentTime
	 * and saves the initial shape in fileName
	 * The results is the list of consecutive points, once the track algorithm doesn't
	 * find anything the tracking stops and returns.
	 * The espected content of the params is a rectangle
	 * params[0] = x
	 * params[1] = y
	 * params[2] = width
	 * params[3] = height
	 * 
	 * The Tracker must be initialized.
	 * 
	 */
	public List<Point> track(Tracker tracker, long currentTime, int[] params, BufferedImage template, boolean saveImages){
		
		java.util.logging.Logger.getLogger("com.googlecode.javacv").setLevel(java.util.logging.Level.OFF);
		
		int numfile = 1;
		if (!tracker.setInitTime(currentTime)) 
			return null;
		
		//setting the template image from image given
		IplImage templateimg = IplImage.createFrom(template);
		if(templateimg == null) {
			logger.error(Messages.OPENCV_TEMPLATE_ERROR);
			return null;
		}
		if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, TEMPLATE), templateimg);
		//getting the base frame
		
		IplImage frame = tracker.fg.getFrame(); 
		if (frame == null) {
			logger.error(Messages.OPENCV_FRAME_ERROR);
			return null;
		}
		
		if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, FRAME), frame);

		// take the next frame where the comparison begins
		// and scale the grayscale (to speed up detection)
		IplImage scaledFrame = tracker.grab();
		if(scaledFrame == null)
			return null;
		if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, SCALED_FRAME), scaledFrame);
		
		IplImage scaledTemplate = Tracker.getScaledVersion(Tracker.getGrayVersion(templateimg));
		if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, SCALED_TEMPLATE), scaledTemplate);
		//setting working area
		int[] roiData = Tracker.populateRoiInit(cvRect(params[0], params[1], params[2], params[3]), scaledFrame);
		CvRect roiRect = Tracker.setWorkingArea(scaledFrame, roiData);
		if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, ROI), scaledFrame);
		
		List<Point> results = new ArrayList<Point>();
		int rep=1;
		double[] h = null;
		boolean firstMatch = false;
		do {
			long startTime = System.currentTimeMillis();
			
			ObjectFinder objFinder = null;				
			try {
				
				ObjectFinder.Settings settings = new ObjectFinder.Settings();
				settings.setObjectImage(scaledTemplate);
				settings.setDistanceThreshold(0.6f);
				settings.setHessianThreshold(300);
				settings.setMatchesMin(4);
				settings.setRansacReprojThreshold(6);
				objFinder = new ObjectFinder(settings);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (objFinder == null)
				break;
			
			h = objFinder.find(scaledFrame); 
			
			long xmincorner = (roiData[0])*Tracker.scale;
			long ymincorner = (roiData[1])*Tracker.scale;
			long xmaxcorner = (roiData[0])*Tracker.scale;
			long ymaxcorner = (roiData[1])*Tracker.scale;
			cvResetImageROI(scaledFrame);
			int newX = 0;
			int newWidth = 0;
			int newY = 0;
			int newHeight = 0;
			if (h!= null) {
				
				for (int i = 0; i < h.length;i++){
					if (h[i] < 0)
						h[i]=0;
				}
				
				//comparing the Xs
				int xminpos = 0;
				int xmaxpos = 0;
				for (int i = 0; i < h.length-2;i+=2){
					xminpos = (h[xminpos] < h[i+2]) ? xminpos : i+2;
					xmaxpos = (h[xmaxpos] > h[i+2]) ? xmaxpos : i+2;
				}

				xmincorner = (roiData[0] + (long)Math.ceil(h[xminpos]))*Tracker.scale;
				xmaxcorner = (roiData[0] + (long)Math.floor(h[xmaxpos]))*Tracker.scale;

				//comparing the Ys
				int yminpos = 1;
				int ymaxpos = 1;
				for (int i = 1; i < h.length-2;i+=2){
					yminpos = (h[yminpos] < h[i+2]) ? yminpos : i+2;
					ymaxpos = (h[ymaxpos] > h[i+2]) ? ymaxpos : i+2;
				}
				
				ymincorner = (roiData[1] + (long)Math.ceil(h[yminpos]))*Tracker.scale;
				ymaxcorner = (roiData[1] + (long)Math.floor(h[ymaxpos]))*Tracker.scale;
				
				if (saveImages) {
					IplImage tmp = cvCreateImage(cvGetSize(frame),frame.depth(),frame.nChannels());
					cvCopy(frame, tmp);
					
					CvPoint p1 = null;
					CvPoint p0 = null;
					CvPoint pinit = null;
					
					for (int i = 0; i < h.length;i+=2){
						long x = (roiData[0] + Math.round(h[i]))*Tracker.scale;
						long y = (roiData[1] + Math.round(h[i+1]))*Tracker.scale;
						p1=p0;
						p0 = cvPoint(Long.valueOf(x).intValue(), Long.valueOf(y).intValue());
						cvCircle(tmp, p0, 2, CV_RGB(0, 100, 0), 2, 8, 0);
						if (p1 != null)
							cvLine(tmp, p0, p1, CV_RGB(255, 0, 0), 2, 8, 0);
						
						if (pinit == null)
							pinit=p0;
					}
					
					cvLine(tmp, p0, pinit, CV_RGB(255, 0, 0), 2, 8, 0);
					
					cvRectangle(tmp,
							 new CvPoint(Long.valueOf(xmincorner).intValue(), Long.valueOf(ymincorner).intValue()),
							 new CvPoint(Long.valueOf(xmaxcorner).intValue(), Long.valueOf(ymaxcorner).intValue()),
							 CvScalar.YELLOW, 1, 0, 0 );
					
					cvSaveImage(getFileName(currentTime, numfile++, RECTANGLE), tmp);
				}
				
				newX = Long.valueOf(xmincorner).intValue();
				newWidth = Long.valueOf(xmaxcorner).intValue() - newX;
				newY = Long.valueOf(ymincorner).intValue();
				newHeight = Long.valueOf(ymaxcorner).intValue() - newY;
				if (firstMatch && (xmaxcorner - xmincorner < newWidth/2 || ymaxcorner - ymincorner < newHeight/2)) {
					break;
				} else if (xmaxcorner - xmincorner > newWidth/2 && ymaxcorner - ymincorner > newHeight/2) {
					firstMatch = true;
					results.add(new Point(newX, newY));
					scaledTemplate = Tracker.getTrackingImg(scaledFrame, newX, newY, newWidth, newHeight, saveImages, getFileName(currentTime, numfile++, TEMPLATE));
				}
			}
			
			scaledFrame = tracker.grab();
			
			if(scaledFrame == null)
				break;
			
			if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, SCALED_FRAME), scaledFrame);
			
			if (firstMatch) {
				//modifying the pivod point, the base point where to set the working area
				roiRect.x(newX);
				roiRect.y(newY);
				roiRect.width(newWidth);
				roiRect.height(newHeight);
				
				roiData = Tracker.populateRoiInit(roiRect, scaledFrame);
			}
			
			roiRect = Tracker.setWorkingArea(scaledFrame, roiData);
			if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, ROI), scaledFrame);
			
			logger.info("Processing time: [%d]: %d", rep, System.currentTimeMillis() - startTime);
			System.out.println(String.format("Processing time: [%d]: %d", rep++, System.currentTimeMillis() - startTime));
			
			//while no matches and not the firstMatch jet, or there is matches or there isn't found
			//the first match and the process repeats 50 times already
		} while (((h==null || h.length==0) && !firstMatch && rep <50) || h!=null );
		
		if (results.size() > 0)
			results.remove(0);

//		There are two way of release the img, using the instance method release()		
//		templateimg.release();
//		or using the cvReleaseImage(img) method

		return results;
	}

	private String getFileName(long currentTime, int i, String postfix) {
		return Container.getProject().getVideo().getSnapshotDirectory().getAbsolutePath() + File.separator + currentTime + "-" + i + "-" + postfix + Constants.File.SNAPSHOT_FILE_EXTENSION;
	}

}
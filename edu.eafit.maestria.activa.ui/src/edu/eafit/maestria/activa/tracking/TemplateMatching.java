package edu.eafit.maestria.activa.tracking;

import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_32F;
import static com.googlecode.javacv.cpp.opencv_core.cvAddWeighted;
import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGet2D;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_core.cvRect;
import static com.googlecode.javacv.cpp.opencv_core.cvRectangle;
import static com.googlecode.javacv.cpp.opencv_core.cvResetImageROI;
import static com.googlecode.javacv.cpp.opencv_core.cvSize;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_TM_SQDIFF_NORMED;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvMatchTemplate;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class TemplateMatching {
	
	private final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), TemplateMatching.class);
	private static final double THRESHOLD_VAL = 0.07;

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
		int numfile = 1;
		if (!tracker.setInitTime(currentTime)) 
			return null;
		
		//setting the template image from image given
		IplImage templateimg = IplImage.createFrom(template);
		if(templateimg == null) {
			logger.logError("Something wrong happend with the template");
			return null;
		}
		if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, "template"), templateimg);
		//getting the base frame
		
		IplImage frame = tracker.fg.getFrame(); 
		if (frame == null) {
			logger.logError("Something wrong happend with the frame :(");
			return null;
		}
		
		//temp
		if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, "frame"), frame);

		
		// take the next frame where the comparison begins
		// and scale the grayscale (to speed up detection)
		IplImage scaledFrame = tracker.grab();
		if(scaledFrame == null)
			return null;
		if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, "scaledFrame"), scaledFrame);
		
		IplImage scaledTemplate = Tracker.getScaledVersion(Tracker.getGrayVersion(templateimg));
		if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, "scaledTemplate"), scaledTemplate);
		//setting working area
		int[] roiData = Tracker.populateRoiInit(cvRect(params[0], params[1], params[2], params[3]), scaledFrame);
		CvRect roiRect = Tracker.setWorkingArea(scaledFrame, roiData);
		if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, "roi"), scaledFrame);
		IplImage result = cvCreateImage(cvSize(cvGetSize(scaledFrame).width() - cvGetSize(scaledTemplate).width() + 1, cvGetSize(scaledFrame).height() - cvGetSize(scaledTemplate).height() + 1), IPL_DEPTH_32F, 1);
		
		int matches = 0;
		List<Point> results = new ArrayList<Point>();
		int rep=1;
		boolean firstMatch = false;
		
		do {
			matches = 0;
			
			cvMatchTemplate(scaledFrame,scaledTemplate,result,CV_TM_SQDIFF_NORMED);
			int yPart = 0;
			int xPart = 0;
			cvResetImageROI(scaledFrame);
			IplImage tmp = cvCreateImage(cvGetSize(scaledFrame),scaledFrame.depth(),scaledFrame.nChannels());
			cvCopy(scaledFrame, tmp);
			for(int y = 0 ; y < result.height(); y++ ) {
				for(int x = 0 ; x < result.width() ; x++ ) {
			
					CvScalar s = cvGet2D(result, y, x);
			 		if (s.val(0) <= THRESHOLD_VAL) {
			 			matches++;
			 			yPart += y; 
			 			xPart += x; 
			 			cvRectangle(tmp,
								 new CvPoint( roiData[0]+x, roiData[1]+y ),
								 new CvPoint( roiData[0]+x+scaledTemplate.width(), roiData[1]+y+scaledTemplate.height()),
								 CvScalar.RED, 1, 0, 0 );
			 		}
				}
			}
			int newX = 0;
			int newY = 0;
			if (matches == 0 && firstMatch)
				break;
			else if (matches != 0 && !firstMatch) {
				firstMatch = true;
			} 
			
			if (matches != 0) {
				
				if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, "rect"), tmp);
				
				int yMean = Double.valueOf(Math.ceil(yPart/matches)).intValue();
				int xMean = Double.valueOf(Math.ceil(xPart/matches)).intValue();
				newX = (roiData[0] + xMean)*Tracker.scale;
				newY = (roiData[1] + yMean)*Tracker.scale;
				results.add(new Point(newX, newY));
				
				IplImage scaledTemplateFuture = Tracker.getTrackingImg(scaledFrame, newX, newY, scaledTemplate.width(), scaledTemplate.height(), saveImages, getFileName(currentTime, numfile++, "template"));
				cvAddWeighted(scaledTemplate, 0.6f, scaledTemplateFuture, 0.4f, 0, scaledTemplate);
				if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, "blended"), scaledTemplate);
			}
			scaledFrame = tracker.grab();
			
			if(scaledFrame == null)
				break;
			
			if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, "scaledFrame"), scaledFrame);
			
			if (matches != 0) {
				//modifying the pivod point, the base point where to set the working area
				roiRect.x(newX);
				roiRect.y(newY);
				roiData = Tracker.populateRoiData(roiRect, scaledFrame);
			}
			
			roiRect = Tracker.setWorkingArea(scaledFrame, roiData);
			if (saveImages) cvSaveImage(getFileName(currentTime, numfile++, "roi"), scaledFrame);
			//logger.logInfo("Processing time: [" + rep++ + "]: " + (System.currentTimeMillis() - startTime));
			
			
			//while no matches and not the firstMatch jet, or there is matches or there isn't found
			//the first match and the process repeats 50 times already
		} while ((matches ==0 && !firstMatch && rep < 50) || matches != 0);
		
		if (results.size() > 0)
			results.remove(0);
		
//		cvReleaseImage(frame);
//		templateimg.release();
//		cvReleaseImage(scaledFrame);
//		cvReleaseImage(scaledTemplate);
//		cvReleaseImage(result);
//		
		return results;
	}

	private String getFileName(long currentTime, int i, String postfix) {
		return Container.getProject().getVideo().getSnapshotDirectory().getAbsolutePath() + File.separator + currentTime + "-" + i + "-" + postfix + Constants.Template.TEMPLATE_FILE_EXTENSION;
	}

}

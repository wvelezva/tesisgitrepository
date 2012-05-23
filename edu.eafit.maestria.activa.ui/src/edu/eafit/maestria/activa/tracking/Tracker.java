package edu.eafit.maestria.activa.tracking;

import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_core.cvRect;
import static com.googlecode.javacv.cpp.opencv_core.cvResetImageROI;
import static com.googlecode.javacv.cpp.opencv_core.cvSetImageROI;
import static com.googlecode.javacv.cpp.opencv_core.CvSize;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_GAUSSIAN;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_INTER_LINEAR;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvResize;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvSmooth;

import java.io.File;

import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class Tracker {
	
	private static final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName());
	
	private static final int ROI_SPACE = 15;
	protected static final int SCALE_DEFAULT = 1;
	protected static int scale = SCALE_DEFAULT;
	protected ActivaFrameGrabber fg = null; 
	
	public Tracker(File video){
		fg = new ActivaFrameGrabber(video);
		
		try {
			fg.start();
		} catch (Exception e) {
			logger.error(e);
		} 
	}
	
	public void release(){
		if (fg != null) {
			try {
				fg.release();
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}

	public boolean setInitTime(long currentTime) {
		return fg.setInitTime(currentTime); 
	}
	
	public static IplImage getTrackingImg(IplImage frame, int x, int y, int width, int height, boolean save, String fileName){
		CvSize size = cvGetSize(frame);
		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		
		if (x + width > size.width())
			x = size.width() - width;
		
		if (y + height > size.height())
			y= size.height() - height;
		
		CvRect roiRect = cvRect(x, y, width, height);
		cvSetImageROI(frame, roiRect);
		IplImage templateimg = cvCreateImage(cvGetSize(frame),frame.depth(),frame.nChannels());

		/* copy subimage */
		cvCopy(frame, templateimg);
		if (save)
			cvSaveImage(fileName, templateimg);
		
		cvResetImageROI(frame);
		return templateimg;
	}
	
	public static IplImage getScaledVersion(IplImage img) {
		IplImage scaled = IplImage.create(img.width()/scale, img.height()/scale, IPL_DEPTH_8U, 1);
	    cvResize(img, scaled, CV_INTER_LINEAR);
	    return scaled;
	}

	public static IplImage getGrayVersion(IplImage img) {
		IplImage grayImg = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, 1);
		cvCvtColor(img, grayImg, CV_BGR2GRAY);
		return grayImg;
	}
	
	public static int[] populateRoiInit(CvRect rect, IplImage scaledFrame) {
		int roiWidth = (rect.width() + ROI_SPACE*2)/scale > scaledFrame.width() ? scaledFrame.width() : (rect.width() + ROI_SPACE*2)/scale;
		int roiHeight = (rect.height() + ROI_SPACE*2)/scale > scaledFrame.height() ? scaledFrame.height() : (rect.height() + ROI_SPACE*2)/scale;
		
		return populateRoiData(rect, scaledFrame, roiWidth, roiHeight);
	}

	public static int[] populateRoiData(CvRect rect, IplImage scaledFrame) {
		int roiWidth = rect.width();
		int roiHeight = rect.height();
		
		return populateRoiData(rect, scaledFrame, roiWidth, roiHeight);
	}
	
	private static int[] populateRoiData(CvRect rect, IplImage scaledFrame,	int roiWidth, int roiHeight) {
		int roiX = rect.x() - ROI_SPACE < 0 ? 0 : (rect.x() - ROI_SPACE)/scale;
		if (roiX + roiWidth > scaledFrame.width())
			roiX -= roiX +roiWidth - scaledFrame.width();
		
		int roiY = rect.y() - ROI_SPACE < 0 ? 0 : (rect.y() - ROI_SPACE)/scale;
		if (roiY + roiHeight > scaledFrame.height())
			roiY -= roiY +roiHeight - scaledFrame.height();
		
		int[] roiData = new int[4];
		roiData[0] = roiX;
		roiData[1] = roiY;
		roiData[2] = roiWidth;
		roiData[3] = roiHeight;
		return roiData;
	}
	
	//Set the roi in the frame to look for the template matching, reducing the area where to look
	public static CvRect setWorkingArea(IplImage scaledFrame, int[] roiData) {
		CvRect roiRect = cvRect(roiData[0], roiData[1], roiData[2], roiData[3]);
		cvSetImageROI(scaledFrame, roiRect);
		return roiRect;
	}
	
	public IplImage grab(){
		try {
			IplImage img = getScaledVersion(getGrayVersion(fg.grab()));
			cvSmooth(img, img, CV_GAUSSIAN, 3);
			return img;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	
}

package edu.eafit.maestria.activa.tracking;

import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_32F;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGet2D;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_core.cvRect;
import static com.googlecode.javacv.cpp.opencv_core.cvReleaseImage;
import static com.googlecode.javacv.cpp.opencv_core.cvSize;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_TM_SQDIFF_NORMED;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvMatchTemplate;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.utilities.Constants;

public class OpticalFlowTracker {
	
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
	public List<List<Point>> track(long currentTime, Polygon polygon, BufferedImage template, boolean saveImages){
	
//		if (!Tracker.setInitTime(currentTime)) 
//			return null;
		
//		El template en optical flow tracker sirve para encontrar la primera referencia desde la cual aplicar el algoritmo
		//setting the template image from image given
		IplImage templateimg = IplImage.createFrom(template);
		if(templateimg == null) {
			System.err.println("Something wrong happend with the template:(");
			return null;
		}
		
		
		
		return null;
	}

}

package edu.eafit.maestria.activa.tracking;

/*
 * Copyright (C) 2009,2010,2011,2012 Samuel Audet
 *
 * This file is part of JavaCV.
 *
 * JavaCV is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version (subject to the "Classpath" exception
 * as provided in the LICENSE.txt file that accompanied this code).
 *
 * JavaCV is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JavaCV.  If not, see <http://www.gnu.org/licenses/>.
 */

import static com.googlecode.javacv.cpp.opencv_highgui.CV_CAP_PROP_CONVERT_RGB;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_CAP_PROP_FORMAT;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_CAP_PROP_FPS;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_CAP_PROP_FRAME_HEIGHT;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_CAP_PROP_FRAME_WIDTH;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_CAP_PROP_MODE;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_CAP_PROP_POS_MSEC;
import static com.googlecode.javacv.cpp.opencv_highgui.cvCreateCameraCapture;
import static com.googlecode.javacv.cpp.opencv_highgui.cvCreateFileCapture;
import static com.googlecode.javacv.cpp.opencv_highgui.cvGetCaptureProperty;
import static com.googlecode.javacv.cpp.opencv_highgui.cvGrabFrame;
import static com.googlecode.javacv.cpp.opencv_highgui.cvQueryFrame;
import static com.googlecode.javacv.cpp.opencv_highgui.cvReleaseCapture;
import static com.googlecode.javacv.cpp.opencv_highgui.cvRetrieveFrame;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSetCaptureProperty;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_GRAY2BGR;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;

import java.io.File;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;

/**
 *
 * @author Samuel Audet
 */
public class ActivaFrameGrabber extends FrameGrabber {
    public static String[] getDeviceDescriptions() throws Exception {
        tryLoad();
        throw new UnsupportedOperationException("Device enumeration not support by OpenCV.");
    }

    private static Exception loadingException = null;
    public static void tryLoad() throws Exception {
        if (loadingException != null) {
            throw loadingException;
        } else {
            try {
                Loader.load(com.googlecode.javacv.cpp.opencv_highgui.class);
            } catch (Throwable t) {
                if (t instanceof Exception) {
                    throw loadingException = (Exception)t;
                } else {
                    throw loadingException = new Exception(t);
                }
            }
        }
    }

    public ActivaFrameGrabber(File file) {
        this(file.getAbsolutePath());
    }
    
    public ActivaFrameGrabber(String filename) {
        this.filename = filename;
    }
    
    public void release() throws Exception {
        stop();
    }
    @Override protected void finalize() throws Throwable {
        super.finalize();
        release();
    }

    private static final boolean macosx = Loader.getPlatformName().startsWith("macosx");
    private int deviceNumber = 0;
    private String filename = null;
    private CvCapture capture = null;
    private IplImage return_image = null;
    private double prevPos = Double.NaN;
    private boolean timestampBroken = false;

    @Override public double getGamma() {
        // default to a gamma of 2.2 for cheap Webcams, DV cameras, etc.
        if (gamma == 0.0) {
            return 2.2;
        } else {
            return gamma;
        }
    }

    public void start() throws Exception {
        timestampBroken = false;
        if (filename != null && filename.length() > 0) {
            capture = cvCreateFileCapture(filename);
            if (capture == null) {
                throw new Exception("cvCreateFileCapture() Error: Could not create camera capture.");
            }
        } else {
            capture = cvCreateCameraCapture(deviceNumber);
            if (capture == null) {
                throw new Exception("cvCreateCameraCapture() Error: Could not create camera capture.");
            }
        }
        if (imageWidth > 0) {
            if (cvSetCaptureProperty(capture, CV_CAP_PROP_FRAME_WIDTH, imageWidth) == 0) {
                cvSetCaptureProperty(capture, CV_CAP_PROP_MODE, imageWidth); // ??
            }
        }
        if (imageHeight > 0) {
            if (cvSetCaptureProperty(capture, CV_CAP_PROP_FRAME_HEIGHT, imageHeight) == 0) {
                cvSetCaptureProperty(capture, CV_CAP_PROP_MODE, imageHeight); // ??
            }
        }
        if (frameRate > 0) {
            cvSetCaptureProperty(capture, CV_CAP_PROP_FPS, frameRate);
        }
        if (bpp > 0) {
            cvSetCaptureProperty(capture, CV_CAP_PROP_FORMAT, bpp); // ??
        }
        cvSetCaptureProperty(capture, CV_CAP_PROP_CONVERT_RGB, imageMode == ImageMode.COLOR ? 1 : 0);

        if (macosx) {
            // Before cvRetrieveFrame() starts returning something else then null
            // QTKit sometimes requires some "warm-up" time for some reason...
            int count = 0;
            while (count++ < 100 && cvGrabFrame(capture) != 0 && cvRetrieveFrame(capture) == null) {
                Thread.sleep(100);
            }
        }

        if (!triggerMode) {
            trigger();
        }
    }

    public void stop() throws Exception {
        if (capture != null) {
            cvReleaseCapture(capture);
            capture = null;
        }
    }

    public void trigger() throws Exception {
        for (int i = 0; i < triggerFlushSize; i++) {
            cvQueryFrame(capture);
        }
        int err = cvGrabFrame(capture);
        if (err == 0) {
            throw new Exception("cvGrabFrame() Error: Could not grab frame. (Has start() been called?)");
        }
    }

    public IplImage grab() throws Exception {
        IplImage image = cvRetrieveFrame(capture);
        if (image == null) {
            throw new Exception("cvRetrieveFrame() Error: Could not retrieve frame. (Has start() been called?)");
        }
        if (!triggerMode) {
            trigger();
        }

        if (imageMode == ImageMode.GRAY && image.nChannels() > 1) {
            if (return_image == null) {
                return_image = IplImage.create(image.width(), image.height(), image.depth(), 1);
            }
            cvCvtColor(image, return_image, CV_BGR2GRAY);
        } else if (imageMode == ImageMode.COLOR && image.nChannels() == 1) {
            if (return_image == null) {
                return_image = IplImage.create(image.width(), image.height(), image.depth(), 3);
            }
            cvCvtColor(image, return_image, CV_GRAY2BGR);
        } else {
            return_image = image;
        }

        if (!timestampBroken) {
            double pos = cvGetCaptureProperty(capture, CV_CAP_PROP_POS_MSEC);
            return_image.timestamp = Math.round(pos*1000);
            if (prevPos == pos) {
                timestampBroken = true;
            } else {
                prevPos = pos;
            }
        }
        return return_image;
    }
    
    public IplImage getFrame() {
		try {
			return grab();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    public boolean setInitTime(long currentTime) {
    	return setInitTime(currentTime, currentTime);
    }
	public boolean setInitTime(long currentTime, long timeToFix) {
		long fixedTime = timeToFix - 500 < 0 ? 0 : timeToFix - 500;
		if (cvSetCaptureProperty(capture, CV_CAP_PROP_POS_MSEC, fixedTime) == 0)
			return false;
		
		if (fixedTime == 0)
			return true;
		
		getFrame();
		double fps = cvGetCaptureProperty(capture, CV_CAP_PROP_FPS);
		double fxm = 1000/fps;
		double pos = cvGetCaptureProperty(capture, CV_CAP_PROP_POS_MSEC);
		if (pos > (currentTime - 2*fxm))
			return setInitTime(currentTime, fixedTime);
		
		while (pos < (currentTime - 2*fxm)){
			getFrame();
			pos = cvGetCaptureProperty(capture, CV_CAP_PROP_POS_MSEC);
		}
		return true;		
	}
}


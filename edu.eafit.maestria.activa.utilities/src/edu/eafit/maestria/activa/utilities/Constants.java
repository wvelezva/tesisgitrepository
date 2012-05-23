package edu.eafit.maestria.activa.utilities;

public final class Constants {
	
	public final class Config {
		public static final String ACTIVA_LOG_PROPERTY = "activa.log";
	}
	
	public final class File {
		public static final String PROJECT_FILE_EXTENSION = ".activa.xml";		
		public static final String TVANYTIME_FILE_EXTENSION = ".tva.xml";		
		public static final String METADATA_FILE_EXTENSION = ".xml";		
		public static final String VIDEO_FILE_EXTENSION = ".video.xml";
		public static final String SNAPSHOT_DIRECTORY = "snapshots";
		public static final String SNAPSHOT_FILE_NAME_FORMAT = "000000";
		public static final String THUMBNAIL = "-thumb";
		public static final String ENTITY = "-entity";
		public static final String SNAPSHOT_FILE_FORMAT="jpg";
		public static final String SNAPSHOT_FILE_EXTENSION="." + SNAPSHOT_FILE_FORMAT;
	}
	
	public final class Template {
		public static final String TEMPLATE = "-template";
		public static final String TEMPLATE_FILE_NAME_FORMAT = "00000000000";
	}
	
	public final class Preferences {
		public static final String HOME = "activa_projects";
		public static final String WORKSPACE = "workspace";
		public static final String SUPPORTED_FORMATS = "supportedFormats";
		public static final String SCALE = "scale";
		public static final String ROI_SPACE = "roiSpace";
	}

	public final class Player {
		public static final int WIDTH = 720;
		public static final int HEIGHT = 576;
		public static final int THUMBNAIL_WIDTH = 200;
		public static final int MILLIS_IN_SECONDS = 1000;
	}
}

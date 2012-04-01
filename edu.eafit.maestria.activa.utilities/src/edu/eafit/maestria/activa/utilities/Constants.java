package edu.eafit.maestria.activa.utilities;

//FIXME revisar que constantes no se usan en mas de un lugar y entonces si solo son usadas en una parte llevarlas alla donde se usan
public final class Constants {
	
	public final class File {
		public static final String PROJECT_FILE_EXTENSION = ".activa.xml";		
		public static final String TVANYTIME_FILE_EXTENSION = ".tva.xml";		
		public static final String METADATA_FILE_EXTENSION = ".xml";		
		public static final String VIDEO_FILE_EXTENSION = ".video.xml";
		public static final String SNAPSHOT_DIRECTORY = "snapshots";
		public static final String SNAPSHOT_FILE_NAME_FORMAT = "000000";
		public static final String THUMBNAIL = "-thumb";
		public static final String ENTITY = "-entity";
		public static final String SNAPSHOT_FILE_EXTENSION=".png";
	}
	
	public final class Template {
		public static final String TEMPLATE = "-template";
		public static final String TEMPLATE_FILE_NAME_FORMAT = "00000000000";
		public static final String TEMPLATE_FILE_EXTENSION=".jpg";
	}
	
	public final class Preferences {
		public static final String WORKSPACE = "workspace";
		public static final String SUPPORTED_FORMATS = "supportedFormats";
		public static final String SCALE = "scale";
		public static final String ROI_SPACE = "roiSpace";
	}

	public final class Player {
		public static final int WIDTH = 720;
		public static final int HEIGHT = 576;
		public static final int THUMBNAIL_WIDTH = 200;
	}
}

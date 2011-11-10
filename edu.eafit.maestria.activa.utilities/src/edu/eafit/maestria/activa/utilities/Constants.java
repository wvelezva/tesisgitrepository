package edu.eafit.maestria.activa.utilities;

//FIXME revisar que constantes no se usan en mas de un lugar y entonces si solo son usadas en una parte llevarlas alla donde se usan
public final class Constants {
	
	public final class File {
		public static final String PROJECT_FILE_EXTENSION = ".activa";		
		public static final String TVANYTIME_FILE_EXTENSION = ".tva";		
		public static final String METADATA_FILE_EXTENSION = ".xml";		
		public static final String PCF_FILE_EXTENSION = ".pcf";
		public static final String VIDEO_FILE_EXTENSION = ".video";
		public static final String SNAPSHOT_DIRECTORY = "snapshots";
		public static final String SNAPSHOT_FILE_NAME_FORMAT = "000000";
		public static final String THUMBNAIL = "thumb-";
		public static final String SNAPSHOT_FILE_EXTENSION=".png";
	}
	
	public final class Preferences {
		public static final String WORKSPACE = "workspace";
		public static final String SUPPORTED_FORMATS = "supportedFormats";
	}
}

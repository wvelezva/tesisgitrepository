package edu.eafit.maestria.activa.ui.utils;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS{
	
	//the bundle_name is not just an id, is the package where the messages_*.properties is located
	private static final String BUNDLE_NAME = "edu.eafit.maestria.activa.ui.messages";

	//File - New
	public static String COMMAND_FILE_NEW_WIZARD_TITLE;
	public static String COMMAND_FILE_NEW_PAGE_WIZARD_TITLE;
	public static String COMMAND_FILE_NEW_PAGE_WIZARD_DESCRIPTION;
	public static String COMMAND_FILE_NEW_WIZARD_PROJECT_NAME;
	public static String COMMAND_FILE_NEW_WIZARD_PROJECT_NAME_EMPTY;
	public static String COMMAND_FILE_NEW_WIZARD_PROJECT_NAME_INVALID;
	public static String COMMAND_FILE_NEW_WIZARD_SOURCE_VIDEO;
	public static String COMMAND_FILE_NEW_WIZARD_GROUP;
	public static String COMMAND_FILE_NEW_WIZARD_OBJECT_DETECTION;
	public static String COMMAND_FILE_NEW_WIZARD_SCENE_DETECTION;
	public static String COMMAND_FILE_NEW_SOURCE_VIDEO_OPEN_DIALOG;
	public static String COMMAND_FILE_NEW_WIZARD_PROJECT_NULL;
	
	//File - Open
	public static String COMMAND_FILE_OPEN_MSG_DIALOG;
	
	//File - Save
	public static String COMMAND_FILE_SAVE_ERROR;
	public static String COMMAND_FILE_SAVE_PROJECT_TITLE;
	public static String COMMAND_FILE_SAVE_PROJECT_MSG;
	public static String COMMAND_FILE_BUTTON_DONT_SAVE;
	public static String COMMAND_FILE_BUTTON_CANCEL;
	public static String COMMAND_FILE_BUTTON_SAVE;
	
	//Player
	public static String SAVE_SNAPSHOT_ERROR;
	public static String PLAYER_POSITION;
	public static String PLAYER_PREVIOUS_FRAME;
	public static String PLAYER_REWIND;
	public static String PLAYER_STOP;
	public static String PLAYER_PLAY_PAUSE;
	public static String PLAYER_FORWARD;
	public static String PLAYER_NEXT_FRAME;
	public static String PLAYER_MUTE;
	public static String PLAYER_VOLUME;
	public static String PLAYER_MARK_SCENE;
	public static String VLC_VIDEO_SURFACE_ERROR;
	public static String VLC_ATTACH_VIDEO_ERROR;
	public static String VLC_VIDEO_SURFACE_CONTENT_ERROR;
	public static String VLC_SET_OVERLAY_ERROR;
	public static String VLC_ADD_OVERLAY_ERROR;
	public static String VLC_PLAYER_NOT_INITIALIZED_ERROR;
	public static String PLAYER_COPY_SHAPES_TITLE;
	public static String PLAYER_COPY_SHAPES_TEXT;
	public static String PLAYER_SNAPSHOT_ERROR;
	
	//Preferences
	public static String PREFERENCES_GENERAL_DESCRIPTION;
	public static String PREFERENCES_GENERAL_WORKSPACE;
	public static String PREFERENCES_GENERAL_ERROR_WORKSPACE_EMPTY;
	public static String PREFERENCES_GENERAL_ERROR_WORKSPACE_INVALID;
	public static String COMMAND_FILE_NEW_SOURCE_VIDEO_BUTTON;

	//Properties
	public static String PROPERTIES_CHANGE_ENTITY;
	public static String PROPERTIES_NAME;
	public static String PROPERTIES_DESCRIPTION;
	public static String PROPERTIES_TYPE;
	public static String PROPERTIES_PROPERTIES;
	public static String PROPERTIES_NEW_PROPERTY;
	public static String PROPERTIES_DELETE_PROPERTY;
	public static String PROPERTIES_NAME_COLUMN;
	public static String PROPERTIES_VALUE_COLUMN;
	public static String PROPERTIES_RESOURCES;
	public static String PROPERTIES_NEW_RESOURCE;
	public static String PROPERTIES_DELETE_RESOURCE;
	public static String PROPERTIES_COPYING_IMG_ERROR;
	public static String PROPERTIES_SELECT_ENTITY;
	public static String PROPERTIES_SELECT_ENTITY_HELP;
	public static String PROPERTIES_BIND_ERROR;
	
	//tracking
	public static String OPENCV_DEVICE_ENUM_NOT_SUPPORTED;
	public static String OPENCV_CREATE_FILE_CAPTURE_ERROR;
	public static String OPENCV_CVGRABFRAME_ERROR;
	public static String OPENCV_CVRETRIEVEFRAME_ERROR;
	public static String OPENCV_TEMPLATE_ERROR;
	public static String OPENCV_FRAME_ERROR;
	public static String TRACKING_NO_OBJECT_SELECTED;
	public static String TRACKING_NO_MATCHES;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
}

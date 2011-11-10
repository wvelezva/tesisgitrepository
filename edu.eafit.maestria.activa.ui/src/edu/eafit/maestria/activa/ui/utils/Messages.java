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
	
	//File - Open
	public static String COMMAND_FILE_OPEN_MSG_DIALOG;
	
	//File - Save
	public static String COMMAND_FILE_SAVE_ERROR;
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
	
	//Preferences
	public static String PREFERENCES_GENERAL_DESCRIPTION;
	public static String PREFERENCES_GENERAL_WORKSPACE;
	public static String PREFERENCES_GENERAL_ERROR_WORKSPACE_EMPTY;
	public static String PREFERENCES_GENERAL_ERROR_WORKSPACE_INVALID;
	public static String COMMAND_FILE_NEW_SOURCE_VIDEO_BUTTON;












	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
}

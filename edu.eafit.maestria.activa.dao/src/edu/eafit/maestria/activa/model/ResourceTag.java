package edu.eafit.maestria.activa.model;
/**
 * These are all the available tags.  Although the database module supports
 * any string as a tag, please make sure the java code only refers to tags
 * by this enum. 
 */
public enum ResourceTag implements IResourceTag {

	/**
	 * This is a generic tag used in various parts of the system with different
	 * entities.
	 */
	ATTACHMENT("Attachment"),
	/**
	 * This is a generic tag used in various parts of the system with different
	 * entities. 
	 */
	IMAGE("Image"),
	/**
	 * Represents a 120x120 thumbnail image of a full picture.  It is used within
	 * the surplus application.
	 */
	THUMBNAIL120("Thumb120"),
	/**
	 * Represents a 60x60 thumbnail image of a full picture.  It is used within
	 * the surplus application.
	 */
	THUMBNAIL60("Thumb60"),
	/**
	 * This tag is for resources that are completely public and can be viewed by anyone. USE CAREFULLY!!
	 */
	PUBDOC("PubDoc"),
	/**
	 * Represents a resource who hasn't been related to an entity
	 * This has two purposes, first it helps to the upload proccess monitoring, and it relates the resource with the
	 * txnid in order to present them when errors happen.
	 */
	TXN_DOC("TxnDoc"),
	;
	
	private String name;
	
	private ResourceTag(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

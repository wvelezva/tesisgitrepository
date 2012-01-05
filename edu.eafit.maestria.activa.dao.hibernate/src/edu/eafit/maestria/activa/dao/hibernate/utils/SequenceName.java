package edu.eafit.maestria.activa.dao.hibernate.utils;
public final class SequenceName
{

	public static final String ENTITY_ID = "act_entityid_seq";
	public static final String ENTITY_TYPE_ID = "act_entitytypeid_seq";
	public static final String RESOURCE_ID = "act_resourceid_seq";
	public static final String VIDEO_ID = "act_videoid_seq";
	public static final String VIDEO_ENTITY_ID = "act_videoentityid_seq";
	
	public static Sequence getSequence(String seqName) {
		class MySequence implements Sequence {
			private String name;

			private MySequence(String name)
			{
				this.name = name;
			}

			public String getName()
			{
				return this.name;
			}
		}
		return new MySequence(seqName);
	}
}
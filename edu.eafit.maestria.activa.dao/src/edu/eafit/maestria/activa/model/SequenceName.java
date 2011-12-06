package edu.eafit.maestria.activa.model;

public final class SequenceName
{

	public static final String ENTITY_ID = "act_entityid_seq";
	public static final String ENTITY_TYPE_ID = "act_entitytypeid_seq";
	public static final String RESOURCE_ID = "act_resourceid_seq";
	public static final String TAGGED_RESOURCE_ID = "act_taggedresourceid_seq";
	public static final String SHOW_ID = "act_showid_seq";
	public static final String SHOW_ENTITY_ID = "act_showentityid_seq";
	
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
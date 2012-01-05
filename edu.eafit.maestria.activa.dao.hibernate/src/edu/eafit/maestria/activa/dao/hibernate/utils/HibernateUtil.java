package edu.eafit.maestria.activa.dao.hibernate.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	private static TimestampInterceptor ti = new TimestampInterceptor();

	static  {
		if (sessionFactory == null) {
			try {
				// configures settings from hibernate.cfg.xml
				java.net.URL configURL = HibernateUtil.class.getClassLoader().getResource("config/hibernate.cfg.xml");
				//sessionFactory = new Configuration().configure(new File("/Users/wvelezva/Dropbox/workspace/tesisgitrepository/edu.eafit.maestria.activa.dao.hibernate/hibernate.cfg.xml")).buildSessionFactory();
				sessionFactory = new Configuration()
						.configure(configURL)
						.buildSessionFactory();
			} catch (Throwable ex) {
				throw new ExceptionInInitializerError(ex);
			}
			
//			org.hibernate.classic.Session session = sessionFactory.openSession(ti);
//			Transaction tx = session.beginTransaction();
//			IEntity entity = new Entity();
//			entity.setDescription("test");
//			IType type = new EntityType();
//			type.setLabel("tipo 1");
//			session.save(type);
//			entity.setType(type);
//			entity.setName("nombre");
//			Map<String, String> properties = new HashMap<String, String>();
//			properties.put("pref1", "value1");
//			properties.put("pref2", "value2");
//			entity.setProperties(properties);
//			/** Saving POJO */
//			session.save(entity);
//			/** Commiting the changes */
//			tx.commit();
		}
		
	}

	public static Session getSession() {
		return sessionFactory.openSession(ti);
	}
	
	public static void close() {
		sessionFactory.close();
	}
}

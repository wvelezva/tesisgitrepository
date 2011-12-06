package edu.eafit.maestria.activa.hibernate;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.eafit.maestria.activa.model.Entity;
import edu.eafit.maestria.activa.model.EntityType;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IType;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	private static TimestampInterceptor ti = new TimestampInterceptor();

	static  {
		if (sessionFactory == null) {
			try {
				// configures settings from hibernate.cfg.xml
				sessionFactory = new Configuration().configure(new File("/Users/wvelezva/Dropbox/workspace/edu.eafit.maestria.activa.dao/hibernate.cfg.xml")).buildSessionFactory();
			} catch (Throwable ex) {
				throw new ExceptionInInitializerError(ex);
			}
			
			
			org.hibernate.classic.Session session = sessionFactory.openSession(ti);
			Transaction tx = session.beginTransaction();

			IEntity entity = new Entity();
			entity.setDescription("test");
			IType type = new EntityType();
			type.setLabel("tipo 1");
			session.save(type);
			entity.setType(type);
			entity.setName("nombre");
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("pref1", "value1");
			properties.put("pref2", "value2");
			entity.setProperties(properties);
			/** Saving POJO */
			session.save(entity);
			/** Commiting the changes */
			tx.commit();
		}
		
	}

	public static Session getSession() {
		return sessionFactory.openSession(ti);
	}
	
	public static void close() {
		sessionFactory.close();
	}
}

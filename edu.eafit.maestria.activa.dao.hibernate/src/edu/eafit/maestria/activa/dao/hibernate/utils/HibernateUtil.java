package edu.eafit.maestria.activa.dao.hibernate.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final String HIBERNATE_CONFIG = "config/hibernate.cfg.xml";
	private static SessionFactory sessionFactory = null;
	private static TimestampInterceptor ti = new TimestampInterceptor();

	private static void init() throws ExceptionInInitializerError {
		try {
			// configures settings from hibernate.cfg.xml
			java.net.URL configURL = HibernateUtil.class.getClassLoader().getResource(HIBERNATE_CONFIG);
			sessionFactory = new Configuration().configure(configURL).buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		if (sessionFactory==null || sessionFactory.isClosed()){
			init();
		}
		
		return sessionFactory.openSession(ti);
	}
	
	public static void close() {
		sessionFactory.close();
	}
}

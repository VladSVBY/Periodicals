package by.htp.periodicals.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
	
	private HibernateUtil() {
	}
	
	private static final SessionFactory SESSION_FACTORY;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration = configuration.configure("config/hibernate.cfg.xml");
			StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder();
			serviceRegistry = serviceRegistry.applySettings(configuration.getProperties());
			SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry.build());
		} catch (Exception e) {
			// TODO: add log
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}

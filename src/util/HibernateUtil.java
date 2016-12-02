package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			System.out.println("Hibernate Configuration loaded");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			System.out.println("Hibernate serviceRegistry created");

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			return sessionFactory;
		} catch (Exception ex) {
			System.err.println("Exception in buildSessionFactory:" + ex);
			ex.printStackTrace();
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}
}

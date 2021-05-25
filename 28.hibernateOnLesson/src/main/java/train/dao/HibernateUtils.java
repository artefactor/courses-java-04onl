package train.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static final Logger LOGGER = LogManager.getLogger(HibernateUtils.class);
	private SessionFactory sessionFactory;

	private HibernateUtils() {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			LOGGER.debug("init sessionFactory once");
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			//	StandardServiceRegistryBuilder.destroy(registry);
			throw new Error("impossible to continue ", e);
		}
	}


	public static SessionFactory getSessionFactory() {
		return SessionFactoryHolder.instance.sessionFactory;
	}

	private static class SessionFactoryHolder {
		static HibernateUtils instance = new HibernateUtils();
	}
}

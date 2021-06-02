package com.example.servlet.repository.jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	private static final Logger LOGGER = LogManager.getLogger(JPAUtils.class);
	private final EntityManagerFactory entityManagerFactory;

	private JPAUtils() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate");
			LOGGER.debug("init entityManagerFactory once");
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			//	StandardServiceRegistryBuilder.destroy(registry);
			LOGGER.error("exception during init method", e);
			throw new Error("impossible to continue ", e);
		}
	}

	private static class SessionFactoryHolder {
		static JPAUtils instance = new JPAUtils();
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return SessionFactoryHolder.instance.entityManagerFactory;
	}
}

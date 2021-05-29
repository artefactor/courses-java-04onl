package by.train.hibernate;

/**
 * класс, который будет возвращать SessionFactory
 */
public class HibernateUtils {
	private SessionFactory sessionFactory =  new SessionFactory();

	public static SessionFactory getSessionFactory() {
		return SessionFactoryHolder.instance.sessionFactory;
	}

	private static class SessionFactoryHolder {
		static HibernateUtils instance = new HibernateUtils();
	}
}

package by.train;

import by.train.hibernate.HibernateUtils;
import by.train.hibernate.Session;
import by.train.hibernate.SessionFactory;
import by.train.hibernate.Transaction;
import by.train.model.Event;

/**
 * emulate hibernate interactions
 */
public class App {
	public static void main(String[] args) {
		Event event = new Event();
		event.setTitle("new event");

		// save
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
//		currentSession.setHibernateFlushMode(FlushMode.COMMIT);
		currentSession.create(event);
		transaction.commit();
		currentSession.close();

		// get
//		Session currentSession = sessionFactory.getCurrentSession();
		currentSession = sessionFactory.openSession();
		Event event2 = currentSession.get(Event.class, 1L);
		currentSession.close();

		// update

		event2.setTitle("new title");

		currentSession = sessionFactory.getCurrentSession();
		transaction = currentSession.beginTransaction();
		currentSession.update(event2);
		transaction.commit();
		currentSession.close();

		sessionFactory.close();
	}
}

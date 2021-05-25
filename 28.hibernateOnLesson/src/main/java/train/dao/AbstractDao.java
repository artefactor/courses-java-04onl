package train.dao;

import train.model.IEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public abstract class AbstractDao<T extends IEntity> implements IDao<T> {
	public void init() {

	}

	public void destroy() {

	}

	public void create(T event) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
//		currentSession.setHibernateFlushMode(FlushMode.COMMIT);
		currentSession.save(event);
		transaction.commit();
		currentSession.close();
	}

	public T getById(long id) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
//		Session currentSession = sessionFactory.getCurrentSession();
		Session currentSession = sessionFactory.openSession();
		T o = currentSession.get(getEntityClass(), id);
		currentSession.close();
		return o;
	}

	protected abstract Class<T> getEntityClass();

	public void update(T event) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
//		currentSession.setHibernateFlushMode(FlushMode.COMMIT);
		currentSession.update(event);
		transaction.commit();
		currentSession.close();
	}

	public void delete(T event) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
//		currentSession.setHibernateFlushMode(FlushMode.COMMIT);
		currentSession.delete(event);
		transaction.commit();
		currentSession.close();
	}

	public List<T> getAll() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		List list = session.createQuery("from " + getEntityClass().getSimpleName()).list();
		return list;
	}

}

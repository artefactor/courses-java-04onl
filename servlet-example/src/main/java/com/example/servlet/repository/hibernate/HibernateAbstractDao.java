package com.example.servlet.repository.hibernate;

import com.example.servlet.entity.IEntity;
import com.example.servlet.repository.DaoException;
import com.example.servlet.repository.IDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public abstract class HibernateAbstractDao<T extends IEntity> implements IDao<T> {

	public void create(T event) throws DaoException {
		// при такой конструкции закроется сама
		// https://habr.com/ru/post/178405/
		try (Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession()) {
			Transaction transaction = currentSession.beginTransaction();
			//		currentSession.setHibernateFlushMode(FlushMode.COMMIT);
			currentSession.save(event);
			transaction.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public T getById(long id) throws DaoException {
		try (Session currentSession = HibernateUtils.getSessionFactory().openSession()) {
			T o = currentSession.get(getEntityClass(), id);
			return o;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	protected abstract Class<T> getEntityClass();

	public void update(T event) throws DaoException {
		try (Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession()) {
			Transaction transaction = currentSession.beginTransaction();
			currentSession.update(event);
			transaction.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void delete(T event) throws DaoException {
		try (Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession()) {
			Transaction transaction = currentSession.beginTransaction();
			currentSession.delete(event);
			transaction.commit();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public List<T> getAll() throws DaoException {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			List list = session.createQuery("from " + getEntityClass().getSimpleName()).list();
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}

package com.example.servlet.repository.jpa;

import com.example.servlet.entity.IEntity;
import com.example.servlet.repository.DaoException;
import com.example.servlet.repository.IDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static com.example.servlet.repository.jpa.JPAUtils.getEntityManagerFactory;

public abstract class JPAAbstractDao<T extends IEntity> implements IDao<T> {

	protected static final Logger LOGGER = LogManager.getLogger(JPAAbstractDao.class);

	protected EntityManagerWrapper getEntityManagerWrapper() {
		return new EntityManagerWrapper(getEntityManagerFactory().createEntityManager());
	}

	public void create(T entity) throws DaoException {
		// при такой конструкции закроется сама
		// https://habr.com/ru/post/178405/
		try (EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
			EntityManager entityManager = entityManagerWrapper.getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(entity);
			// google: jpa how to get id after persist
//			entityManager.refresh(entity);  // cause exception in this cas
			entityManager.flush();
			transaction.commit();
		} catch (Exception e) {
			LOGGER.error("Unable to create entity: {}", e.getMessage(), e);
			throw new DaoException("Unable to create entity: " + e.getMessage(), e);
		}
	}

	public T getById(long id) throws DaoException {
		try (EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
			EntityManager entityManager = entityManagerWrapper.getEntityManager();
			T o = entityManager.find(getEntityClass(), id);
			return o;
		} catch (Exception e) {
			LOGGER.error("Unable to get entity: {}", e.getMessage(), e);
			throw new DaoException("Unable to get entity: " + e.getMessage(), e);
		}
	}

	protected abstract Class<T> getEntityClass();

	public void update(T entity) throws DaoException {
		try (EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
			EntityManager entityManager = entityManagerWrapper.getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.merge(entity);
			transaction.commit();
		} catch (Exception e) {
			LOGGER.error("Unable to update entity: {}", e.getMessage(), e);
			throw new DaoException("Unable to update entity: " + e.getMessage(), e);
		}
	}

	public void delete(T entity) throws DaoException {
		try (EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
			EntityManager entityManager = entityManagerWrapper.getEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(entity);
			transaction.commit();
		} catch (Exception e) {
			LOGGER.error("Unable to delete entity: {}", e.getMessage(), e);
			throw new DaoException("Unable to delete entity: " + e.getMessage(), e);
		}
	}

	public List<T> getAll() throws DaoException {
		try (EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
			EntityManager entityManager = entityManagerWrapper.getEntityManager();
			CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(getEntityClass());
			List list = entityManager.createQuery(query.select(query.from(getEntityClass()))).getResultList();
			return list;
		} catch (Exception e) {
			LOGGER.error("Unable to getAll: {}", e.getMessage(), e);
			throw new DaoException("Unable to getAll: " + e.getMessage(), e);
		}
	}

}

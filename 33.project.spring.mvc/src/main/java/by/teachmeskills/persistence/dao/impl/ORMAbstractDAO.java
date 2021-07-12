package by.teachmeskills.persistence.dao.impl;

import by.teachmeskills.persistence.dao.AbstractDAO;
import by.teachmeskills.persistence.dao.exception.DAOException;
import by.teachmeskills.persistence.entity.IEntity;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

public abstract class ORMAbstractDAO<E extends IEntity> extends AbstractDAO<E> {

    protected EntityManager entityManager;

    @Override
    @Transactional
    public E create(E entity) throws DAOException {
        try {
            entityManager.persist(entity);
            entityManager.refresh(entity);
            return entity;
        } catch (Exception e) {
            logger.error("Unable to save entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to save entity: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Optional<E> getEntity(Long id) throws DAOException {
        try {
            return Optional.ofNullable(entityManager.find(getEntityClass(), id));
        } catch (Exception e) {
            logger.error("Unable to load entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to load entity: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public List<E> getAll() throws DAOException {
        try {
            CriteriaQuery<E> criteria = entityManager.getCriteriaBuilder().createQuery(getEntityClass());
            return entityManager.createQuery(criteria.select(criteria.from(getEntityClass()))).getResultList();
        } catch (Exception e) {
            logger.error("Unable to load entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to load entities: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public E updateEntity(E entity) throws DAOException {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            logger.error("Unable to update entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to update entity: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void deleteEntity(Long id) throws DAOException {
        try {
            Optional<E> entityOptional = getEntity(id);
            entityOptional.ifPresent(entityManager::remove);
        } catch (Exception e) {
            logger.error("Unable to delete entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to delete entity: " + e.getMessage(), e);
        }
    }

    protected abstract Class<E> getEntityClass();

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

package by.teachmeskills.dao;

import by.teachmeskills.dao.exception.DAOException;
import by.teachmeskills.entity.IEntity;
import java.util.List;
import java.util.Optional;

public interface DAO<E extends IEntity> {

    E create(E entity) throws DAOException;
    Optional<E> getEntity(Long id) throws DAOException;
    List<E> getAll() throws DAOException;
    E updateEntity(E entity) throws DAOException;
    void deleteEntity(Long id) throws DAOException;

}

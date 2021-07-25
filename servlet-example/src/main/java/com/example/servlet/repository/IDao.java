package com.example.servlet.repository;


import com.example.servlet.entity.IEntity;

import java.util.List;

/**
 * все методы могут бросить эксепшен
 * создаем свой класс эксепшенов по аналогии с IO эксепшен
 */
public interface IDao<T extends IEntity> {

	void create(T entity) throws DaoException;

	T getById(long id) throws DaoException;

	void update(T entity) throws DaoException;

	void delete(T entity) throws DaoException;

	List<T> getAll() throws DaoException;
}

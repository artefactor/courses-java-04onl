package train.dao;

import train.model.IEntity;

import java.util.List;

public interface IDao<T extends IEntity> {
	void init();

	void destroy();

	void create(T event);

	T getById(long id);

	void update(T event);

	void delete(T event);

	List<T> getAll();
}

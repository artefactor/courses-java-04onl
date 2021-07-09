package by.teachmeskills.mvc.converter;

import by.teachmeskills.mvc.entity.AbstractEntity;
import by.teachmeskills.mvc.entity.IEntity;
import by.teachmeskills.mvc.model.AbstractModel;
import by.teachmeskills.mvc.model.IModel;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<M extends IModel, E extends IEntity> implements IConverter<M, E> {


    protected abstract M convertEntity(E entity, M model);
    protected abstract E convertModel(M model, E entity);

    protected abstract M createModel();
    protected abstract E createEntity();

    @Override
    public E convertToEntity(M model) {
        E entity = createEntity();
        ((AbstractEntity) entity).setId(model.getId());
        return convertModel(model, entity);
    }

    @Override
    public M convertToModel(E entity) {
        M model = createModel();
        ((AbstractModel) model).setId(entity.getId());
        return convertEntity(entity, model);
    }

    @Override
    public List<E> convertAllToEntities(List<M> models) {
        List<E> entities = new ArrayList<>();
        for (M model : models) {
            entities.add(convertToEntity(model));
        }
        return entities;
    }

    @Override
    public List<M> convertAllToModels(List<E> entities) {
        List<M> models = new ArrayList<>();
        for (E entity : entities) {
            models.add(convertToModel(entity));
        }
        return models;
    }
}

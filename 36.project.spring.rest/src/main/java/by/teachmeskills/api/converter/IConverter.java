package by.teachmeskills.api.converter;

import by.teachmeskills.api.entity.IEntity;
import by.teachmeskills.api.model.IModel;
import java.util.List;

public interface IConverter<M extends IModel, E extends IEntity> {

    M convertToModel(E entity);
    E convertToEntity(M model);
    List<M> convertAllToModels(List<E> entities);
    List<E> convertAllToEntities(List<M> models);


}

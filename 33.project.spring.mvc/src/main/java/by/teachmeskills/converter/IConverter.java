package by.teachmeskills.converter;

import by.teachmeskills.entity.IEntity;
import by.teachmeskills.model.IModel;
import java.util.List;

public interface IConverter<M extends IModel, E extends IEntity> {

    M convertToModel(E entity);
    E convertToEntity(M model);
    List<M> convertAllToModels(List<E> entities);
    List<E> convertAllToEntities(List<M> models);


}

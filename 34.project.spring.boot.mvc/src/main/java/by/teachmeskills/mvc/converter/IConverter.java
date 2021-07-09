package by.teachmeskills.mvc.converter;

import by.teachmeskills.mvc.entity.IEntity;
import by.teachmeskills.mvc.model.IModel;
import java.util.List;

public interface IConverter<M extends IModel, E extends IEntity> {

    M convertToModel(E entity);
    E convertToEntity(M model);
    List<M> convertAllToModels(List<E> entities);
    List<E> convertAllToEntities(List<M> models);


}

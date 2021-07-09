package by.teachmeskills.mvc.converter.user;

import by.teachmeskills.mvc.converter.AbstractConverter;
import by.teachmeskills.mvc.entity.user.UserEntity;
import by.teachmeskills.mvc.model.user.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<UserModel, UserEntity> {

    @Override
    protected UserModel convertEntity(UserEntity entity, UserModel model) {
        model.setLogin(entity.getLogin());
        return model;
    }

    @Override
    protected UserEntity convertModel(UserModel model, UserEntity entity) {
        entity.setLogin(model.getLogin());
        return entity;
    }

    @Override
    protected UserModel createModel() {
        return new UserModel();
    }

    @Override
    protected UserEntity createEntity() {
        return new UserEntity();
    }
}

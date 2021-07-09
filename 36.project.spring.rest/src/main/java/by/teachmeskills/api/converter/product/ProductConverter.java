package by.teachmeskills.api.converter.product;

import by.teachmeskills.api.converter.AbstractConverter;
import by.teachmeskills.api.entity.product.ProductEntity;
import by.teachmeskills.api.model.product.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter extends AbstractConverter<ProductModel, ProductEntity> {

    @Override
    protected ProductModel convertEntity(ProductEntity entity, ProductModel model) {
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        model.setPrice(entity.getPrice());
        return model;
    }

    @Override
    protected ProductEntity convertModel(ProductModel model, ProductEntity entity) {
        entity.setTitle(model.getTitle());
        entity.setDescription(model.getDescription());
        entity.setPrice(model.getPrice());
        return entity;
    }

    @Override
    protected ProductModel createModel() {
        return new ProductModel();
    }

    @Override
    protected ProductEntity createEntity() {
        return new ProductEntity();
    }
}

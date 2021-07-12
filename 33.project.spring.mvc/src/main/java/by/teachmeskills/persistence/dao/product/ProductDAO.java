package by.teachmeskills.persistence.dao.product;


import by.teachmeskills.persistence.dao.DAO;
import by.teachmeskills.persistence.entity.product.ProductEntity;

import java.util.Optional;

public interface ProductDAO extends DAO<ProductEntity> {

    Optional<ProductEntity> getByTitle(String title);

}

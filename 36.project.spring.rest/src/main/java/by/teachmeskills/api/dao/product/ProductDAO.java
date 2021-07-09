package by.teachmeskills.api.dao.product;


import by.teachmeskills.api.dao.DAO;
import by.teachmeskills.api.entity.product.ProductEntity;
import java.util.Optional;

public interface ProductDAO extends DAO<ProductEntity> {

    Optional<ProductEntity> getByTitle(String title);

}

package by.teachmeskills.dao.product;


import by.teachmeskills.dao.DAO;
import by.teachmeskills.entity.product.ProductEntity;
import java.util.Optional;

public interface ProductDAO extends DAO<ProductEntity> {

    Optional<ProductEntity> getByTitle(String title);

}

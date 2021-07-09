package by.teachmeskills.mvc.dao.product;


import by.teachmeskills.mvc.dao.DAO;
import by.teachmeskills.mvc.entity.product.ProductEntity;
import java.util.Optional;

public interface ProductDAO extends DAO<ProductEntity> {

    Optional<ProductEntity> getByTitle(String title);

}

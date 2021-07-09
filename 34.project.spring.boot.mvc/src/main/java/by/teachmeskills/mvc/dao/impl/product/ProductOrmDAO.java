package by.teachmeskills.mvc.dao.impl.product;

import by.teachmeskills.mvc.dao.exception.DAOException;
import by.teachmeskills.mvc.dao.impl.ORMAbstractDAO;
import by.teachmeskills.mvc.dao.product.ProductDAO;
import by.teachmeskills.mvc.dao.query.product.ProductJPQLQueries;
import by.teachmeskills.mvc.entity.product.ProductEntity;
import java.util.Optional;
//import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ProductOrmDAO extends ORMAbstractDAO<ProductEntity> implements ProductDAO {

    @Override
    public Optional<ProductEntity> getByTitle(String title) {
        return null;
    }

    @Override
    protected Class<ProductEntity> getEntityClass() {
        return ProductEntity.class;
    }
}

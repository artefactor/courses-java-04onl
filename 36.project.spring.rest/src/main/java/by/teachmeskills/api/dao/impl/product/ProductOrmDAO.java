package by.teachmeskills.api.dao.impl.product;

import by.teachmeskills.api.dao.exception.DAOException;
import by.teachmeskills.api.dao.impl.ORMAbstractDAO;
import by.teachmeskills.api.dao.product.ProductDAO;
import by.teachmeskills.api.dao.query.product.ProductJPQLQueries;
import by.teachmeskills.api.entity.product.ProductEntity;
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

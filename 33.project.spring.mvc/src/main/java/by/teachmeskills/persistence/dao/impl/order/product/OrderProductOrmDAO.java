package by.teachmeskills.persistence.dao.impl.order.product;


import by.teachmeskills.persistence.dao.impl.ORMAbstractDAO;
import by.teachmeskills.persistence.dao.order.product.OrderProductDAO;
import by.teachmeskills.persistence.entity.order.product.OrderProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderProductOrmDAO extends ORMAbstractDAO<OrderProductEntity> implements OrderProductDAO {

    @Override
    protected Class<OrderProductEntity> getEntityClass() {
        return OrderProductEntity.class;
    }
}

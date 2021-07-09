package by.teachmeskills.api.dao.impl.order.product;


import by.teachmeskills.api.dao.impl.ORMAbstractDAO;
import by.teachmeskills.api.dao.order.product.OrderProductDAO;
import by.teachmeskills.api.entity.order.product.OrderProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderProductOrmDAO extends ORMAbstractDAO<OrderProductEntity> implements OrderProductDAO {

    @Override
    protected Class<OrderProductEntity> getEntityClass() {
        return OrderProductEntity.class;
    }
}

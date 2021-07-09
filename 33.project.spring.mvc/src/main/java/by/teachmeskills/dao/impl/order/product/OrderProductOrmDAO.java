package by.teachmeskills.dao.impl.order.product;


import by.teachmeskills.dao.impl.ORMAbstractDAO;
import by.teachmeskills.dao.order.product.OrderProductDAO;
import by.teachmeskills.entity.order.product.OrderProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderProductOrmDAO extends ORMAbstractDAO<OrderProductEntity> implements OrderProductDAO {

    @Override
    protected Class<OrderProductEntity> getEntityClass() {
        return OrderProductEntity.class;
    }
}

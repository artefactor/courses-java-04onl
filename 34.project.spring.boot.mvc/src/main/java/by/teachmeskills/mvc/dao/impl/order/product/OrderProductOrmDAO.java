package by.teachmeskills.mvc.dao.impl.order.product;


import by.teachmeskills.mvc.dao.impl.ORMAbstractDAO;
import by.teachmeskills.mvc.dao.order.product.OrderProductDAO;
import by.teachmeskills.mvc.entity.order.product.OrderProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderProductOrmDAO extends ORMAbstractDAO<OrderProductEntity> implements OrderProductDAO {

    @Override
    protected Class<OrderProductEntity> getEntityClass() {
        return OrderProductEntity.class;
    }
}

package by.teachmeskills.api.dao.impl.order;


import by.teachmeskills.api.dao.impl.ORMAbstractDAO;
import by.teachmeskills.api.dao.order.OrderDAO;
import by.teachmeskills.api.entity.order.OrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderOrmDAO extends ORMAbstractDAO<OrderEntity> implements OrderDAO {

    @Override
    protected Class<OrderEntity> getEntityClass() {
        return OrderEntity.class;
    }
}

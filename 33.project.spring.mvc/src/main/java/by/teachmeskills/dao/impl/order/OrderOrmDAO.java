package by.teachmeskills.dao.impl.order;


import by.teachmeskills.dao.impl.ORMAbstractDAO;
import by.teachmeskills.dao.order.OrderDAO;
import by.teachmeskills.entity.order.OrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderOrmDAO extends ORMAbstractDAO<OrderEntity> implements OrderDAO {

    @Override
    protected Class<OrderEntity> getEntityClass() {
        return OrderEntity.class;
    }
}

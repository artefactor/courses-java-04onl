package by.teachmeskills.mvc.dao.impl.order;


import by.teachmeskills.mvc.dao.impl.ORMAbstractDAO;
import by.teachmeskills.mvc.dao.order.OrderDAO;
import by.teachmeskills.mvc.entity.order.OrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderOrmDAO extends ORMAbstractDAO<OrderEntity> implements OrderDAO {

    @Override
    protected Class<OrderEntity> getEntityClass() {
        return OrderEntity.class;
    }
}

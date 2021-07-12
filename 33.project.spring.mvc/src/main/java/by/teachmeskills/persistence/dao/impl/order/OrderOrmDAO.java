package by.teachmeskills.persistence.dao.impl.order;


import by.teachmeskills.persistence.dao.impl.ORMAbstractDAO;
import by.teachmeskills.persistence.dao.order.OrderDAO;
import by.teachmeskills.persistence.entity.order.OrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderOrmDAO extends ORMAbstractDAO<OrderEntity> implements OrderDAO {

    @Override
    protected Class<OrderEntity> getEntityClass() {
        return OrderEntity.class;
    }
}

package by.teachmeskills.mvc.dao.impl.client;


import by.teachmeskills.mvc.dao.client.ClientDAO;
import by.teachmeskills.mvc.dao.impl.ORMAbstractDAO;
import by.teachmeskills.mvc.entity.client.ClientEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ClientOrmDAO extends ORMAbstractDAO<ClientEntity> implements ClientDAO {

    @Override
    protected Class<ClientEntity> getEntityClass() {
        return ClientEntity.class;
    }
}

package by.teachmeskills.dao.impl.client;


import by.teachmeskills.dao.client.ClientDAO;
import by.teachmeskills.dao.impl.ORMAbstractDAO;
import by.teachmeskills.entity.client.ClientEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ClientOrmDAO extends ORMAbstractDAO<ClientEntity> implements ClientDAO {

    @Override
    protected Class<ClientEntity> getEntityClass() {
        return ClientEntity.class;
    }
}

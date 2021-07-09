package by.teachmeskills.api.dao.impl.client;


import by.teachmeskills.api.dao.client.ClientDAO;
import by.teachmeskills.api.dao.impl.ORMAbstractDAO;
import by.teachmeskills.api.entity.client.ClientEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ClientOrmDAO extends ORMAbstractDAO<ClientEntity> implements ClientDAO {

    @Override
    protected Class<ClientEntity> getEntityClass() {
        return ClientEntity.class;
    }
}

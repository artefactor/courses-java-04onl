package by.teachmeskills.persistence.dao.impl.client;


import by.teachmeskills.persistence.dao.client.ClientDAO;
import by.teachmeskills.persistence.dao.impl.ORMAbstractDAO;
import by.teachmeskills.persistence.entity.client.ClientEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ClientOrmDAO extends ORMAbstractDAO<ClientEntity> implements ClientDAO {

    @Override
    protected Class<ClientEntity> getEntityClass() {
        return ClientEntity.class;
    }
}

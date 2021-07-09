package by.teachmeskills.api.dao.impl.address;


import by.teachmeskills.api.dao.address.AddressDAO;
import by.teachmeskills.api.dao.impl.ORMAbstractDAO;
import by.teachmeskills.api.entity.address.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AddressOrmDAO extends ORMAbstractDAO<AddressEntity> implements AddressDAO {

    @Override
    protected Class<AddressEntity> getEntityClass() {
        return AddressEntity.class;
    }
}

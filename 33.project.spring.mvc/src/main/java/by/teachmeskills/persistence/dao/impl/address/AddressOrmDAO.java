package by.teachmeskills.persistence.dao.impl.address;


import by.teachmeskills.persistence.dao.address.AddressDAO;
import by.teachmeskills.persistence.dao.impl.ORMAbstractDAO;
import by.teachmeskills.persistence.entity.address.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AddressOrmDAO extends ORMAbstractDAO<AddressEntity> implements AddressDAO {

    @Override
    protected Class<AddressEntity> getEntityClass() {
        return AddressEntity.class;
    }
}

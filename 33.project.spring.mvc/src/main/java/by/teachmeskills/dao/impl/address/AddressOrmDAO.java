package by.teachmeskills.dao.impl.address;


import by.teachmeskills.dao.address.AddressDAO;
import by.teachmeskills.dao.impl.ORMAbstractDAO;
import by.teachmeskills.entity.address.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AddressOrmDAO extends ORMAbstractDAO<AddressEntity> implements AddressDAO {

    @Override
    protected Class<AddressEntity> getEntityClass() {
        return AddressEntity.class;
    }
}

package by.teachmeskills.mvc.dao.impl.address;


import by.teachmeskills.mvc.dao.address.AddressDAO;
import by.teachmeskills.mvc.dao.impl.ORMAbstractDAO;
import by.teachmeskills.mvc.entity.address.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AddressOrmDAO extends ORMAbstractDAO<AddressEntity> implements AddressDAO {

    @Override
    protected Class<AddressEntity> getEntityClass() {
        return AddressEntity.class;
    }
}

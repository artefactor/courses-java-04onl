package by.teachmeskills.mvc.repository.impl;

import by.teachmeskills.mvc.entity.IEntity;
import by.teachmeskills.mvc.repository.BaseRepository;
import java.io.Serializable;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class BaseRepositoryImpl<E extends IEntity, ID extends Serializable>
    extends SimpleJpaRepository<E, ID> implements BaseRepository<E, ID> {

    public BaseRepositoryImpl(JpaEntityInformation<E, ?> entityInformation,
        EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public BaseRepositoryImpl(Class<E> domainClass, EntityManager em) {
        super(domainClass, em);
    }
}

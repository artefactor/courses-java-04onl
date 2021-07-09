package by.teachmeskills.api.repository.impl;

import by.teachmeskills.api.entity.IEntity;
import by.teachmeskills.api.repository.BaseRepository;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class BaseRepositoryImpl<E extends IEntity, ID extends Serializable>
    extends SimpleJpaRepository<E, ID> implements BaseRepository<E, ID> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseRepositoryImpl.class);

    private EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<E, ?> entityInformation,
        EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseRepositoryImpl(Class<E> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    @Override
    public List<E> findAll() {
        LOGGER.info("findAll() method from {}", this.getClass().getSimpleName());
        return super.findAll();
    }

}

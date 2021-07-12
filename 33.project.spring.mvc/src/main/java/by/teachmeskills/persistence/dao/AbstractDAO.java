package by.teachmeskills.persistence.dao;


import by.teachmeskills.persistence.entity.IEntity;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<E extends IEntity> implements DAO<E> {

    protected Logger logger;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}

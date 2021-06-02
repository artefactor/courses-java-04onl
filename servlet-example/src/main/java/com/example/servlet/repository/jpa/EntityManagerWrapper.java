package com.example.servlet.repository.jpa;

import javax.persistence.EntityManager;

/**
 * наша обертка для того чтобы можно было использовать try-with-resources
 *
 * https://stackoverflow.com/questions/51499270/java-try-with-resource-when-resource-is-inside-non-closable-wrapper
 */
public class EntityManagerWrapper implements AutoCloseable {

    private EntityManager entityManager;

    public EntityManagerWrapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void close() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}

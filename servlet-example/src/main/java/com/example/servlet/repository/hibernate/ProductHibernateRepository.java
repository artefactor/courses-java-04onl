package com.example.servlet.repository.hibernate;

import com.example.servlet.entity.ProductEntity;
import com.example.servlet.repository.ProductRepository;

import java.util.List;

public class ProductHibernateRepository implements ProductRepository {
    ProductHibernateDao dao = new ProductHibernateDao();

    private ProductHibernateRepository() {

    }

    public static class ProductRepositoryHolder {
        public static final ProductHibernateRepository INSTANCE = new ProductHibernateRepository();
    }

    //TODO replace usage to Factory
    public static ProductHibernateRepository getInstance() {
        return ProductRepositoryHolder.INSTANCE;
    }

    public List<ProductEntity> getProducts() {
        return  dao.getAll();
    }

    public void addProduct(ProductEntity productEntity) {
        dao.create(productEntity);
    }
}

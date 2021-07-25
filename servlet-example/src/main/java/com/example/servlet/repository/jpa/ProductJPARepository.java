package com.example.servlet.repository.jpa;

import com.example.servlet.entity.ProductEntity;
import com.example.servlet.repository.IDao;
import com.example.servlet.repository.ProductRepository;

import java.util.List;

public class ProductJPARepository implements ProductRepository {
    IDao<ProductEntity> dao = new ProductJPADao();

    private ProductJPARepository() {

    }

    public static class ProductRepositoryHolder {
        static final ProductJPARepository INSTANCE = new ProductJPARepository();
    }

    public static ProductJPARepository getInstance() {
        return ProductRepositoryHolder.INSTANCE;
    }

    public List<ProductEntity> getProducts() {
        return  dao.getAll();
    }

    public void addProduct(ProductEntity productEntity) {
        dao.create(productEntity);
    }
}

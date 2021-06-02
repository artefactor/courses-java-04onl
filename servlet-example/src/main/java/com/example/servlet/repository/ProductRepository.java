package com.example.servlet.repository;

import com.example.servlet.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
	List<ProductEntity> getProducts();
	void addProduct(ProductEntity productEntity);
}

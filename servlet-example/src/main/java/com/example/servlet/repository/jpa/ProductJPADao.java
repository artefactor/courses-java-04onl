package com.example.servlet.repository.jpa;

import com.example.servlet.entity.ProductEntity;

public class ProductJPADao extends JPAAbstractDao<ProductEntity> {
	@Override
	protected Class<ProductEntity> getEntityClass() {
		return ProductEntity.class;
	}
}

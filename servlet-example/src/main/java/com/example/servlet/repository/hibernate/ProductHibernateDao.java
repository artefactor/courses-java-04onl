package com.example.servlet.repository.hibernate;

import com.example.servlet.entity.ProductEntity;
import com.example.servlet.repository.hibernate.HibernateAbstractDao;

//public class ProductDao extends JPAAbstractDao<ProductEntity> {
public class ProductHibernateDao extends HibernateAbstractDao<ProductEntity> {
	@Override
	protected Class<ProductEntity> getEntityClass() {
		return com.example.servlet.entity.ProductEntity.class;
	}
}

package com.example.servlet.repository;

import com.example.servlet.repository.hibernate.ProductHibernateRepository;
import com.example.servlet.repository.jdbc.ProductRepositoryJDBC;
import com.example.servlet.repository.jpa.ProductJPARepository;

public class ProductRepositoryFactory {

	static REPOSITORY_APPROACH repository_approach;

	public static void init(String db) {
		try {
			repository_approach = REPOSITORY_APPROACH.valueOf(db);
		} catch (Exception e) {
			// log and return default or throw new
			System.out.println(String.format("error during processing %s. Expected values: %s", db, REPOSITORY_APPROACH.values()));
			throw new IllegalArgumentException("repository_approach is illegal: " + db);
		}
	}

	public static ProductRepository getRepositoryInstance() {
		ProductRepository productRepository = getProductRepository();
		System.out.println("used: " + productRepository);
		return productRepository;
	}

	private static ProductRepository getProductRepository() {
		switch (repository_approach) {
			case HIBERNATE:
				return ProductHibernateRepository.getInstance();
			case JDBC:
				return ProductRepositoryJDBC.getInstance();
			case JPA:
				return ProductJPARepository.getInstance();
			default:
				throw new IllegalArgumentException("repository_approach is illegal: " + repository_approach);
		}
	}

	enum REPOSITORY_APPROACH {
		JDBC, HIBERNATE, JPA
	}
}

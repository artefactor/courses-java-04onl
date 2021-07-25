package com.example.servlet.repository;

import com.example.servlet.repository.hibernate.ProductHibernateRepository;
import com.example.servlet.util.XMLParser;
import com.example.servlet.util.XMLParserDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class ProductRepositoryTest {

    private XMLParser xmlParser;
    private XMLParserDecorator proxy;

    @BeforeEach
    void init() {
        xmlParser = new XMLParser();
        proxy = new XMLParserDecorator(xmlParser);
    }

    @Test
    public void testClone() throws Exception {
        final ProductHibernateRepository instance1 = ProductHibernateRepository.getInstance();
        final ProductHibernateRepository instance2 = ProductHibernateRepository.getInstance();
        final ProductHibernateRepository instance3 = ProductHibernateRepository.getInstance();
        final ProductHibernateRepository instance4 = ProductHibernateRepository.getInstance();
        final ProductHibernateRepository instance5 = ProductHibernateRepository.getInstance();
        assertSame(instance1, instance2);
        assertSame(instance1, instance3);
        assertSame(instance1, instance4);
        assertSame(instance1, instance5);
    }

    @Test
    void testProxy() {
        proxy.parse("asd");
    }
}
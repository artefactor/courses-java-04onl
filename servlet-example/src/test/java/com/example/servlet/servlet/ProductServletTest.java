package com.example.servlet.servlet;

import com.example.servlet.ServletTest;
import com.example.servlet.entity.ProductEntity;
import com.example.servlet.repository.hibernate.ProductHibernateRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServletTest extends ServletTest {

    @InjectMocks
    private ProductServlet productServlet;

    @Mock
    private ProductHibernateRepository productRepository;

    @Mock
    private ServletConfig config;

    @Captor
    private ArgumentCaptor<ProductEntity> entityCaptor;

    @Test
    void testDoPost() throws Exception {
        final ServletContext context = mock(ServletContext.class);
        when(config.getServletContext()).thenReturn(context);
        when(context.getInitParameter("param")).thenReturn("value");
        doNothing().when(productRepository).addProduct(any());
        productServlet.doPost(request, response);
        verify(productRepository).addProduct(entityCaptor.capture());
        verify(response).sendRedirect("catalog");

        final ProductEntity productEntity = entityCaptor.getValue();
        assertNotNull(productEntity);
        assertThat(productEntity, notNullValue());

        assertEquals("title1", productEntity.getTitle());
        assertThat(productEntity.getTitle(), is("title1"));

        assertEquals(1, productEntity.getPrice());
        assertThat(productEntity.getPrice(), is(1));
    }
}
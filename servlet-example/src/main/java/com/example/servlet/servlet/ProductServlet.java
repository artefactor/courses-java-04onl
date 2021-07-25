package com.example.servlet.servlet;

import com.example.servlet.entity.ProductEntity;
import com.example.servlet.repository.ProductRepository;
import com.example.servlet.repository.ProductRepositoryFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/new-product.jsp").forward(req, resp);
        productRepository = ProductRepositoryFactory.getRepositoryInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String param = getServletContext().getInitParameter("param");
        String title = req.getParameter("title");
        String price = req.getParameter("price");
        // TODO fix number format exception
        final ProductEntity productEntity = ProductEntity.builder().title(title).price(Double.parseDouble(price)).build();
        productRepository.addProduct(productEntity);
        resp.sendRedirect("catalog");
    }
}

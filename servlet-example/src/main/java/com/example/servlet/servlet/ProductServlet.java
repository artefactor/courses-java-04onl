package com.example.servlet.servlet;

import com.example.servlet.entity.ProductEntity;
import com.example.servlet.repository.ProductRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository = ProductRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/new-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String param = getServletContext().getInitParameter("param");
        final ProductEntity productEntity = ProductEntity.builder().title("title1").price(1).build();
        productRepository.addProduct(productEntity);
        resp.sendRedirect("catalog");
    }
}

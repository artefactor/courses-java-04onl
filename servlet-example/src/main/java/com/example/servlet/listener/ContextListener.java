package com.example.servlet.listener;

import com.example.servlet.repository.ProductRepositoryFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener init: " + sce.getServletContext().getContextPath());
        ServletContext servletContext = sce.getServletContext();
        String db = servletContext.getInitParameter("db_approach");
        ProductRepositoryFactory.init(db);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Destroyed");
    }
}

package com.example.servlet.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@WebFilter(filterName = "auth", urlPatterns = {"/admin", "/products"})
public class AuthenticationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpSession session = req.getSession();
        if (session == null) {
            res.sendError(401);
            return;
        }
        final String username = (String) session.getAttribute("username");
        if (username == null || !username.equals(getServletContext().getInitParameter("username"))) {
            res.sendError(401);
            return;
        }
        chain.doFilter(req, res);
        final Iterator<Object> iterator = new ArrayList<>().iterator();
    }
}

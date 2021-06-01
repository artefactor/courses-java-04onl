package com.example.servlet.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.ThreadContext;

import java.io.IOException;
import java.util.UUID;

@WebFilter(filterName = "logging", urlPatterns = "/*")
public class LoggingFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        final String requestId = req.getHeader("X-Request-ID");
        if (requestId != null) {
            ThreadContext.put("requestId", requestId);
        } else {
            ThreadContext.put("requestId", UUID.randomUUID().toString());
        }
        chain.doFilter(req, res);
    }
}

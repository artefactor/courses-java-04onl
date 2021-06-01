package com.example.servlet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class ServletTest {

    @Mock(lenient = true)
    protected HttpServletRequest request;

    @Mock
    protected HttpServletResponse response;

    @Mock(lenient = true)
    protected RequestDispatcher requestDispatcher;

    @BeforeEach
    protected void init() throws Exception {
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        doNothing().when(requestDispatcher).forward(request, response);
    }

    @Test
    void testDoPost() {
    }
}

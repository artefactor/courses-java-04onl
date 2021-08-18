package com.example.testing;

import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class PrintUtil {

	public static void ensureThatMock(Object service) {
		System.out.println(service.getClass().getName());
		assertTrue(service.getClass().getSimpleName().contains("Mock"));
	}
}

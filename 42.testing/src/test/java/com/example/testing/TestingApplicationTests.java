package com.example.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * to bootstrap the entire container
 */
@SpringBootTest
class TestingApplicationTests {
	@Autowired private ApplicationContext applicationContext;
	@Test
	void contextLoads() { PrintUtil.printContext(applicationContext, this); }

}

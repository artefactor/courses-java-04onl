package com.example.testing.third.o;

import com.example.testing.PrintUtil;
import com.example.testing.first.ATestConfig1a;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * to bootstrap the entire container
 */
@RunWith(SpringRunner.class)
@Import(ATestConfig1a.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ITest5_WithUnworkingTestConfig {
	@Autowired private MockMvc mvc;
	@Autowired private ApplicationContext applicationContext;
	@Test
	public void test1() { PrintUtil.printContext(applicationContext, this);}
}

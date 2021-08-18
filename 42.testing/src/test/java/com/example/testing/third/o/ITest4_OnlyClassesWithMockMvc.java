package com.example.testing.third.o;

import com.example.testing.PrintUtil;
import com.example.testing.first.a.AComponent1;
import com.example.testing.first.b.AComponent2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * to bootstrap the entire container
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AComponent1.class, AComponent2.class})
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ITest4_OnlyClassesWithMockMvc {
	@Autowired private MockMvc mvc;
	@Autowired private ApplicationContext applicationContext;
	@Test
	public void test1() { PrintUtil.printContext(applicationContext, this);}
}

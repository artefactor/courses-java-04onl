package com.example.testing.third.o;

import com.example.testing.PrintUtil;
import com.example.testing.first.ATestConfig1a;
import com.example.testing.first.ATestConfig1b;
import com.example.testing.first.a.AComponent1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.testing.PrintUtil.ensureThatMock;

/**
 * to bootstrap the entire container
 */
@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
@Import(ATestConfig1b.class)
public class ITest6_WithTestConfig {
//	@Autowired private MockMvc mvc;
	@Autowired private ApplicationContext applicationContext;
	@Autowired private AComponent1 component1;

	@Test
	public void test1() { PrintUtil.printContext(applicationContext, this);}
	@Test public void test2() { ensureThatMock(component1); }
}

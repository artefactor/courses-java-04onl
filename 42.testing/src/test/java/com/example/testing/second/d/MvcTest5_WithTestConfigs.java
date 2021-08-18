package com.example.testing.second.d;

import com.example.testing.first.ATestConfig1b;
import com.example.testing.first.c.AController2;
import com.example.testing.seventh.g.AService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.testing.PrintUtil.ensureThatMock;
import static com.example.testing.PrintUtil.printContext;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AController2.class)
@Import({ATestConfig1b.class,
		ATestConfig2.class})
public class MvcTest5_WithTestConfigs {
	@Autowired	ApplicationContext applicationContext;
	@Autowired AService aService;


	@Test
	public void test1() { printContext(applicationContext, this); }
	@Test public void test2() { ensureThatMock(aService); }
	@Test public void test3() { assertEquals("ATestConfig2" + 71, aService.getVersion()); }
}

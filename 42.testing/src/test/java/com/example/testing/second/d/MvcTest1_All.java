package com.example.testing.second.d;

import com.example.testing.PrintUtil;
import com.example.testing.seventh.g.AService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.testing.PrintUtil.ensureThatMock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MvcTest1_All {
	@Autowired
	private ApplicationContext applicationContext;

	@MockBean
	private AService aService;

	@Before
	public void setUp() throws Exception {
		when(aService.getVersion()).thenReturn("MockBean" + 8);
	}

	@Test
	public void test1() { PrintUtil.printContext(applicationContext, this); }

	@Test public void test2() { ensureThatMock(aService); }
	@Test public void test3() { assertEquals("MockBean" + 8, aService.getVersion()); }
}

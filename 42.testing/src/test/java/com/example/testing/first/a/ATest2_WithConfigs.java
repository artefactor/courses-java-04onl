package com.example.testing.first.a;


import com.example.testing.PrintUtil;
import com.example.testing.first.ATestConfig1a;
import com.example.testing.first.b.AComponent2;
import com.example.testing.first.b.AConfig0;
import com.example.testing.second.d.ANonComponent3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.testing.PrintUtil.ensureThatMock;
import static com.example.testing.PrintUtil.printContext;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {AConfig0.class})
@Import(ATestConfig1a.class)
public class ATest2_WithConfigs {
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private AComponent2 component2;
	@Autowired
	private AComponent1 component1;
	@MockBean
	private ANonComponent3 component3;
	@Test public void test1WithConfigs() { printContext(applicationContext, this); }
	@Test public void test2() { ensureThatMock(component1); }

}

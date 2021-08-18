package com.example.testing.first.a;


import com.example.testing.PrintUtil;
import com.example.testing.first.b.AComponent2;
import com.example.testing.first.b.AConfig0;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {AConfig0.class})
public class ATest1_ClassicUnitTest {
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private AComponent2 component2;

	@Test
	public void test1ClassicUnitTest() {
		PrintUtil.printContext(applicationContext, this);
	}

}

package com.example.testing.first.a;


import com.example.testing.PrintUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ATest0_EmptyUnitTest {
	@Autowired private ApplicationContext applicationContext;
//	@Autowired	private AComponent1 component1;

	@Test
	public void test1EmptyUnitTest() { PrintUtil.printContext(applicationContext, this); }

}

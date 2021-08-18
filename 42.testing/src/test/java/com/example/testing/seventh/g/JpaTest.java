package com.example.testing.seventh.g;

import com.example.testing.PrintUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {
	@Autowired private ApplicationContext applicationContext;

	@Test
	public void test1OnlyRepository() { PrintUtil.printContext(applicationContext, this); }
}

package by.train;

import by.train.animal.model.Lion;
import by.train.animal.model.Meat;
import by.train.bpp.PostProcessorConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class PostProcessorTest {
	private int amount = 28;
	private int amountAfterFirstEat = 18;
	private int amountAfterSecondEat = 18;

	private Meat meat = new Meat(amount);

	private void testCallSuccess(ApplicationContext context) {
		// given
		Lion lion = context.getBean(Lion.class);
		// when
		lion.eat(meat);
		// then
		assertEquals(amountAfterFirstEat, meat.getAmount());
	}

	@Test
	public void lion_withoutBeanPostProcessor1() {
		testCallSuccess(new AnnotationConfigApplicationContext(AppConfig.class));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void lion_withoutBeanPostProcessor2() {
		// given
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Lion lion = context.getBean(Lion.class);
		// when
		lion.eat(meat);
		lion.eat(meat);
		// then fails
		assertEquals(amountAfterSecondEat, meat.getAmount());
	}

	//  use post processor with wrapping bean with proxy

	@Test
	public void lion_beanPostProcessor() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, PostProcessorConfig.class);
		testCallSuccess(context);
	}

	@Test
	public void lion_beanPostProcessorNoException() {
		// given
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, PostProcessorConfig.class);
		Lion lion = context.getBean(Lion.class);

		// when
		lion.eat(meat);
		lion.eat(meat);
		// then
		assertEquals(amountAfterSecondEat, meat.getAmount());
	}

	@Test
	public void lion_beanPostProcessorUseTargetMethods() {
		// given
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, PostProcessorConfig.class);
		Lion lion = context.getBean(Lion.class);
		// then
		assertEquals(20, lion.getAge());
	}

}

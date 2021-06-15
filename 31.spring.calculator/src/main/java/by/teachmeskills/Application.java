package by.teachmeskills;

import by.teachmeskills.calculator.Calculator;
import by.teachmeskills.calculator.CalculatorEngineeringFactory;
import by.teachmeskills.conf.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println("Всего бинов: " + context.getBeanDefinitionCount());

		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName + " - " + context.getBean(beanDefinitionName).getClass());
		}

		final Calculator calculator = context.getBean("calculator", Calculator.class);

		// если вручную сетается фабрика
//		calculator.setCalculatorOperationFactory(new CalculatorEngineeringFactory());
//		final CalculatorOperationFactory factory = context.getBean("calculatorOperationFactory", CalculatorOperationFactory.class);
//TODO uncomment
//		calculator.setCalculatorOperationFactory(factory);
		calculator.run();
	}

}

package by.teachmeskills.calculator;

import by.teachmeskills.opetation.ISimpleOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SpringCalculatorOperationFactory implements ICalculatorOperationFactory {

	private ApplicationContext context;

	@Autowired
	public SpringCalculatorOperationFactory(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public ISimpleOperation defineOperation(String operationSuffix) {
		String beanName = "operation" + operationSuffix;
		try {
			ISimpleOperation operation = context.getBean(beanName, ISimpleOperation.class);
			return operation;
		} catch (Exception e) {
			System.out.println("No bean with name '" + beanName + "'");
			return null;
		}
	}
}

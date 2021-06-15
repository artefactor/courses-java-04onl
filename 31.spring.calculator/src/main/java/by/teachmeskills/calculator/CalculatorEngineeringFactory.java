package by.teachmeskills.calculator;

import by.teachmeskills.opetation.ISimpleOperation;
import by.teachmeskills.opetation.LogarithmOperation;
import org.springframework.stereotype.Component;

@Component
public class CalculatorEngineeringFactory implements ICalculatorOperationFactory {

	// TODO нужно сюда добавить еще и другие операции
	public ISimpleOperation defineOperation(String operation) {
		if ("log".equals(operation)){
			return new LogarithmOperation();
		}
		return null;
	}
}

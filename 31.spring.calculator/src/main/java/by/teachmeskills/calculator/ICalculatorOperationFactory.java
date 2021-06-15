package by.teachmeskills.calculator;

import by.teachmeskills.opetation.ISimpleOperation;

public interface ICalculatorOperationFactory {
	ISimpleOperation defineOperation(String operation);
}

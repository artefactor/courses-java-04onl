package by.teachmeskills.calculator;

import by.teachmeskills.opetation.ISimpleOperation;
import by.teachmeskills.opetation.LogarithmOperation;
import by.teachmeskills.opetation.division.DivisionOperation;
import by.teachmeskills.opetation.minus.MinusOperation;
import by.teachmeskills.opetation.mult.MultiplicationOperation;
import by.teachmeskills.opetation.plus.PlusOperation;

public class CalculatorOperationFactory /*implements ICalculatorOperationFactory */{

	public static ISimpleOperation defineOperation(String operation) {
		if ("+".equals(operation)){
			return new PlusOperation();
		}
		if ("-".equals(operation)){
			return new MinusOperation();
		}
		if ("/".equals(operation)){
			return new DivisionOperation();
		}
		if ("*".equals(operation)){
			return new MultiplicationOperation();
		}

		return null;
	}
}

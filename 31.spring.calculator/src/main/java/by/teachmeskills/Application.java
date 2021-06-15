package by.teachmeskills;

import by.teachmeskills.calculator.Calculator;

public class Application {

	public static void main(String[] args) {
		Calculator calculator = new  Calculator();
//		calculator.setCalculatorOperationFactory(factory);
		calculator.run();
	}

}

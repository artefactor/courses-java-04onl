package by.teachmeskills.calculator;

import by.teachmeskills.opetation.ISimpleOperation;
import by.teachmeskills.opetation.LogarithmOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//@Component
@Qualifier("standard")
public class CalculatorOperationFactory implements ICalculatorOperationFactory {

	private final ISimpleOperation plusOperation;
	private final ISimpleOperation minusOperation;
	private final ISimpleOperation divisionOperation;
	private ISimpleOperation multiplicationOperation;

	public CalculatorOperationFactory(
			@Qualifier("opetation+") ISimpleOperation plusOperation,
			@Qualifier("opetation-") ISimpleOperation minusOperation,
			@Qualifier("opetation/") ISimpleOperation divisionOperation) {
		this.plusOperation = plusOperation;
		this.minusOperation = minusOperation;
		this.divisionOperation = divisionOperation;
	}

	@Autowired
	public void setMultiplicationOperation(@Qualifier("opetation*")  ISimpleOperation multiplicationOperation) {
		this.multiplicationOperation = multiplicationOperation;
	}

	@Override
	public ISimpleOperation defineOperation(String operation) {
		if ("+".equals(operation)){
			return plusOperation;
		}
		if ("-".equals(operation)){
			return minusOperation;
		}
		if ("/".equals(operation)){
			return divisionOperation;
		}
		if ("*".equals(operation)){
			return multiplicationOperation;
		}
		if ("log".equals(operation)){
			return new LogarithmOperation();
		}
		return null;
	}
}

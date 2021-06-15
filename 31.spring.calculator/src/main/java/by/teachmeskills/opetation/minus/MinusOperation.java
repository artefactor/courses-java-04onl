package by.teachmeskills.opetation.minus;

import by.teachmeskills.opetation.AbstractSimpleOperation;
import org.springframework.stereotype.Component;

@Component("operation-")
public class MinusOperation extends AbstractSimpleOperation {

	@Override
	public double process(int a, int b) {
		return a - b;
	}
}

package by.teachmeskills.opetation.mult;

import by.teachmeskills.opetation.AbstractSimpleOperation;
import org.springframework.stereotype.Component;

@Component("operation*")
public class MultiplicationOperation extends AbstractSimpleOperation {

    @Override
    public double process(int a, int b) {
        return a * b;
    }
}

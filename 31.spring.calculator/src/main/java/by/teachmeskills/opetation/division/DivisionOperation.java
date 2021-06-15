package by.teachmeskills.opetation.division;

import by.teachmeskills.opetation.AbstractSimpleOperation;
import org.springframework.stereotype.Component;

@Component("operation/")
public class DivisionOperation extends AbstractSimpleOperation {

    @Override
    public double process(int a, int b) {
        return (double) a / b;
    }
}

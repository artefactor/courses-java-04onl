package by.teachmeskills.opetation.plus;

import by.teachmeskills.aspect.CustomOperation;
import by.teachmeskills.opetation.AbstractSimpleOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.stereotype.Component;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component("operation+")
public /*final */ class PlusOperation extends AbstractSimpleOperation {

    @CustomOperation
    @Override
    public double process(int a, int b) {
        return a + b;
    }
}

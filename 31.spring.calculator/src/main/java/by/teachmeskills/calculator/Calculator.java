package by.teachmeskills.calculator;

import by.teachmeskills.opetation.ISimpleOperation;
import by.teachmeskills.util.CalculatorUtils;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

//import com.sun.corba.se.spi.orb.OperationFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private boolean isOpen = false;

    private ICalculatorOperationFactory calculatorOperationFactory;
    private CalculatorUtils calculatorUtils;
    //    private ApplicationContext context;

//    @Autowired
    public Calculator( ICalculatorOperationFactory factory, CalculatorUtils calculatorUtils) {
        this.calculatorOperationFactory = factory;
        this.calculatorUtils = calculatorUtils;
        System.out.println("Factory is used: " + calculatorOperationFactory);
    }


    //    @Autowired
    public void setCalculatorOperationFactory(ICalculatorOperationFactory calculatorOperationFactory) {
        this.calculatorOperationFactory = calculatorOperationFactory;
    }

    public void run() {
        isOpen = true;
        while (isOpen) {
            final int a = calculatorUtils.readIntValue("Enter first number: ");
            final int b = calculatorUtils.readIntValue("Enter second number: ");
            final ISimpleOperation simpleOperation = resolveOperation();
            final double result = simpleOperation.process(a, b);
            System.out.printf("Result is: " + new DecimalFormat("#0.00").format(result) + "\n");
            System.out.println("=======================================================");
            final boolean isContinue = calculatorUtils.readBooleanValue("Continue? (true/false)");
            if (!isContinue) {
                setOpen(false);
            }
        }
    }

    private ISimpleOperation resolveOperation() {
        ISimpleOperation simpleOperation = null;
        while (simpleOperation == null) {
            String operation = calculatorUtils.readStringValue("Enter opetation (available operations: +,-,*,/): ");
            simpleOperation = calculatorOperationFactory.defineOperation(operation);
//            try {
//                simpleOperation = context.getBean("opetation" + opetation, ISimpleOperation.class);
//            } catch (BeansException e) {
//                System.out.println("Wrong opetation type entered, available operations: +,-,/,*");
//            }
        }
        return simpleOperation;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }

//    @Autowired
//    public void setContext(ApplicationContext context) {
//        this.context = context;
//    }
//
}

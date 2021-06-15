package by.teachmeskills.calculator;

import by.teachmeskills.opetation.ISimpleOperation;
import by.teachmeskills.util.CalculatorUtils;

import java.text.DecimalFormat;

//import com.sun.corba.se.spi.orb.OperationFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;

public class Calculator {

    private boolean isOpen = false;


    public void run() {
        isOpen = true;
        while (isOpen) {
            final int a = CalculatorUtils.readIntValue("Enter first number: ");
            final int b = CalculatorUtils.readIntValue("Enter second number: ");
            final ISimpleOperation simpleOperation = resolveOperation();
            final double result = simpleOperation.process(a, b);
            System.out.printf("Result is: " + new DecimalFormat("#0.00").format(result) + "\n");
            System.out.println("=======================================================");
            final boolean isContinue = CalculatorUtils.readBooleanValue("Continue? (true/false)");
            if (!isContinue) {
                setOpen(false);
            }
        }
    }

    private ISimpleOperation resolveOperation() {
        ISimpleOperation simpleOperation = null;
        while (simpleOperation == null) {
            String operation = CalculatorUtils.readStringValue("Enter opetation (available operations: +,-,*,/): ");
            simpleOperation = CalculatorOperationFactory.defineOperation(operation);
//            try {
//                simpleOperation = context.getBean("operation" + operation, ISimpleOperation.class);
//            } catch (BeansException e) {
//                System.out.println("Wrong operation type entered, available operations: +,-,/,*");
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

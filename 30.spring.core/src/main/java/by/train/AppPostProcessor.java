package by.train;

import by.train.bpp.AnotherCat;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppPostProcessor {
   public static void main(String[] args) {
      AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

      System.out.println();
      System.out.println(" context is init");
      AnotherCat obj = (AnotherCat) context.getBean("cat");
      obj.getMessage();
      int age = obj.getAge();
      System.out.println("cat's age: " + age);

      System.out.println();
      context.registerShutdownHook();
   }
}
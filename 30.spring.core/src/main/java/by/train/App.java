package by.train;

import by.train.model.Animal;
import by.train.model.Cat;
import by.train.model.Food;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext("by.train.model");
//				new AnnotationConfigApplicationContext(Config.class);
//				new AnnotationConfigApplicationContext(IteConfig.class);
//				new ClassPathXmlApplicationContext("app-context.xml");
//			     new ClassPathXmlApplicationContext("spring-config.xml");

		// сколько бинов
		int beanDefinitionCount = context.getBeanDefinitionCount();
		System.out.println("init beans:" + beanDefinitionCount);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

		// достаем бины из контекста
		Animal catBean1 = context.getBean(Animal.class);
		System.out.println("cat from spring context:" + catBean1);
		catBean1.eat();

		Animal catBean2 = context.getBean(Animal.class);
		System.out.println("cat from spring context:" + catBean2);
		catBean2.eat();

		// достаем проперти из контекста
		String prop1 = context.getEnvironment().getProperty("prop1");
		System.out.println("prop1 from env" + prop1);

		// создаем объект без контекста
		Cat cat = new Cat(new Food());
		cat.setFood(new Food());
		System.out.println("cat without spring context:" + cat);
		cat.eat();

//while(true){
//
//}
	}
}

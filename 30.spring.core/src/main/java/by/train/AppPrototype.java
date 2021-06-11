package by.train;

import by.train.model.Animal;
import by.train.model.Cat;
import by.train.model.Food;
import by.train.springprototype.AnnotationConfigApplicationContextProto;
import by.train.springprototype.ApplicationContextProto;

/**
 * прототип как может работать спринг
 */
public class AppPrototype {
	public static void main(String[] args) {
		ApplicationContextProto context =
				new AnnotationConfigApplicationContextProto("by.train.model");

		int beanDefinitionCount = context.getBeanDefinitionCount();
		System.out.println("init beans:" + beanDefinitionCount);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		Animal bean = context.getBean(Animal.class);
		System.out.println("cat from spring context:" + bean);
		bean.eat();

		Cat cat = new Cat(new Food());
		cat.setFood(new Food());
		System.out.println("cat without spring context:" + cat);
		cat.eat();

	}
}

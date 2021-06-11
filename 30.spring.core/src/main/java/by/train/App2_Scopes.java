package by.train;

import by.train.config.Config;
import by.train.model.Cat;
import by.train.model.Food;
import by.train.model.Lion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * singleton,
 * prototype
 * factoryBean
 */
public class App2_Scopes {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

		Cat cat = context.getBean( Cat.class);

		Food food1 = context.getBean( Food.class);
		Food food2 = context.getBean( Food.class);
		Food food3 = context.getBean( Food.class);

		Lion lion1 = context.getBean( Lion.class);
		Lion lion2 = context.getBean( Lion.class);

		System.out.println(lion1);
		System.out.println(lion2);

		System.out.println(food1);
		System.out.println(food2);
		System.out.println(food3);
		System.out.println(cat.getFood());
	}
}

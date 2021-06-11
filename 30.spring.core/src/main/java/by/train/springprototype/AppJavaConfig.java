package by.train.springprototype;

import by.train.model.Cat;
import by.train.model.ComponentsRoot;
import by.train.model.Food;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com"})
@ComponentScan(basePackageClasses = {ComponentsRoot.class})
public class AppJavaConfig {

	@Bean
	Cat servlet(Food food) {
//		return new Cat(food());
		return new Cat(food);
	}
	@Bean
//	@Scope ("prototype")
	Food repository() {
		return new Food();
	}
}

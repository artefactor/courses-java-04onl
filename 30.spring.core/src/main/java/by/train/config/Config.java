package by.train.config;

import by.train.model.Animal;
import by.train.model.ComponentsRoot;
import by.train.model.Dog;
import by.train.model.LionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ComponentsRoot.class)
public class Config {

	@Bean
	Animal dogAnimal() {
		return new Dog();
	}

//	@Bean
//	LionFactoryBean lion() {
//		return new LionFactoryBean();
//	}
}

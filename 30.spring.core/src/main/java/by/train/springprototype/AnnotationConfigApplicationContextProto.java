package by.train.springprototype;

import by.train.model.Animal;
import by.train.model.Cat;
import by.train.model.Food;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnnotationConfigApplicationContextProto extends ApplicationContextProto {
	public AnnotationConfigApplicationContextProto(String name) {
		super();
	}

	/**
	 * Map of bean definition objects, keyed by bean name.
	 */
	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

	private final Map<BeanDefinition, Object> singletons = new ConcurrentHashMap<>(256);

	@Override
	public int getBeanDefinitionCount() {
		return beanDefinitionMap.size();
	}

	@Override
	public String[] getBeanDefinitionNames() {
		return (String[]) beanDefinitionMap.keySet().toArray();
	}

	@Override
	public <T> T getBean(Class<T> requredClass) {
		// beanDefinitionMap
		if (requredClass.equals(Animal.class)) {
			BeanDefinition beanDefinition = null;
			if (beanDefinition.isSingleton()) {
				Object o = singletons.get(beanDefinition);
				if (o != null) {
					return (T) o;
				}
				Cat cat = new Cat(new Food());
				singletons.put(beanDefinition, cat);
				return (T) cat;
			} else {
				// is prototype
				return (T) new Cat(new Food());
			}
		}
		return null;
	}
}

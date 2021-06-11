package by.train.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;

public class CustomInitPostProcessor implements BeanPostProcessor {
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (bean instanceof AnotherAnimal) {
			((AnotherAnimal) bean).setAge(18);
		}
		if (AnnotationUtils.findAnnotation(bean.getClass(), OurAnnotation.class) != null) {
			System.out.println(" find " + OurAnnotation.class.getName() + " annotation : " + beanName);
		}

		System.out.println("BeforeInitialization : " + beanName);

		return bean;  // you can return any other object as well
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {

		System.out.println("AfterInitialization : " + beanName);
		return bean;  // you can return any other object as well
	}
}
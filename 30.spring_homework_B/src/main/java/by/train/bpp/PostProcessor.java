package by.train.bpp;

import by.train.animal.model.Lion;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * TODO реализовать и подключить такой бин-пост-просессор.
 * Какие аннотации и какой интерфейс нужны?
 */

@Component
public class PostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Lion) {
            return new LionProxy((Lion) bean);
        }
        return bean;
    }
    /* TODO реализовать псевдокод
		if (bean instanceof Lion){
			обернуть в прокси
		}
		 */
}

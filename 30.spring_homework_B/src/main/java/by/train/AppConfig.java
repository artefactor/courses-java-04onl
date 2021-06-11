package by.train;

import by.train.animal.model.Fox;
import by.train.browser.Firefox;
import by.train.car.JaguarCar;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(
		/* TODO нужно добавить сюда нужные конфигурации
		 *  при этом исключить пакет by.train.animal.model.domestic
		 */
)

@Import(value = {
//		TODO нужно добавить сюда нужные конфигурации
})

//TODO подключить конфиг linux.xml
//TODO подключить common.properties
/**
 * общий конфиг
 */
public class AppConfig {
}

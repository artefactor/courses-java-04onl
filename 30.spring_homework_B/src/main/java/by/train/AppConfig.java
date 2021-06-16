package by.train;

import by.train.animal.model.Fox;
import by.train.animal.model.domestic.Horse;
import by.train.animal.model.domestic.Pig;
import by.train.animal.model.rare.Jaguar;
import by.train.bpp.PostProcessorConfig;
import by.train.browser.Firefox;
import by.train.car.JaguarCar;
import by.train.zoo.Config;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages ={
        "by.train.browser", "by.train.car","by.train.animal.model"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "by.train.animal.model.domestic.*")

        /* TODO нужно добавить сюда нужные конфигурации
         *  при этом исключить пакет by.train.animal.model.domestic
         */
)

@Import(value = {Config.class

//		TODO нужно добавить сюда нужные конфигурации
})

////TODO подключить конфиг linux.xml
////TODO подключить common.properties
/**
 * общий конфиг
 */
@PropertySource("classpath:common.properties")
@ImportResource({"classpath:linux.xml"})
public class AppConfig {


}

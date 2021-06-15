package by.train.bpp;

import by.train.animal.model.Lion;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//TODO конфиг который подключает постпроцессор


@Configuration
@ComponentScan(basePackageClasses ={ PostProcessorConfig.class/*,LionProxy.class*/})
public class PostProcessorConfig {

}

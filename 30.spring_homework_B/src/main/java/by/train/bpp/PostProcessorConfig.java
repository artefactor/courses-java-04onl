package by.train.bpp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//TODO конфиг который подключает постпроцессор


@Configuration
@ComponentScan(basePackageClasses = {PostProcessorConfig.class/*,LionProxy.class*/})
public class PostProcessorConfig {

}

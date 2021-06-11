package by.train.configexample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackageClasses = {
	//	service.ComponentsRoot.class
})
@Import({
//		TrafficServicesConfig.class,
//		SessionServicesConfig.class,
//		SystemServicesConfig.class
})
@PropertySource(value = "classpath:client/config-common.properties", ignoreResourceNotFound = false)
@PropertySource(value = "file:${ext_config_dir}/config-common.properties", ignoreResourceNotFound = true)
public class IteConfig {

}
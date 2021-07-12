package by.teachmeskills.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

	@Bean
	public Logger logger(InjectionPoint injectionPoint) {
		return LogManager.getLogger(injectionPoint.getDeclaredType());
	}
}

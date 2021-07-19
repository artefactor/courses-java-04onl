package by.teachmeskills.api.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity(debug = true)
public class AppConfig
		extends WebSecurityConfigurerAdapter
//        extends WebSecurityConfigurerAdapter
//        implements ApplicationContextAware, WebMvcConfigurer
{


	@Bean
	public Logger logger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getDeclaredType());
	}

	// если запуск на пост из сваггера - то нужно выключить эти настройки
	// Cross Site Request Forgery
	//    Cross-Origin Resource Sharing
//    https://stackoverflow.com/questions/19468209/spring-security-403-error

	// но этого просто пример. если так написать то оно полностью все отключит.
	// нужно писать как в методе ниже
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Note:
		// Use this to enable the tomcat basic authentication (tomcat popup rather than spring login page)
		// Note that the CSRf token is disabled for all requests (change it as you wish...)
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedMethods("*");
//    }
}

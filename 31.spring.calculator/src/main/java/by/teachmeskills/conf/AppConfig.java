package by.teachmeskills.conf;

import by.teachmeskills.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
@EnableAspectJAutoProxy
public class AppConfig {


}

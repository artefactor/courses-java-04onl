package by.train.animal;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "by.train.animal.model",
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
                pattern = "by.train.animal.model.domestic.*"))
public class Config {
}

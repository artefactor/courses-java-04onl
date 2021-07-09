package by.teachmeskills.mvc.conf;

import by.teachmeskills.mvc.repository.impl.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "by.teachmeskills.mvc.repository", repositoryBaseClass = BaseRepositoryImpl.class)
public class PersistenceConfig {

}

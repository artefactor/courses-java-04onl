package by.teachmeskills.api.conf;

import by.teachmeskills.api.repository.impl.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "by.teachmeskills.api.repository", repositoryBaseClass = BaseRepositoryImpl.class)
public class PersistenceConfig {

}

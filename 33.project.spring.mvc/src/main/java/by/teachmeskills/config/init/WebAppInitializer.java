package by.teachmeskills.config.init;

import by.teachmeskills.config.CommonConfig;
import by.teachmeskills.config.PersistenceConfig;
import by.teachmeskills.config.ServiceConfig;
import by.teachmeskills.config.WebAppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
            ServiceConfig.class,
            CommonConfig.class,
            PersistenceConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
            WebAppConfig.class,
			CommonConfig.class,
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

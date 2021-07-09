package by.teachmeskills.api.conf;

import by.teachmeskills.api.resource.product.ProductResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ProductResource.class);
    }

}

package by.train.model;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class LionFactoryBean implements FactoryBean<Lion> {
	@Override
	public Lion getObject() throws Exception {
		// complex logic
		return new Lion();
	}

	@Override
	public Class<Lion> getObjectType() {
		return Lion.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}

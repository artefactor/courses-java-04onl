package by.train.springprototype;

public abstract class ApplicationContextProto {

	public abstract int getBeanDefinitionCount();

	public abstract String[] getBeanDefinitionNames();

	public abstract <T> T getBean(Class<T> requredClass);
}

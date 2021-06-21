package by.tms.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
	@Autowired
	ApplicationContext context;

	public String doService() {
		return "value from service:" + ", " + context;
	}

	public int count() {
		return context.getBeanDefinitionCount();
	}

	public String[] list() {
		return context.getBeanDefinitionNames();
	}
}

package by.train.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Zoo {
	@Autowired
	@Qualifier ("dogAnimal")
	Animal animal;

	@Autowired
	Environment enviornment;


}

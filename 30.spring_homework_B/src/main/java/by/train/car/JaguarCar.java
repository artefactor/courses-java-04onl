package by.train.car;

import by.train.animal.model.rare.Jaguar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JaguarCar {


	private Object logo;

	public Object getLogo() {
		return logo;
	}

@Autowired
	public void setLogo(Jaguar logo) {
		this.logo = logo;
	}
}

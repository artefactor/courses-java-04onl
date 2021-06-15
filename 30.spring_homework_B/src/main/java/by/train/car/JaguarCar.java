package by.train.car;

import by.train.animal.model.rare.Jaguar;
import by.train.living.model.LivingCreature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JaguarCar {

	private Object logo;

	public Object getLogo() {
		return logo;
	}

	@Autowired
	@Qualifier("jaguar")
	public void setLogo(Jaguar logo) {
		this.logo = logo;
	}
}

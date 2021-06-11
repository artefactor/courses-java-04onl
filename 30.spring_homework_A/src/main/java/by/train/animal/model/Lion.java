package by.train.animal.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Lion extends Animal {
	private boolean hungry = true;

	@Value("${age}")
	int age;

	public int getAge() {
		return age;
	}

	@Override
	public void eat(Meat meat) {
		// ест 10 кг первый раз, второй раз уже не может
		if (!hungry) {
			throw new UnsupportedOperationException("I am not hungry");
		}
		meat.setAmount(meat.getAmount() - 10);
		hungry = false;
	}
}

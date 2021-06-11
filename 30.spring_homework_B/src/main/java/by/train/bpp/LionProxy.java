package by.train.bpp;

import by.train.animal.model.Animal;
import by.train.animal.model.Lion;
import by.train.animal.model.Meat;
import by.train.living.model.LivingCreature;

public class LionProxy extends Lion {

	private final Lion target;

	public LionProxy(Lion target) {
		this.target = target;
	}

	@Override
	public void eat(Meat meat) {
		try {
			target.eat(meat);
		} catch (Exception e) {
			System.out.println("ignore exception during eat. " + e);
		}
	}

	// TODO что-то пропущено
}

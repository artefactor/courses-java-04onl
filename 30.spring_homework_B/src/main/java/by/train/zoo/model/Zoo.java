package by.train.zoo.model;

import by.train.living.model.LivingCreature;

import java.util.ArrayList;
import java.util.List;

//TODO здесь ничего изменять не нужно. Реализуйте конфинг через java-config
public class Zoo {

	private List<LivingCreature> animals = new ArrayList<>();

	public List<LivingCreature> getAnimals() {
		return animals;
	}

	public void addAnimal(LivingCreature creature) {
		animals.add(creature);
	}


}

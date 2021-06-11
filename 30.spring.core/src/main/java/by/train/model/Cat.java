package by.train.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Cat implements Animal {

//	Intrenationonlization i18n;

	public Cat(Food food/*, Intrenationonlization i18n*/) {
		this.food = food;
//		this.i18n = i18n;
	}


	@PostConstruct
	public void init(){
//		i18n.getMessage("");
		System.out.println("post counstruct ");
	}


	Food food;

	public void setFood(Food food) {
		this.food = food;
	}

	public Food getFood() {
		return food;
	}

	public void eat() {
		System.out.println("I am eating: " + food);
	}
}

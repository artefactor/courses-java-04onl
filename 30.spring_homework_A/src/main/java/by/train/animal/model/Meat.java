package by.train.animal.model;

import org.springframework.stereotype.Component;


public class Meat {
	private int amount;

	public Meat(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}

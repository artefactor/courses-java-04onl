package by.train.bpp;

import by.train.animal.model.Animal;
import by.train.animal.model.Lion;
import by.train.animal.model.Meat;
import by.train.living.model.LivingCreature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class LionProxy extends Lion {


    private Lion target;


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

    @Override
    public int getAge() {
        return target.getAge();
    }
    // TODO что-то пропущено
}

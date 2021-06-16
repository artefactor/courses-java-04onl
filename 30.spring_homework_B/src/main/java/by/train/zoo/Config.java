package by.train.zoo;

import by.train.living.model.LivingCreature;
import by.train.zoo.model.Zoo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;


@Configuration
public class Config {
    @Bean
    Zoo zoo(ApplicationContext context) {
        Collection<LivingCreature> values = null;
        /**
         *  TODO здесь нужно как-то получить все бины типа LivingCreature из contextа
         */
        values = context.getBeansOfType(LivingCreature.class).values();


        Zoo zoo = new Zoo();
        values.forEach(r -> zoo.addAnimal(r));
        return zoo;
    }


}

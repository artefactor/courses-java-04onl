package by.train.car;

import by.train.animal.model.rare.Jaguar;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//TODO подключить компонент и дописать нужные аннотации
//TODO реализовать интерфейс FactoryBean

@Component
public class JaguarFactoryBean implements FactoryBean<JaguarCar> {


    @Override
    public JaguarCar getObject() throws Exception {
        return new JaguarCar();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}

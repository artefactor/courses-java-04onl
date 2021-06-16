package by.train.car;

import by.train.animal.model.rare.Jaguar;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

//TODO подключить компонент и дописать нужные аннотации
//TODO реализовать интерфейс FactoryBean

@Component
public class JaguarFactoryBean implements FactoryBean<Jaguar> {


    @Override
    public Jaguar getObject() throws Exception {
        return new Jaguar();
    }

    @Override
    public Class<?> getObjectType() {
        return Jaguar.class;
    }
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}

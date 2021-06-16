package by.train.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//TODO подключить компонент и дописать нужные аннотации
@Component
@Scope("prototype")
public class Firefox {

    private Object logo;

    public Object getLogo() {
        return logo;
    }

    @Autowired
    @Qualifier("fox")
    public void setLogo(Object logo) {
        this.logo = logo;
    }

}

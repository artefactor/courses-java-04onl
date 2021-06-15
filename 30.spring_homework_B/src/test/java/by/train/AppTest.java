package by.train;

import by.train.animal.model.Fox;
import by.train.animal.model.Meat;
import by.train.animal.model.rare.Jaguar;
import by.train.animal.model.Lion;
import by.train.animal.model.Wolf;
import by.train.bpp.PostProcessorConfig;
import by.train.browser.Firefox;
import by.train.car.JaguarCar;
import by.train.os.Linux;
import by.train.os.model.Penguin;
import by.train.zoo.model.Zoo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/* TODO commit under branch
	task-spring-core-surname-name
 */
public class AppTest {

    ApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    public void firefox_annotationConfig() {
        Firefox firefox = context.getBean(Firefox.class);

        assertTrue(firefox.getLogo() instanceof Fox);
    }

    @Test
    public void linux_xmlConfig() {
        Linux os = context.getBean(Linux.class);
        assertTrue(os.getLogo() instanceof Penguin);
    }

    @Test
    public void jaguar_factoryBean() {
        JaguarCar car = context.getBean(JaguarCar.class);
        assertTrue(car.getLogo() instanceof Jaguar);
    }

    @Test
    public void zoo_BeansOfType() {
        Zoo os = context.getBean(Zoo.class);
        assertEquals(4, os.getAnimals().size());
    }

    @Test
    public void scope() {
        Firefox firefox1 = context.getBean(Firefox.class);
        Firefox firefox2 = context.getBean(Firefox.class);
        Fox fox1 = context.getBean(Fox.class);
        Fox fox2 = context.getBean(Fox.class);

        assertEquals(fox1, fox2);
        assertSame(fox1, fox2);
        assertNotEquals(firefox1, firefox2);
    }


    @Test
    public void properties() {
        assertEquals("expectedReadedValue",
                context.getEnvironment().getProperty("prop"));

        Lion lion = context.getBean(Lion.class);
        assertEquals(20, lion.getAge());
    }


}
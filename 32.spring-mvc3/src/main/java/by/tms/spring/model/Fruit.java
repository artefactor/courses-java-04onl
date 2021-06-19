package by.tms.spring.model;

import java.io.Serializable;

/**
 *
 */
public class Fruit implements Serializable {
    public String name;
    public Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

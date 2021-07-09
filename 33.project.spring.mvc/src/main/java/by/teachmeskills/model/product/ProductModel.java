package by.teachmeskills.model.product;

import by.teachmeskills.model.AbstractModel;

public class ProductModel extends AbstractModel {

    private String title;
    private String description;
    private double price;

    public ProductModel() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

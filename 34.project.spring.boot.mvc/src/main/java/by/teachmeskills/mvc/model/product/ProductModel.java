package by.teachmeskills.mvc.model.product;

import by.teachmeskills.mvc.model.AbstractModel;

public class ProductModel extends AbstractModel {

    private String title;
    private String description;
    private double price;

    public ProductModel() {}

    public ProductModel(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

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

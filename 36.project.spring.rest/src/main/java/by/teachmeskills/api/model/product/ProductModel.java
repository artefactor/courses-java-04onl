package by.teachmeskills.api.model.product;

import by.teachmeskills.api.model.AbstractModel;
import by.teachmeskills.api.validator.ValidProductPrice;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductModel extends AbstractModel {

    @NotBlank(message = "{product.title.not.empty}")
    private String title;
    @NotBlank
    private String description;
    @NotNull
    @Min(0)
    @ValidProductPrice(min = 50)
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

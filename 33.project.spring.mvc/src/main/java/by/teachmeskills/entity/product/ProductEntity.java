package by.teachmeskills.entity.product;

import static by.teachmeskills.dao.query.product.ProductJPQLQueries.GET_BY_TITLE;
import static by.teachmeskills.dao.query.product.ProductJPQLQueries.GET_BY_TITLE_NAME;


import by.teachmeskills.entity.AbstractEntity;
import by.teachmeskills.entity.order.OrderEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
    @NamedQuery(name = GET_BY_TITLE_NAME, query = GET_BY_TITLE)
})
public class ProductEntity extends AbstractEntity {

    @NotEmpty
    private String title;
    private String description;
    @Min(0)
    private double price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_products", joinColumns = {
        @JoinColumn(name = "product_id_fk", referencedColumnName = "id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "order_id_fk", referencedColumnName = "id")
    })
    private List<OrderEntity> orders;

    public ProductEntity() {}

    public ProductEntity(String title, String description, double price) {
        super();
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public ProductEntity(Long id, String title, String description, double price, Long timestamp) {
        super(id, timestamp);
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

    public List<OrderEntity> getOrders() {
        return new ArrayList<>(orders);
    }
}

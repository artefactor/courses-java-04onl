package by.teachmeskills.api.entity.order;

import by.teachmeskills.api.entity.AbstractEntity;
import by.teachmeskills.api.entity.client.ClientEntity;
import by.teachmeskills.api.entity.product.ProductEntity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class OrderEntity extends AbstractEntity {

    @Column(name = "total_price")
    private double totalPrice;

    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id_fk", referencedColumnName = "id")
    private ClientEntity client;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_products", joinColumns = {
        @JoinColumn(name = "order_id_fk", referencedColumnName = "id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "product_id_fk", referencedColumnName = "id")
    })
    private List<ProductEntity> products;

    public OrderEntity() {}

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public List<ProductEntity> getProducts() {
        return new ArrayList<>(products);
    }
}

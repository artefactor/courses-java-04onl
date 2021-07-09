package by.teachmeskills.api.entity.order.product;

import by.teachmeskills.api.entity.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "orders_products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class OrderProductEntity extends AbstractEntity {

    @Column(name = "order_id_fk")
    private Long orderId;

    @Column(name = "product_id_fk")
    private Long productId;

    public OrderProductEntity() {}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}

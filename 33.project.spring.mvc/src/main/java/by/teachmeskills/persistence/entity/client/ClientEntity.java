package by.teachmeskills.persistence.entity.client;

import by.teachmeskills.persistence.entity.AbstractEntity;
import by.teachmeskills.persistence.entity.address.AddressEntity;
import by.teachmeskills.persistence.entity.order.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ClientEntity extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id_fk", referencedColumnName = "id")
    private AddressEntity address;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id_fk", referencedColumnName = "id")
    private List<OrderEntity> orders;

    public ClientEntity() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<OrderEntity> getOrders() {
        return new ArrayList<>(orders);
    }
}

package by.teachmeskills.api.entity.address;

import by.teachmeskills.api.entity.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AddressEntity extends AbstractEntity {

    private String city;
    private String street;
    private String house;
    private String apartment;

    public AddressEntity() {}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}

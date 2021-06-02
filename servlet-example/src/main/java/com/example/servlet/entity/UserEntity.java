package com.example.servlet.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

//TODO extend AbstractEntity
public class UserEntity implements IEntity {

    private List<ProductEntity> productEntities;

    public List<ProductEntity> getProductEntities() {
        return productEntities;
    }
}

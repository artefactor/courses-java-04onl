package by.tms.spring.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    private String name;
    private Character gender;

    public Student() {
    }

    public Student(Integer id, String name, Character gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    // standard getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }
}
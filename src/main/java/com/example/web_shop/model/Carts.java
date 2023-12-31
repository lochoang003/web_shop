package com.example.web_shop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carts {
    @Id
    private  int id;
    private String name;

    public Carts() {
    }

    public Carts(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

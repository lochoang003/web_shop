package com.example.web_shop.model;

import javax.persistence.*;

@Entity
public class CartProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "carts_id")
    private Carts carts;
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products products;

    public CartProducts() {
    }

    public CartProducts(int id, Carts carts, Products products) {
        this.id = id;
        this.carts = carts;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Carts getCarts() {
        return carts;
    }

    public void setCarts(Carts carts) {
        this.carts = carts;
    }
}

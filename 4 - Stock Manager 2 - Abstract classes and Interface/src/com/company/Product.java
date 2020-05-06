package com.company;

public abstract class Product {
    private Integer price;

    public Product(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}

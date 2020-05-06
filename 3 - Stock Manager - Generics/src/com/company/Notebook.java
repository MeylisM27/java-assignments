package com.company;

public class Notebook extends Product {
    private Integer numberOfPages;

    public Notebook(Integer price, Integer numberOfPages) {
        super(price);
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + getPrice() +
                ",numberOfPages=" + numberOfPages +
                "} ";
    }
}


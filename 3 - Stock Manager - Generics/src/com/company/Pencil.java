package com.company;

public class Pencil extends Product{
    private String color;

    public Pencil(Integer price, String color) {
        super(price);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pencil{" +
                "price=" + getPrice() +
                ",color='" + color + '\'' +
                "} ";
    }
}

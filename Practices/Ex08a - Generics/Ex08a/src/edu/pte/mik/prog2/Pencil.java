package edu.pte.mik.prog2;

public class Pencil {
    private String color;
    private String hardness;
    private Integer price;

    public String getColor() {
        return color;
    }

    public String getHardness() {
        return hardness;
    }

    public Integer getPrice() {
        return price;
    }

    public Pencil(String color, String hardness, Integer price) {
        this.color = color;
        this.hardness = hardness;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pencil{" +
                "color='" + color + '\'' +
                ", hardness='" + hardness + '\'' +
                ", price=" + price +
                '}';
    }
}

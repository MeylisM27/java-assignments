package edu.pte.mik.prog2;

public class Glass {
    private String material;
    private String type;
    private Integer price;

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public Glass(String material, String type, Integer price) {
        this.material = material;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Glass{" +
                "material='" + material + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}

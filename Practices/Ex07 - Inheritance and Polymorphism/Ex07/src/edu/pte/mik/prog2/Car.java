package edu.pte.mik.prog2;

public class Car {
    private static int baseRentalFee;
    private static int comfortFee;

    public static int getBaseRentalFee() {
        return baseRentalFee;
    }

    public static void setBaseRentalFee(int baseRentalFee) {
        Car.baseRentalFee = baseRentalFee;
    }

    public static int getComfortFee() {
        return comfortFee;
    }

    public static void setComfortFee(int comfortFee) {
        Car.comfortFee = comfortFee;
    }

    private String license;
    private String make;
    private Integer comfortLevel;

    public String getLicense() {
        return license;
    }

    public String getMake() {
        return make;
    }

    public Integer getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(Integer comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public Car(String license, String make, Integer comfortLevel) {
        this.license = license;
        this.make = make;
        this.comfortLevel = comfortLevel;
    }

    public int getRentalPrice(Integer days) {
        return (baseRentalFee + comfortFee * comfortLevel) * days;
    }

    @Override
    public String toString() {
        return "edu.pte.mik.prog2.Car{" +
                "license='" + license + '\'' +
                ", make='" + make + '\'' +
                ", comfortLevel=" + comfortLevel +
                ", daily rental price=" + getRentalPrice(1) +
                '}';
    }
}

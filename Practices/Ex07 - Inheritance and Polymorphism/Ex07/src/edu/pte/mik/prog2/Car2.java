package edu.pte.mik.prog2;

public class Car2 extends Vehicle2 {
    private static int baseRentalFee;
    private static int comfortFee;

    public static int getBaseRentalFee() {
        return baseRentalFee;
    }

    public static void setBaseRentalFee(int baseRentalFee) {
        Car2.baseRentalFee = baseRentalFee;
    }

    public static int getComfortFee() {
        return comfortFee;
    }

    public static void setComfortFee(int comfortFee) {
        Car2.comfortFee = comfortFee;
    }

    private Integer comfortLevel;

    public Integer getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(Integer comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public Car2(String license, String make, Integer comfortLevel) {
        super(license, make);
        this.comfortLevel = comfortLevel;
    }

    public int getRentalPrice(Integer days) {
        return super.getRentalPrice(days) + (baseRentalFee + comfortFee * comfortLevel) * days;
    }

    @Override
    public String toString() {
        return "edu.pte.mik.prog2.Car{" +
                "license='" + getLicense() + '\'' +
                ", make='" + getMake() + '\'' +
                ", comfortLevel=" + comfortLevel +
                ", daily rental price=" + getRentalPrice(1) +
                '}';
    }
}

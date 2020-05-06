package edu.pte.mik.prog2;

public class Vehicle2 {

    private static int baseRentalFee;

    public static int getBaseRentalFee() {
        return baseRentalFee;
    }

    public static void setBaseRentalFee(int baseRentalFee) {
        Vehicle2.baseRentalFee = baseRentalFee;
    }

    private String license;
    private String make;

    public String getLicense() {
        return license;
    }

    public String getMake() {
        return make;
    }

    public Vehicle2(String license, String make) {
        this.license = license;
        this.make = make;
    }

    public int getRentalPrice(Integer days) {
        return baseRentalFee*days;
    }
}

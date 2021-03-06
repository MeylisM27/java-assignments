package edu.pte.mik.prog2;

public class Bus extends Vehicle {
    /*
    Almost all components were generated by Idea upon request of developer
     */

    private static int baseRentalFee;
    private static int seatFee;

    public static int getBaseRentalFee() {
        return baseRentalFee;
    }

    public static void setBaseRentalFee(int baseRentalFee) {
        Bus.baseRentalFee = baseRentalFee;
    }

    public static int getSeatFee() {
        return seatFee;
    }

    public static void setSeatFee(int seatFee) {
        Bus.seatFee = seatFee;
    }

    private Integer seatCount;

    public Integer getSeatCount() {
        return seatCount;
    }

    public Bus(String license, String make, int seatCount) {
        super(license, make);
        this.seatCount = seatCount;
    }

    public Integer getRentalPrice(Integer days) {
        // static member can be accessed from instance method
        // rental price of ancestor is also used
        // To identify local, instance or static members, check their colors
        return super.getRentalPrice(days) + (baseRentalFee + seatFee * seatCount) * days;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "license='" + getLicense() + '\'' +
                ", make='" + getMake() + '\'' +
                ", seatCount=" + seatCount +
                ", daily rental price=" + getRentalPrice(1) +
                '}';
    }
}

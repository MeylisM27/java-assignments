package edu.pte.mik.prog2;

public class Bus2 extends Vehicle2 {
    private static int baseRentalFee;
    private static int seatFee;

    public static int getBaseRentalFee() {
        return baseRentalFee;
    }

    public static void setBaseRentalFee(int baseRentalFee) {
        Bus2.baseRentalFee = baseRentalFee;
    }

    public static int getSeatFee() {
        return seatFee;
    }

    public static void setSeatFee(int seatFee) {
        Bus2.seatFee = seatFee;
    }

    private int seatCount;

    public int getSeatCount() {
        return seatCount;
    }

    public Bus2(String license, String make, int seatCount) {
        super(license, make);
        this.seatCount = seatCount;
    }

    public int getRentalPrice(Integer days) {
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

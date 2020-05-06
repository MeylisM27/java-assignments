package edu.pte.mik.prog2;

public class Trailer extends Cargo {
    // Class members
    private static int weightFee;

    public static int getWeightFee() {
        return weightFee;
    }

    public static void setWeightFee(int weightFee) {
        Trailer.weightFee = weightFee;
    }

    private static int baseRentalFee;

    public static int getBaseRentalFee() {
        return baseRentalFee;
    }

    public static void setBaseRentalFee(int baseRentalFee) {
        Trailer.baseRentalFee = baseRentalFee;
    }

    // Instance members

    private String brakeType;

    public String getBrakeType() {
        return brakeType;
    }

    public Trailer(String license, String make, int transportableWeight, String brakeType) {
        super(license, make, transportableWeight);
        this.brakeType = brakeType;
    }

    public Integer getRentalPrice(Integer days) {
        // static member can be accessed from instance method
        // rental price of ancestor is also used
        // To identify local, instance or static members, check their colors
        return super.getRentalPrice(days)
                // coefficient of weight fee/50kg has to be rounded up,
                // then converted explicitly back to integer
                + (baseRentalFee + (int)Math.ceil(getTransportableWeight()/50.0) * weightFee) * days;
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "license='" + getLicense() + '\'' +
                ", transportableWeight=" + getTransportableWeight() +
                ", brakeType='" + brakeType + '\'' +
                ", daily rental price=" + getRentalPrice(1) +
                '}';
    }
}

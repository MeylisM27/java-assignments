package edu.pte.mik.prog2;

public class Truck extends Cargo {
    // Class members
    private static int weightFee;

    public static int getWeightFee() {
        return weightFee;
    }

    public static void setWeightFee(int weightFee) {
        Truck.weightFee = weightFee;
    }

    private static int baseRentalFee;

    public static int getBaseRentalFee() {
        return baseRentalFee;
    }

    public static void setBaseRentalFee(int baseRentalFee) {
        Truck.baseRentalFee = baseRentalFee;
    }

    // Instance members

    private double totalWeight;

    public double getTotalWeight() {
        return totalWeight;
    }

    public Truck(String license, String make, int transportableWeight, double totalWeight) {
        super(license, make, transportableWeight);
        this.totalWeight = totalWeight;
    }

    public Integer getRentalPrice(Integer days) {
        // static member can be accessed from instance method
        // rental price of ancestor is also used
        // To identify local, instance or static members, check their colors
        return super.getRentalPrice(days)
                // coefficient of weight fee/100kg has to be rounded up,
                // then converted explicitly back to integer
                + (baseRentalFee + (int)Math.ceil(getTransportableWeight()/100.0) * weightFee) * days;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "license='" + getLicense() + '\'' +
                ", transportableWeight=" + getTransportableWeight() +
                ", totalWeight=" + totalWeight +
                ", daily rental price=" + getRentalPrice(1) +
                '}';
    }
}

package edu.pte.mik.prog2;

/*
Class implements RegisteredForParking interface,
that will be the logical connection to hierarchically independent Vehicle class
 */
public class Crane implements RegisteredForParking {

    // Class members

    private static int baseRentalFee;
    private static int capacityFee;

    public static int getBaseRentalFee() {
        return baseRentalFee;
    }

    public static void setBaseRentalFee(int baseRentalFee) {
        Crane.baseRentalFee = baseRentalFee;
    }

    public static int getCapacityFee() {
        return capacityFee;
    }

    public static void setCapacityFee(int capacityFee) {
        Crane.capacityFee = capacityFee;
    }

    // instance members

    private String identifier;
    private Integer height;
    private Integer carryingCapacity;

    public String getIdentifier() {
        return identifier;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getCarryingCapacity() {
        return carryingCapacity;
    }

    public Crane(String identifier, Integer height, Integer carryingCapacity) {
        this.identifier = identifier;
        this.height = height;
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public String toString() {
        return "Crane{" +
                "identifier='" + identifier + '\'' +
                ", height=" + height +
                ", carryingCapacity=" + carryingCapacity +
                ", daily rental price=" + getRentalPrice(1) +
                '}';
    }

    // Interface member implementations

    public String getLicense() {
        return identifier;
    }

    public Integer getRentalPrice(Integer days) {
        return (baseRentalFee + (capacityFee * (int)Math.ceil(carryingCapacity/500.0))) * days;
    }
}

package edu.pte.mik.prog2;

/*
    This class does not represent objects, but a set of object types.
    It is on higher abstraction level than objects -> abstract object

    Class has to be defined as abstract, to disable instantiation
 */
public abstract class Cargo extends Vehicle {

    /*
    Generic weightFee property of Truck and Trailer would suggest to store in
    ancestor class, but static members are not created for each descendants,
    so ancestor class property cannot store different values of descendant classes
     */

    private Integer transportableWeight;

    public Integer getTransportableWeight() {
        return transportableWeight;
    }

    public Cargo(String license, String make, int transportableWeight) {
        super(license, make);
        this.transportableWeight = transportableWeight;
    }
}

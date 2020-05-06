package edu.pte.mik.prog2;

/*
    This class does not represent objects, but a set of object types.
    It is on higher abstraction level than objects -> abstract object

    Class has to be defined as abstract, to disable instantiation
 */
public abstract class PassengerTransporter extends Vehicle {
    /*
    No generic rental price for passenger transporters,
    no need for static (re)declaration of Vehicle components
     */
    private int transportablePersons;

    public int getTransportablePersons() {
        return transportablePersons;
    }

    public PassengerTransporter(String license, String make, int transportablePersons) {
        super(license, make);
        this.transportablePersons = transportablePersons;
    }
}

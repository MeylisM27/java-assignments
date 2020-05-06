package edu.pte.mik.prog2;

/*
Interface is created to cover independent classes of abstraction hierarchy tree
for generic treatment - store in a generic storage
 */
public interface RegisteredForParking {
    /*
    Current storage uses properties of Vehicle, so they have to be added to the interface
    and new components (Crane) have to be implement them
     */

    String getLicense();

    Integer getRentalPrice(Integer days);
}

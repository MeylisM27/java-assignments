package edu.pte.mik.prog2;

public class Main {

    public static void main(String[] args) {
        SiteTester tester = new SiteTester();

        /*
            Please check handling of generic rental prices in classes by:
                - class (static) data members, getters, setters
                - rental price calculator method (getRentalPrice)
                    + first declaration
                    + overloads
                    + reference to super implementations
         */

        /*
            Testing exercise 1, car storage
            Contains: Car, Storage
         */
        tester.testCars();

        System.out.println("================================");

        /*
            Testing exercise 2, vehicle storage
            Contains: Vehicle2, Car2, Bus2, Site2
            Important remarks:
                - Vehicle can be ancestor of both Car and Bus
                - This Vehicle class is a good type for typed storage
                - cast up is implicit
                - cast down has to be done explicitly, right after type testing
        */
        tester.testVehicles();
    }
}

package edu.pte.mik.prog2;

public class Main {

    public static void main(String[] args) {

        /*
        Data storage class hierarchy:
            - Vehicle
                - PassengerTransporter
                    - Car
                    - Bus
                - Cargo
                    - Truck
                    - Trailer
            - Site
         */

        SiteTester tester = new SiteTester();

        tester.testVehicles();
    }
}

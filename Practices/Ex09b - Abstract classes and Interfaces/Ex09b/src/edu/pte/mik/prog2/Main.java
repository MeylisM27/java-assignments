package edu.pte.mik.prog2;

public class Main {

    public static void main(String[] args) {

        /*
        Data storage class hierarchy:
            - Vehicle [RegisteredForParking]
                - PassengerTransporter
                    - Car
                    - Bus
                - Cargo
                    - Truck
                    - Trailer
            - Crane [RegisteredForParking]
            - Site
         */

        SiteTester tester = new SiteTester();

        tester.testItems();
    }
}

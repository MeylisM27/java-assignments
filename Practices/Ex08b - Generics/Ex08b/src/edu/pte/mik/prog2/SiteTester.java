package edu.pte.mik.prog2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SiteTester {

    public void testVehicles() {
        Site site = new Site("MySite", 6);

    /*
        Have a look at these static methods to figure out what happens here! :)
        Check getRentalPrice method and its overrides
     */

        Vehicle.setBaseRentalFee(5000);
        Car.setBaseRentalFee(2000);
        Car.setComfortFee(1500);
        Bus.setBaseRentalFee(7000);
        Bus.setSeatFee(650);

/* Now we get rid of arrays for good. From now on, we'll use either a List or an ArrayList any time we need storage.
 * These are generic classes just like Storage2 was in the previous example. Unlike static arrays, Lists and ArrayLists
 * can be resized dynamically, whenever it is required.
 */

        site.registerVehicle(
                new Car("asd123", "Dacia", 3)
        );
        site.registerVehicle(
                new Car("vip111", "Bentley", 5)
        );
        site.registerVehicle(
                new Car("gtr357", "Toyota", 4)
        );

        site.registerVehicle(
                new Bus("aaa111", "Ford", 19)
        );
        site.registerVehicle(
                new Bus("bbb222", "Scania", 27)
        );
        site.registerVehicle(
                new Bus("ccc333", "Icarus", 44)
        );

        System.out.println("----------");

/*
 * There's no need to maintain an extra variable that holds the number of elements in our storage. ArrayList<T>.size()
 * solves this. Check out site.getNumberOfVehicles() to see it in action.
 */
        for (int i = 0; i < site.getNumberOfVehicles(); i++) {
            System.out.println(site.getVehicle(i));
        }

        System.out.println("----------");

        Vehicle vehicleByLicense = site.findVehicle("vip111");

        if(vehicleByLicense != null) {
            System.out.println(vehicleByLicense);
            System.out.println("Rental price for 3 days: " + vehicleByLicense.getRentalPrice(3));
        }

        System.out.println("----------");

/*
 * We create an ArrayList of cars here. Investigate how instanceof helps solving this in site.findCars().
 */
        ArrayList<Car> carsFound = site.findCars(4);

        carsFound.sort(
                Comparator.comparing(Car::getComfortLevel)
        );

        for (Car c : carsFound) {
            System.out.println(c);
            System.out.println("Rental price for 3 days: " + c.getRentalPrice(3));
        }

        System.out.println("----------");

/*
 * We create an ArrayList of buses here. Investigate how instanceof helps solving this in site.findBuses().
 */
        ArrayList<Bus> busesFound = site.findBuses(25);

        busesFound.sort(
                Collections.reverseOrder(
                        Comparator.comparing(Bus::getSeatCount)
                )
        );

        for (Bus b : busesFound) {
            System.out.println(b);
            System.out.println("Rental price for 3 days: " + b.getRentalPrice(3));
        }

        System.out.println("----------");

        site.orderByLicense();
        for (int i = 0; i < site.getNumberOfVehicles(); i++) {
            System.out.println(site.getVehicle(i));
        }

        System.out.println("----------");

        site.orderByRentalPrice();
        for (int i = 0; i < site.getNumberOfVehicles(); i++) {
            System.out.println(site.getVehicle(i));
        }

        System.out.println("----------");
    }
}

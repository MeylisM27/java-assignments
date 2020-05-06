package edu.pte.mik.prog2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SiteTester {

    // Site to be tested is stored in an instance member
    private Site site;

    public void testVehicles() {

        // Test method is splitted into functional parts
        // implemented in private instance methods

        setPrices();

        createSite();

        registerVehicles();

        printVehicles();

        printVehiclesByLicense();

        findCarsByComfortLevel();

        findBusesBySeatCount();

        System.out.println("---------- Sorting vehicles by license");
        site.orderByLicense();
        printVehicles();

        System.out.println("---------- Sorting vehicles by rental price");
        site.orderByRentalPrice();
        printVehicles();

        printCargos();
    }

    private void setPrices() {
        /*
        Have a look at these static methods to figure out what happens here! :)
        Check getRentalPrice method and its overrides
     */

        Vehicle.setBaseRentalFee(5000);

        Car.setBaseRentalFee(2000);
        Car.setComfortFee(1500);

        Bus.setBaseRentalFee(7000);
        Bus.setSeatFee(650);

        Truck.setBaseRentalFee(5000);
        Truck.setWeightFee(800);

        Trailer.setBaseRentalFee(500);
        Trailer.setWeightFee(1200);
    }

    private void createSite() {
        // In such a way, many sites can be created
        // (if the company has more)
        site = new Site("MySite", 8);
        site.setMaxVehicleCount(12);
    }

    private void registerVehicles() {

        System.out.println("---------- Register vehicles");

        /* Now we get rid of arrays for good. From now on, we'll use either a List or an ArrayList any time we need storage.
         * These are generic classes just like Storage2 was in the previous example. Unlike static arrays, Lists and ArrayLists
         * can be resized dynamically, whenever it is required.
         */

        // Cars

        site.registerVehicle(
                new Car("asd123", "Dacia", 5, 3)
        );
        site.registerVehicle(
                new Car("vip111", "Bentley", 4,  5)
        );
        site.registerVehicle(
                new Car("gtr357", "Toyota", 5, 4)
        );

        // Buses

        site.registerVehicle(
                new Bus("aaa111", "Ford", 19, 19)
        );
        site.registerVehicle(
                new Bus("vip222", "Scania", 27, 27)
        );
        site.registerVehicle(
                new Bus("ccc333", "Icarus", 120, 44)
        );

        // Trucks

        site.registerVehicle(
                new Truck("cgo111", "MAN", 900, 2400)
        );
        site.registerVehicle(
                new Truck("vip333", "Volvo", 1300, 3000)
        );
        site.registerVehicle(
                new Truck("cgo333", "Iveco", 1800, 3300)
        );

        // Trailers

        site.registerVehicle(
                new Trailer("xxx111", "Humbaur", 150, "None")
        );
        site.registerVehicle(
                new Trailer("xxx222", "Stema", 200, "Mechanic")
        );
        site.registerVehicle(
                new Trailer("xxx333", "Brenderup", 1600, "Hydraulic")
        );
    }

    private void printVehicles() {

        System.out.println("---------- Print vehicles");

        /*
         * There's no need to maintain an extra variable that holds the number of elements in our storage. ArrayList<T>.size()
         * solves this. Check out site.getNumberOfVehicles() to see it in action.
         */

        for (int i = 0; i < site.getNumberOfVehicles(); i++) {
            System.out.println(site.getVehicle(i));
        }
    }

    private void printVehiclesByLicense() {
        System.out.println("---------- Print vehicles by license");

        ArrayList<Vehicle> vehiclesByLicense = site.findVehicles("vip");

        for(Vehicle v : vehiclesByLicense) {
            System.out.println(v);
            System.out.println("Rental price for 3 days: " + v.getRentalPrice(3));
        }
    }

    private void findCarsByComfortLevel() {

        System.out.println("---------- Find cars by comfort level");

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
    }

    private void findBusesBySeatCount() {

        System.out.println("---------- Find buses by seat count");

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
    }

    private void printCargos() {
        System.out.println("---------- Print cargos in DESCENDING order by transportable weight ");

        // foreach loops through returned ArrayList
        for(Cargo c : site.getCargos()) {
            System.out.println(c);
        }
    }
}

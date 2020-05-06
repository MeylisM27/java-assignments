package edu.pte.mik.prog2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SiteTester {

    // Site to be tested is stored in an instance member
    private Site site;

    public void testItems() {

        // Test method is splitted into functional parts
        // implemented in private instance methods

        setPrices();

        createSite();

        site.setMaxItemCount(16);

        registerItems();

        printItems();

        printItemsByIdentifier();

        findCarsByComfortLevel();

        findBusesBySeatCount();

        System.out.println("---------- Sorting vehicles by license");
        site.orderByLicense();
        printItems();

        System.out.println("---------- Sorting vehicles by rental price");
        site.orderByRentalPrice();
        printItems();

        printCargos();

        findCranesByHeightAndCapacity();
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

        Crane.setBaseRentalFee(40000);
        Crane.setCapacityFee(12000);
    }

    private void createSite() {
        // In such a way, many sites can be created
        // (if the company has more)
        site = new Site("MySite", 8);
        site.setMaxItemCount(12);
    }

    private void registerItems() {

        System.out.println("---------- Register vehicles");

        /* Now we get rid of arrays for good. From now on, we'll use either a List or an ArrayList any time we need storage.
         * These are generic classes just like Storage2 was in the previous example. Unlike static arrays, Lists and ArrayLists
         * can be resized dynamically, whenever it is required.
         */

        // Cars

        site.registerItem(
                new Car("asd123", "Dacia", 5, 3)
        );
        site.registerItem(
                new Car("vip111", "Bentley", 4,  5)
        );
        site.registerItem(
                new Car("gtr357", "Toyota", 5, 4)
        );

        // Buses

        site.registerItem(
                new Bus("aaa111", "Ford", 19, 19)
        );
        site.registerItem(
                new Bus("vip222", "Scania", 27, 27)
        );
        site.registerItem(
                new Bus("ccc333", "Icarus", 120, 44)
        );

        // Trucks

        site.registerItem(
                new Truck("cgo111", "MAN", 900, 2400)
        );
        site.registerItem(
                new Truck("vip333", "Volvo", 1300, 3000)
        );
        site.registerItem(
                new Truck("cgo333", "Iveco", 1800, 3300)
        );

        // Trailers

        site.registerItem(
                new Trailer("xxx111", "Humbaur", 150, "None")
        );
        site.registerItem(
                new Trailer("xxx222", "Stema", 200, "Mechanic")
        );
        site.registerItem(
                new Trailer("vip444", "Brenderup", 1600, "Hydraulic")
        );

        // Cranes
        site.registerItem(
                new Crane("vip-cr-001", 6, 1000)
        );
        site.registerItem(
                new Crane("cr-002", 4, 800)
        );
        site.registerItem(
                new Crane("cr-h-001", 30, 2000)
        );
    }

    private void printItems() {

        System.out.println("---------- Print vehicles");

        /*
         * There's no need to maintain an extra variable that holds the number of elements in our storage. ArrayList<T>.size()
         * solves this. Check out site.getNumberOfVehicles() to see it in action.
         */

        for (int i = 0; i < site.getNumberOfItems(); i++) {
            System.out.println(site.getItem(i));
        }
    }

    private void printItemsByIdentifier() {
        System.out.println("---------- Print items by identifier");

        ArrayList<RegisteredForParking> itemsByIdentifier = site.findItems("vip");

        // itemsByIdentifier is an instance of ArrayList<RegisteredForParking>
        // therefore the following line will print out all items stored in the array
        printList(itemsByIdentifier);

        // this line also can be used if printList has been removed
        // genericPrintList(itemsByIdentifier);
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

        // carsFound cannot be converted to ArrayList<RegisteredForParking>
        // because type cast would change type of outer class (ArrayList)
        // not type parameter of ArrayList (Car)
        // therefore the following line results a compilation error
        // printList(carsFound);      // compilation error
        genericPrintList(carsFound);
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

        genericPrintList(busesFound);
    }

    private void printCargos() {
        System.out.println("---------- Print cargos in DESCENDING order by transportable weight ");

        // site.getCargos() cannot be converted to ArrayList<RegisteredForParking>
        // because type cast would change type of outer class (ArrayList)
        // not type parameter of ArrayList (Cargo)
        // therefore the following line results a compilation error
        // printList(site.getCargos());      // compilation error
        genericPrintList(site.getCargos());
    }

    private void findCranesByHeightAndCapacity() {
        System.out.println("---------- Find cranes by height and capacity");

        /*
         * We create an ArrayList of cranes here.
         * Investigate how instanceof helps solving this in site.findCranes().
         */
        ArrayList<Crane> cranesFound = site.findCranes(5, 500);

        // cranesFound cannot be converted to ArrayList<RegisteredForParking>
        // because type cast would change type of outer class (ArrayList)
        // not type parameter of ArrayList (Crane)
        // therefore the following line results a compilation error
        // printList(cranesFound);      // compilation error
        genericPrintList(cranesFound);
    }

    // Trying to list items of a common type (actually and interface)
    private void printList(ArrayList<RegisteredForParking> list) {
        for (RegisteredForParking i : list) {
            System.out.println(i);
            System.out.println("Rental price for 3 days: " + i.getRentalPrice(3));
        }
    }

    // generic method can be used to cast type parameter of a generic class
    // such a solution helps to reduce number of code lines
    // not to duplicate item listing
    private <T extends RegisteredForParking> void genericPrintList(ArrayList<T> list) {
        for (T i : list) {
            System.out.println(i);
            System.out.println("Rental price for 3 days: " + i.getRentalPrice(3));
        }
    }
}

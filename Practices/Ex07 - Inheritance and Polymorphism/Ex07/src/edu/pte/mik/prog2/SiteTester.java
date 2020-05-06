package edu.pte.mik.prog2;

public class SiteTester {
    public void testCars() {
        Site site = new Site("MySite", 5);

        Car.setBaseRentalFee(7000);
        Car.setComfortFee(1500);

        site.registerCar(
                new Car("asd123", "Dacia", 3)
        );
        site.registerCar(
                new Car("vip111", "Bentley", 5)
        );
        site.registerCar(
                new Car("gtr357", "Toyota", 4)
        );

        for (int i = 0; i < site.getNumberOfCars(); i++) {
            System.out.println(site.getCar(i));
        }

        System.out.println("----------");

        Car carByLicense = site.findCar("vip111");

        if(carByLicense != null) {
            System.out.println(carByLicense);
            System.out.println("Rental price for 3 days: " + carByLicense.getRentalPrice(3));
        }

        System.out.println("----------");

        for (Car c : site.findCars(4)) {
            if(c != null) {
                System.out.println(c);
                System.out.println("Rental price for 3 days: " + c.getRentalPrice(3));
            }
        }

        System.out.println("----------");
    }

    public void testVehicles() {
        Site2 site = new Site2("MySite", 6);

        Vehicle2.setBaseRentalFee(5000);
        Car2.setBaseRentalFee(2000);
        Car2.setComfortFee(1500);
        Bus2.setBaseRentalFee(7000);
        Bus2.setSeatFee(650);

        site.registerVehicle(
                new Car2("asd123", "Dacia", 3)
        );
        site.registerVehicle(
                new Car2("vip111", "Bentley", 5)
        );
        site.registerVehicle(
                new Car2("gtr357", "Toyota", 4)
        );

        site.registerVehicle(
                new Bus2("aaa111", "Ford", 19)
        );
        site.registerVehicle(
                new Bus2("bbb222", "Scania", 27)
        );
        site.registerVehicle(
                new Bus2("ccc333", "Icarus", 44)
        );

        for (int i = 0; i < site.getNumberOfVehicles(); i++) {
            System.out.println(site.getVehicle(i));
        }

        System.out.println("----------");

        Vehicle2 vehicleByLicense = site.findVehicle("vip111");

        if(vehicleByLicense != null) {
            System.out.println(vehicleByLicense);
            System.out.println("Rental price for 3 days: " + vehicleByLicense.getRentalPrice(3));
        }

        System.out.println("----------");

        for (Car2 c : site.findCars(4)) {
            if(c != null) {
                System.out.println(c);
                System.out.println("Rental price for 3 days: " + c.getRentalPrice(3));
            }
        }

        System.out.println("----------");

        for (Bus2 b : site.findBuses(25)) {
            if(b != null) {
                System.out.println(b);
                System.out.println("Rental price for 3 days: " + b.getRentalPrice(3));
            }
        }

        System.out.println("----------");
    }
}

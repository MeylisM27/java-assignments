package edu.pte.mik.prog2;

public class Site2 {
    private String name;
    private Vehicle2[] vehicles;
    private Integer numberOfVehicles;

    public String getName() {
        return name;
    }

    public Integer getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public Vehicle2 getVehicle(Integer index) {
        if(index >= 0 && index < numberOfVehicles)
            return vehicles[index];
        else
            return null;
    }

    public Site2(String name, Integer vehicleCount) {
        this.name = name;
        vehicles = new Vehicle2[vehicleCount];
        numberOfVehicles = 0;
    }

    public void registerVehicle(Vehicle2 newVehicle) {
        if(numberOfVehicles < vehicles.length) {
            vehicles[numberOfVehicles++] = newVehicle;
        }
        else {
            System.out.println("Can not register more cars!");
        }
    }

    public Vehicle2 findVehicle(String license) {
        for (int i = 0; i < numberOfVehicles; i++) {
            if(vehicles[i].getLicense().equalsIgnoreCase(license)) {
                return vehicles[i];
            }
        }
        return null;
    }

    public Car2[] findCars(Integer comfortLevel) {
        Car2[] found = new Car2[numberOfVehicles];
        int carsFound = 0;
        for (int i = 0; i < numberOfVehicles; i++) {
            if(vehicles[i] instanceof Car2 && ((Car2)vehicles[i]).getComfortLevel() >= comfortLevel) {
                found[carsFound++] = (Car2)vehicles[i];
            }
        }
        return found;
    }

    public Bus2[] findBuses(Integer seatCount) {
        Bus2[] found = new Bus2[numberOfVehicles];
        int busesFound = 0;
        for (int i = 0; i < numberOfVehicles; i++) {
            if(vehicles[i] instanceof Bus2 && ((Bus2)vehicles[i]).getSeatCount() >= seatCount) {
                found[busesFound++] = (Bus2)vehicles[i];
            }
        }
        return found;
    }
}

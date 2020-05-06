package edu.pte.mik.prog2;

public class Site {
    private String name;
    private Car[] cars;
    private Integer numberOfCars;

    public String getName() {
        return name;
    }

    public Integer getNumberOfCars() {
        return numberOfCars;
    }

    public Car getCar(Integer index) {
        if(index >= 0 && index < numberOfCars)
            return cars[index];
        else
            return null;
    }

    public Site(String name, Integer carCount) {
        this.name = name;
        cars = new Car[carCount];
        numberOfCars = 0;
    }

    public void registerCar(Car newCar) {
        if(numberOfCars < cars.length) {
            cars[numberOfCars++] = newCar;
        }
        else {
            System.out.println("Can not register more cars!");
        }
    }

    public Car findCar(String license) {
        for (int i = 0; i < numberOfCars; i++) {
            if(cars[i].getLicense().equalsIgnoreCase(license)) {
                return cars[i];
            }
        }
        return null;
    }

    public Car[] findCars(Integer comfortLevel) {
        Car[] found = new Car[numberOfCars];
        int carsFound = 0;
        for (int i = 0; i < numberOfCars; i++) {
            if(cars[i].getComfortLevel() >= comfortLevel) {
                found[carsFound++] = cars[i];
            }
        }
        return found;
    }
}

package edu.pte.mik.prog2;

import java.util.ArrayList;
import java.util.Comparator;

public class Site {
    private String name;

    // For storage, an instance of generic ArrayList is used
    // but exactly created to handle Vehicle instances (or converted to Vehicle)
    private ArrayList<Vehicle> vehicles;
    private Integer maxVehicleCount;

    public String getName() {
        return name;
    }

    public Integer getNumberOfVehicles() {
        return vehicles.size();
    }

    public Integer getMaxVehicleCount() {
        return maxVehicleCount;
    }

    public Vehicle getVehicle(Integer index) {
        // Check index before using it to access an element
        if(index >= 0 && index < vehicles.size())
            return vehicles.get(index);
        else
            return null;
    }

    public Site(String name, Integer maxVehicleCount) {
        this.name = name;
        vehicles = new ArrayList<>();
        this.maxVehicleCount = maxVehicleCount;
    }

    public void registerVehicle(Vehicle newVehicle) {
        // Check number of registered vehicles
        // to avoid overbooking
        if(vehicles.size() < maxVehicleCount) {
            vehicles.add(newVehicle);
        }
        else {
            System.out.println("Can not register more cars!");
        }
    }

    public Vehicle findVehicle(String license) {
        for(Vehicle v : vehicles) {
            // Comparing String licences ignoring case
            if(v.getLicense().equalsIgnoreCase(license)) {
                return v;
            }
        }
        return null;
    }

    public ArrayList<Car> findCars(Integer comfortLevel) {
        ArrayList<Car> found = new ArrayList<>();
        for(Vehicle v : vehicles) {
/**
 * See? We use only those Vehicles that are also Cars. Not a single Bus may pass here :)
 */
            if(v instanceof Car && ((Car)v).getComfortLevel() >= comfortLevel) {
                found.add((Car)v);
            }
        }
        return found;
    }

    public ArrayList<Bus> findBuses(Integer seatCount) {
        ArrayList<Bus> found = new ArrayList<>();
        for(Vehicle v : vehicles) {
/**
 * See? We use only those Vehicles that are also Buses. Not a single Car may pass here :)
 */
            if(v instanceof Bus && ((Bus)v).getSeatCount() >= seatCount) {
                found.add((Bus)v);
            }
        }
        return found;
    }

    public void orderByLicense() {
        // Comparator is specified by a lambda with 2 parameters
        Comparator<Vehicle> c = (s1, s2) -> s1.getLicense().compareToIgnoreCase(s2.getLicense());
        vehicles.sort(c);
    }

    public void orderByRentalPrice() {
        // Comparator.comparing uses lambda with 1 parameter on both objects
        // to get their comparable values
        vehicles.sort(
                Comparator.comparing(s -> s.getRentalPrice(1))
        );
    }
}

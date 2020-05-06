package edu.pte.mik.prog2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Site {
    private String name;

    // For storage, an instance of generic ArrayList is used
    // but exactly created to handle Vehicle instances (or converted to Vehicle)
    // Vehicle, PersonalTransporter and Cargo classes can not be instantiated
    // therefore only Car, Bus, Truck and Trailer objects can be places in the storage
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

    /*
    Only increase of storage space is allowed (controlled state change)
     */
    public void setMaxVehicleCount(Integer maxVehicleCount) {
        if(maxVehicleCount > this.maxVehicleCount) {
            this.maxVehicleCount = maxVehicleCount;
        }
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
        // type parameter can be omitted (derived from declaration)
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
            System.out.println("Can not register more vehicles!");
        }
    }

    /*
    Partial license based search works with full license also
     */
    public ArrayList<Vehicle> findVehicles(String license) {
        ArrayList<Vehicle> found = new ArrayList<>();
        for(Vehicle v : vehicles) {
            // Checking if String license haystack contains needle string ignoring case
            if(v.getLicense().toLowerCase().contains(license.toLowerCase())) {
                found.add(v);
            }
        }

        //Defining a comparator for sorting Vehicle items
        //Comparator<Vehicle> comparator = (Vehicle v1, Vehicle v2) -> v1.getLicense().compareTo(v2.getLicense())
        //Can be written in a simpler way
        Comparator<Vehicle> comparator = Comparator.comparing(Vehicle::getLicense);

        found.sort(comparator);

        return found;
    }

    public ArrayList<Car> findCars(Integer comfortLevel) {
        ArrayList<Car> found = new ArrayList<>();
        for(Vehicle v : vehicles) {
/*
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
            /*
             * See?
             * We use only those Vehicles that are also Buses.
             * Not a single Car may pass here :)
             */
            if(v instanceof Bus && ((Bus)v).getSeatCount() >= seatCount) {
                found.add((Bus)v);
            }
        }

        return found;
    }

    public ArrayList<Cargo> getCargos() {
        ArrayList<Cargo> found = new ArrayList<>();
        for(Vehicle v : vehicles) {
            /*
             * See?
             * We use only those Vehicles that are also Cargos.
             * Not a PersonalTransporter may pass here :)
             */
            if(v instanceof Cargo) {
                found.add((Cargo)v);
            }
        }

        //Defining a comparator for sorting Cargo items
        //Comparator<Cargo> comparator = (Cargo c1, Cargo c2) -> c1.getTransportableWeight().compareTo(c2.getTransportableWeight())
        //Can be written in a simpler way
        Comparator<Cargo> comparator = Comparator.comparing(Cargo::getTransportableWeight);

        found.sort(Collections.reverseOrder(comparator));

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

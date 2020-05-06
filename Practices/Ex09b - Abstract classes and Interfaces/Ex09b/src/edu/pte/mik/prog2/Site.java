package edu.pte.mik.prog2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
In component naming, occurrences of Vehicle have to be changed to more generic name Item
For that, use Refactor/Rename from component context menu
(right click on variable or method)
 */
public class Site {
    private String name;

    // Logical connection has been made between Vehicle and Crane through
    // RegisteredForParking interface, so both can be converted to that
    // Objct reference storage can be based on it to handle both branches of
    // abstraction hierarchy tree

    private ArrayList<RegisteredForParking> items;
    private Integer maxItemCount;

    public String getName() {
        return name;
    }

    public Integer getNumberOfItems() {
        return items.size();
    }

    public Integer getMaxItemCount() {
        return maxItemCount;
    }

    /*
    Only increase of storage space is allowed (controlled state change)
     */
    public void setMaxItemCount(Integer maxItemCount) {
        if(maxItemCount > this.maxItemCount) {
            this.maxItemCount = maxItemCount;
        }
    }

    public RegisteredForParking getItem(Integer index) {
        // Check index before using it to access an element
        if(index >= 0 && index < items.size())
            return items.get(index);
        else
            return null;
    }

    public Site(String name, Integer maxItemCount) {
        this.name = name;
        // type parameter can be omitted (derived from declaration)
        items = new ArrayList<>();
        this.maxItemCount = maxItemCount;
    }

    public void registerItem(RegisteredForParking newItem) {
        // Check number of registered vehicles
        // to avoid overbooking
        if(items.size() < maxItemCount) {
            items.add(newItem);
        }
        else {
            System.out.println("Can not register more vehicles!");
        }
    }

    /*
    Partial license based search works with full license also
     */
    public ArrayList<RegisteredForParking> findItems(String license) {
        ArrayList<RegisteredForParking> found = new ArrayList<>();
        for(RegisteredForParking v : items) {
            // Checking if String license haystack contains needle string ignoring case
            if(v.getLicense().toLowerCase().contains(license.toLowerCase())) {
                found.add(v);
            }
        }

        //Defining a comparator for sorting RegisteredForParking items
        //Comparator<RegisteredForParking> comparator = (RegisteredForParking v1, RegisteredForParking v2) -> v1.getLicense().compareTo(v2.getLicense())
        //Can be written in a simpler way
        Comparator<RegisteredForParking> comparator = Comparator.comparing(RegisteredForParking::getLicense);

        found.sort(comparator);

        return found;
    }

    public ArrayList<Car> findCars(Integer comfortLevel) {
        ArrayList<Car> found = new ArrayList<>();
        for(RegisteredForParking rfp : items) {
            /*
             * See?
             * We use only those itmes that are also Cars.
             * Not even a single Bus may pass here :)
             */
            if(rfp instanceof Car && ((Car)rfp).getComfortLevel() >= comfortLevel) {
                found.add((Car)rfp);
            }
        }
        return found;
    }

    public ArrayList<Bus> findBuses(Integer seatCount) {
        ArrayList<Bus> found = new ArrayList<>();
        for(RegisteredForParking rfp : items) {
            /*
             * See?
             * We use only those items that are also Buses.
             * Not even a single Car may pass here :)
             */
            if(rfp instanceof Bus && ((Bus)rfp).getSeatCount() >= seatCount) {
                found.add((Bus)rfp);
            }
        }

        return found;
    }

    public ArrayList<Cargo> getCargos() {
        ArrayList<Cargo> found = new ArrayList<>();
        for(RegisteredForParking rfp : items) {
            /*
             * See?
             * We use only those items that are also Cargos.
             * Not even a PersonalTransporter may pass here :)
             */
            if(rfp instanceof Cargo) {
                found.add((Cargo)rfp);
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
        Comparator<RegisteredForParking> c = (s1, s2) -> s1.getLicense().compareToIgnoreCase(s2.getLicense());
        items.sort(c);
    }

    public void orderByRentalPrice() {
        // Comparator.comparing uses lambda with 1 parameter on both objects
        // to get their comparable values
        items.sort(
                Comparator.comparing(s -> s.getRentalPrice(1))
        );
    }

    public ArrayList<Crane> findCranes(int height, int capacity) {
        ArrayList<Crane> found = new ArrayList<>();
        for(RegisteredForParking rfp : items) {
            /*
             * See?
             * We use only those items that are also Cranes.
             * Not even a single Vehicle may pass here :)
             */
            if(rfp instanceof Crane) {
                Crane c = (Crane)rfp;
                if(c.getHeight() >= height && c.getCarryingCapacity() >= capacity) {
                    found.add(c);
                }
            }
        }

        return found;
    }
}

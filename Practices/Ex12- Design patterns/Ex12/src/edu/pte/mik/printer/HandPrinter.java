package edu.pte.mik.printer;

import edu.pte.mik.manager.Observer;

import java.util.ArrayList;

public class HandPrinter implements ObservablePrinter {
    private static final HandPrinter instance = new HandPrinter("Handwriter PenMaster");

    public static HandPrinter getInstance() {
        return instance;
    }

    private final String name;
    private boolean active;
    private final ArrayList<Observer> observers = new ArrayList<>();

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        notifyObservers();
    }

    private HandPrinter(String name) {
        this.name = name;
        System.out.println(
                String.format(
                        ">Dear %s, welcome in hand writer printer!\n>Please be ready for writing!",
                        name
                )
        );
        active = true;
    }

    public void print(String message, String color) throws PrinterNotReadyException {
        if(active) {
            System.out.println(
                    String.format(
                            ">Dear %s, please write '%s' with %s color",
                            name, message, color
                    )
            );
            System.out.println(">Report if you are ready!");
            active = false;
        }
        else {
            throw new PrinterNotReadyException(message, color);
        }
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}

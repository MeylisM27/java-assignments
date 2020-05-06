package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Storage<T> {
    private ArrayList<T> storage;

    Storage() {
        this.storage = new ArrayList<>();
    }

    public void add(T item) {
        this.storage.add(item);
    }

    public void print() {
        System.out.println("-------PRINT--------");
        for(T item : this.storage) {
            System.out.println(item);
        }
    }

    public void sort(Comparator comparator) {
        if(comparator != null) {
            this.storage.sort(comparator);
        }
    }
}

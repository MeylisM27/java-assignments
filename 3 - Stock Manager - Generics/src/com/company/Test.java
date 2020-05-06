package com.company;

import java.util.Comparator;

public class Test {
    public void test() {
        Storage<Notebook> storageNotebook = new Storage<>();
        storageNotebook.add(new Notebook(60, 80));
        storageNotebook.add(new Notebook(40, 120));
        storageNotebook.add(new Notebook(200, 600));
        storageNotebook.add(new Notebook(20, 10));

        storageNotebook.print();

        Storage<Pencil> pencilStorage = new Storage<>();
        pencilStorage.add(new Pencil(50, "red"));
        pencilStorage.add(new Pencil(85, "orangered"));
        pencilStorage.add(new Pencil(5, "magenta"));
        pencilStorage.add(new Pencil(10, "purple"));

        pencilStorage.print();

        Storage<Gloves> glovesStorage = new Storage<>();
        glovesStorage.add(new Gloves(3, 20));
        glovesStorage.add(new Gloves(1, 30));
        glovesStorage.add(new Gloves(2, 5));
        glovesStorage.add(new Gloves(10, 6));

        glovesStorage.print();

        Storage<Mask> maskStorage = new Storage<>();
        maskStorage.add(new Mask(4, 20));
        maskStorage.add(new Mask(0, 90));
        maskStorage.add(new Mask(1, 30));
        maskStorage.add(new Mask(7, 24));

        maskStorage.print();

        //Objects of other types cannot be stored
        //maskStorage.add(new Pencil(18, "red"));

        System.out.println("------Sorted--------");

        pencilStorage.sort(null);
        storageNotebook.sort(Comparator.comparing(Product::getPrice));
        maskStorage.sort(Comparator.comparing(Equipment::getSafetyLevel));
        glovesStorage.sort(Comparator.comparing(Equipment::getSafetyLevel));

        pencilStorage.print();
        storageNotebook.print();
        maskStorage.print();
        glovesStorage.print();
    }
}

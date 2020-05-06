package edu.pte.mik.prog2;

public class Tester {
    public void testStorage1() {
        System.out.println("Use Object storage and cast everything to Object:");
        System.out.println("\tAccess of spcialized behaviours require explicit cast");
        System.out.println("\tNO type check");

        /*
            Storage1 class is capable for storing objects with different type, because the storage is based on
            Object type, which is the root of the class hierarchy tree, therefore ancestor of all classes.
            Thus all objects can be casted implicitly to Object type.

            Actually both Pencils and Glasses could be placed in the same Object based storage,
            but separate storages were created, according to the exercise description
         */

        Storage1 pencilStorage = new Storage1("Pencils", 5);
        pencilStorage.addItem(new Pencil("red", "HB", 110));
        pencilStorage.addItem(new Pencil("green", "HB", 110));
        pencilStorage.addItem(new Pencil("black", "2B", 87));

        Storage1 glassStorage = new Storage1("Glasses", 5);
        glassStorage.addItem(new Glass("glass", "wine", 222));
        glassStorage.addItem(new Glass("glass", "beer", 333));
        glassStorage.addItem(new Glass("plastic", "water", 444));

        /*
            Because storage is implemented upon the Object class,
            accessing methods of descendants is not possible  through Object interface
            therefore type cast is required, which can not be done to de direction of descendant implicitly.
            This is called explicit type cast to descendant, which is only possible when object to be casted
            contains implementation of the target interface (Is of the target type or its descendant)
         */
        System.out.println("----------");
        System.out.println(pencilStorage.getName());
        Pencil pencilItem;
        for (int i = 0; i < pencilStorage.getNumberOfItems(); i++) {
            System.out.print(pencilStorage.getItem(i));

            // right now, before explicit cast, there is no need for type check
            // because instances of the Pencil class are put into the storage,
            // therefore the explicit cast can be done for all objects
            pencilItem = (Pencil)(pencilStorage.getItem(i));        /* explicit type cast */
            System.out.println("  " + pencilItem.getHardness());
        }

        System.out.println("----------");
        System.out.println(glassStorage.getName());
        Glass glassItem;
        for (int i = 0; i < glassStorage.getNumberOfItems(); i++) {
            System.out.print(glassStorage.getItem(i));
            // right now, before explicit cast, there is no need for type check
            // because instances of the Glass class are put into the storage,
            // therefore the explicit cast can be done for all objects
            glassItem = (Glass)(glassStorage.getItem(i));           /* explicit type cast */
            System.out.println("  " + glassItem.getType());
        }
    }

    public void testStorage2() {
        System.out.println("Use generic storage with type parameter:");
        System.out.println("\tAccess of spcialized behaviours directly");
        System.out.println("\tType checked at compile time");

        /*
        Storage2 class is ready to store different types of objects, because uses type parameter.
        This type parameter make possible to create a specific storage for the current type, given as an
        actual parameter at storage creation.

        In constructor, an array is passed as the place of the storage, because in Java, it is not possible
        to instantiate the type parameter in a generic method.
         */

        //Creation of a specific storage based on generic implementation
        Storage2<Pencil> pencilStorage = new Storage2<>("Pencils", new Pencil[5]);

        //Registration of items of a specific type
        pencilStorage.addItem(new Pencil("red", "HB", 110));
        pencilStorage.addItem(new Pencil("green", "HB", 110));
        pencilStorage.addItem(new Pencil("black", "2B", 87));

        //Creation of a specific storage based on generic implementation
        Storage2<Glass> glassStorage = new Storage2<>("Glasses", new Glass[5]);

        //Registration of items of a specific type
        glassStorage.addItem(new Glass("glass", "wine", 222));
        glassStorage.addItem(new Glass("glass", "beer", 333));
        glassStorage.addItem(new Glass("plastic", "water", 444));

        /*
        No need for type cast, because based on type parameter, the storage is created for the given type
        No cast were done before storage.
         */

        System.out.println("----------");
        System.out.println(pencilStorage.getName());
        for (int i = 0; i < pencilStorage.getNumberOfItems(); i++) {
            System.out.print(pencilStorage.getItem(i));
            System.out.println("  " + pencilStorage.getItem(i).getHardness());
        }

        System.out.println("----------");
        System.out.println(glassStorage.getName());
        for (int i = 0; i < glassStorage.getNumberOfItems(); i++) {
            System.out.print(glassStorage.getItem(i));
            System.out.println("  " + glassStorage.getItem(i).getType());
        }
    }
}

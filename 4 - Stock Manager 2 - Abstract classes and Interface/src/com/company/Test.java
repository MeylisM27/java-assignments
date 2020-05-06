package com.company;

public class Test {
    public void test() {
        System.out.println("-------- Adding items ----------");
        ShelfController myshelf = new ShelfController();

        /*
            User has 2 options to register box. In the first case, slotId should be given by user.
            In case slotId is not provided, system will assign box to the first available slot.
        */

        /*
            Try to remove box after registration. You will see that new boxes will be assigned
            to first available slot.
        */

        myshelf.addBox(new Box<>(new Notebook(60, 80), 3, 20031213));
        myshelf.addBox(new Box<>(new Notebook(40, 120), 8, 20090503));
        //  slotId is explicitly given
        myshelf.addBox(new Box<>(new Notebook(200, 600), 6, 20050312), 5);
        //  myshelf.removeBox(2);

        myshelf.addBox(new Box<>(new Pencil(50, "red"), 15, 20101213));
        myshelf.addBox(new Box<>(new Pencil(85, "orangered"), 36, 20130503));
        myshelf.addBox(new Box<>(new Pencil(5, "magenta"), 78, 20200312), 21);
        //  This will print already occupied
        //  myshelf.addBox(new Box<>(new Pencil(90, "yellowish"), 12, 20171231), 21);

        myshelf.addBox(new Box<>(new Gloves(3, 20), 6, 20121213));
        myshelf.addBox(new Box<>(new Gloves(1, 30), 19, 20200503));
        myshelf.addBox(new Box<>(new Gloves(2, 5), 7, 20020312), 13);

        myshelf.addBox(new Box<>(new Mask(4, 20), 82, 20131213));
        myshelf.addBox(new Box<>(new Mask(0, 90), 14, 20130503));
        myshelf.addBox(new Box<>(new Mask(7, 24), 36, 20150312), 18);

        myshelf.print();

        System.out.println("\n------------ Searching items -----------");
        System.out.println("Each line shows one possible way to get desired amount.");
        System.out.println(myshelf.search("Notebook", 7));
        System.out.println("----------");
        System.out.println(myshelf.search("Gloves", 15));

        System.out.println("\n------------ Picking item ------------");
        // This will print "No enough item", because desired count is greater than the existing count
        myshelf.pick(6, 8);
        // This will successfully remove items
        // Try to see the difference by printing
        myshelf.pick(21, 13);
        // myshelf.print();

        System.out.println("\n------------ Sorting by slot ----------");
        myshelf.sortBySlot();
        myshelf.print();

        System.out.println("\n----------- Sorting by item type ----------");
        myshelf.sortByType();
        myshelf.print();

        System.out.println("\n--------- Adding more boxes -----------");
        myshelf.addBox(new Box<>(new Notebook(14, 120), 18, 20200503));
        myshelf.addBox(new Box<>(new Gloves(3, 20), 6, 20200723));
        myshelf.addBox(new Box<>(new Mask(0, 90), 14, 20191128));

        myshelf.print();

        System.out.println("\n------------ Searching items -----------");
        System.out.println("Each line shows one possible way to get desired amount.");
        System.out.println(myshelf.search("Pencil", 4));
        System.out.println("----------");
        System.out.println(myshelf.search("Mask", 10));

        System.out.println("\n------------ Picking item ------------");
        // This will print "No enough item", because desired count is greater than the existing count
        myshelf.pick(4, 37);
        // This will successfully remove items
        // Try to see the difference by printing
        myshelf.pick(21, 13);
        // myshelf.print();

        System.out.println("\n------------ Sorting by slot ----------");
        myshelf.sortBySlot();
        myshelf.print();

        System.out.println("\n----------- Sorting by item type ----------");
        myshelf.sortByType();
        myshelf.print();
    }
}

package edu.pte.mik.prog2;

public class Main {

    public static void main(String[] args) {
	    Tester tester = new Tester();

	    /*
	    Testing exercise 1, Object based storage
	    Contains: Glass, Pencil, Storage1
	     */
	    tester.testStorage1();

        System.out.println("====================");

        /*
	    Testing exercise 2, generic storage with type parameter
	    Contains: Glass, Pencil, Storage2
	     */
        tester.testStorage2();
    }
}

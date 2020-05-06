package edu.pte.mik.prog2;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Serializer {
    // Serializer methods are stateless methods, thus can be static

    // makes JSON string only for Lists of Exam instances
    public static String serialize(ArrayList<Exam> exams) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(exams);
        System.out.println("1st does the thing");
        return jsonString;
    }

    // Overload of serialize method (same name, different signature)
    // Any type of instances can be converted to Object
    // serializer uses the type of object not the type of reference
    public static String serialize(Object objectToSerialize) {
        Gson gson = new Gson();
        System.out.println("2nd does the thing");
        return gson.toJson(objectToSerialize);
    }
}

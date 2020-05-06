package meylis;

public class BookFactory {

    static int uniqueNumber = 100;

    public static Book createBook(String title, String author, int pageNumber, String publisher) {
        return new Book(title, author, pageNumber, publisher, generateID(title));
    }

    private static String generateID(String title) {
        char letter = (title.charAt(0));
        String uniqueNumberString = String.valueOf(uniqueNumber++);
        return (letter + uniqueNumberString).toUpperCase();
    }
}

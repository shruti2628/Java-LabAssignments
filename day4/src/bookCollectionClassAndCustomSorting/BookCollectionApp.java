package bookCollectionClassAndCustomSorting;

public class BookCollectionApp {

    public static void main(String[] args) {

        Book[] books = {
                new Book("Spring Boot", "Sharma", 650),
                new Book("Java in Depth", "Mehta", 750),
                new Book("Java Basics", "Raj", 500)
        };

        BookCollection collection =
                new BookCollection("Rajeev Gupta", books);

        Book searchBook =
                new Book("Java in Depth", "Mehta", 0);

        System.out.println(
                "Has 'Java in Depth'? " +
                collection.hasBook(searchBook)
        );

        collection.sort();

        System.out.println();
        System.out.println(collection);
    }
}

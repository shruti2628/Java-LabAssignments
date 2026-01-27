package BookFileParsingandLinkedListOperations;

import java.io.*;

public class BookApp {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java BookApp <booksFilePath>");
            return;
        }

        String filePath = args[0];
        BookService service = new BookService(0, filePath, filePath, filePath, 0);

        loadBooksFromFile(filePath, service);

        System.out.println("\n--- All Books ---");
        service.displayAll();

        System.out.println("\n--- Search Book ---");
        Book b = service.searchBook(121);
        System.out.println(b != null ? b : "Book not found");

        try {
            System.out.println("\n--- Sell Book ---");
            service.sellBook("A234", 50);
        } catch (NotSufficientBookException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Purchase Book ---");
        service.purchaseBook("A234", 100);

        System.out.println("\n--- Updated Book List ---");
        service.displayAll();
    }

    private static void loadBooksFromFile(String filePath, BookService service) {

        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(":");

                if (data.length != 5) {
                    System.out.println("Invalid record skipped: " + line);
                    continue;
                }

                int id = Integer.parseInt(data[0]);
                String isbn = data[1];
                String title = data[2];
                String author = data[3];
                int stock = Integer.parseInt(data[4]);

                service.addBook(
                        new Book(id, isbn, title, author, stock)
                );
            }

            System.out.println("Books loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filePath);
        } catch (IOException e) {
            System.out.println("I/O error while reading file.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric value in file.");
        }
    }
}


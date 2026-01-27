package com.bpb.bookstore.presentation;

import java.util.List;
import java.util.Scanner;

import com.bpb.bookstore.entity.Book;
import com.bpb.bookstore.exception.DaoException;
import com.bpb.bookstore.service.BookService;

public class BookStoreApp {
	public static void main(String[] args) {
		BookService service = new BookService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Book Store Menu ======");
            System.out.println("1. Add Book");
            System.out.println("2. Edit Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Book");
            System.out.println("5. List All Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {

                    case 1:
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        Book newBook = new Book(isbn, title, author, price);
                        service.addBook(newBook);
                        System.out.println("Book added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Book ID to update: ");
                        int upId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New ISBN: ");
                        isbn = sc.nextLine();

                        System.out.print("New Title: ");
                        title = sc.nextLine();

                        System.out.print("New Author: ");
                        author = sc.nextLine();

                        System.out.print("New Price: ");
                        price = sc.nextDouble();

                        Book updatedBook = new Book(isbn, title, author, price);
                        service.updateBook(upId, updatedBook);
                        System.out.println("Book updated successfully.");
                        break;

                    case 3:
                        System.out.print("Enter Book ID to delete: ");
                        int delId = sc.nextInt();
                        service.deleteBook(delId);
                        System.out.println("Book deleted successfully.");
                        break;

                    case 4:
                        System.out.print("Enter Book ID to search: ");
                        int searchId = sc.nextInt();

                        Book book = service.getBookById(searchId);
                        if (book != null) {
                            System.out.println(book);
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 5:
                        List<Book> books = service.getAllBooks();
                        if (books.isEmpty()) {
                            System.out.println("No books available.");
                        } else {
                            books.forEach(System.out::println);
                        }
                        break;

                    case 6:
                        System.out.println("Exiting application...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (DaoException e) {
                System.out.println("Database error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Validation error: " + e.getMessage());
            }
        }
	}
}

package com.bookstore.controller;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoJdbcImpl;
import com.bookstore.dto.Book;
import com.bookstore.exceptions.ServiceException;
import com.bookstore.service.BookService;
import com.bookstore.service.BookServiceImpl;
import com.bookstore.util.ConnectionFactory;

public class BookStoreController {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BookService bookService = new BookServiceImpl();
		boolean exit = false;

		while (!exit) {
			System.out.println("\n=== Book Store Menu ===");
			System.out.println("1. Add Book");
			System.out.println("2. Edit Book");
			System.out.println("3. Delete Book");
			System.out.println("4. Search Book by ID");
			System.out.println("5. List All Books");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			try {
				switch (choice) {

				case 1: // Add Book
					System.out.print("Enter ISBN: ");
					String isbn = sc.nextLine();
					System.out.print("Enter Title: ");
					String title = sc.nextLine();
					System.out.print("Enter Author: ");
					String author = sc.nextLine();
					System.out.print("Enter Price: ");
					double price = sc.nextDouble();
					sc.nextLine();

					Book newBook = new Book();
					newBook.setIsbn(isbn);
					newBook.setTitle(title);
					newBook.setAuthor(author);
					newBook.setPrice(price);

					Book added = bookService.addBook(newBook);
					System.out.println("Book added successfully: " + added);
					break;

				case 2: // Edit Book
					System.out.print("Enter Book ID to edit: ");
					int editId = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter new Title: ");
					String newTitle = sc.nextLine();
					System.out.print("Enter new Author: ");
					String newAuthor = sc.nextLine();
					System.out.print("Enter new Price: ");
					double newPrice = sc.nextDouble();
					sc.nextLine();

					Book editBook = new Book();
					editBook.setTitle(newTitle);
					editBook.setAuthor(newAuthor);
					editBook.setPrice(newPrice);

					bookService.updateBook(editId, editBook);
					System.out.println("Book updated successfully!");
					break;

				case 3: // Delete Book
					System.out.print("Enter Book ID to delete: ");
					int deleteId = sc.nextInt();
					sc.nextLine();

					bookService.deleteBook(deleteId);
					System.out.println("Book deleted successfully!");
					break;

				case 4: // Search Book by ID
					System.out.print("Enter Book ID to search: ");
					int searchId = sc.nextInt();
					sc.nextLine();

					Book found = bookService.getBookById(searchId);
					System.out.println("Book found: " + found);
					break;

				case 5: // List All Books
					List<Book> books = bookService.getAllBooks();
					if (books.isEmpty()) {
						System.out.println("No books available.");
					} else {
						System.out.println("List of Books:");
						books.forEach(System.out::println);
					}
					break;

				case 6: // Exit
					exit = true;
					System.out.println("Exiting... Goodbye!");
					break;

				default:
					System.out.println("Invalid choice! Try again.");
					break;
				}

			} catch (ServiceException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
		}

		sc.close();
	}
}
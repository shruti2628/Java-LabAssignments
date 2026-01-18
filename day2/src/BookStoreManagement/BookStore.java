package BookStoreManagement;

import java.util.Scanner;

public class BookStore {
	private Book books[];
	private int count;
	
	public BookStore() {
		books = new Book[10];
		count=0;
	}
	public void BookAdd(Book b) {
		if (count<10) {
			books[count]=b;
			count++;
		}
		else {
			System.out.println("System is full");
		}
	}
	public void sell(String title, int sellCount) {
		for (int i=0; i<count; i++) {
			if (books[i].bookTitle.equalsIgnoreCase(title)) {
				if (books[i].numOfCopies>=sellCount) {
					books[i].numOfCopies-=sellCount;
					System.out.println("Sold "+sellCount+" copies.");
				}
				else {
					System.out.println("Not enough stock");
				}
			}
			else {
				System.out.println("Not found");
			}
		}
	}
	public void order(String isbn, int orderCount) {
		for (int i=0; i<10; i++) {
			if (books[i].isbn.equalsIgnoreCase(isbn)) {
				books[i].numOfCopies+=orderCount;
				System.out.println("");
				return;
			}
		}
		if (count < 10) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter book title: ");
            String title = sc.nextLine();

            System.out.print("Enter author name: ");
            String author = sc.nextLine();

            books[count++] = new Book(title, author, isbn, count);
            System.out.println("New book added successfully.");
        } else {
            System.out.println("No space available to add new book.");
        }
	}
	public void display(){
		for (int i=0; i<count; i++) {
			System.out.print(books[i]+" ");
		}
	}
}

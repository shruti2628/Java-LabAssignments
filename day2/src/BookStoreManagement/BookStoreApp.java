package BookStoreManagement;

import java.util.Scanner;

public class BookStoreApp {
	public static void main(String[] args) {
		Book bookOne = new Book("HouseMaid","Mc Frieden","1213", 4);
		BookStore bookStore = new BookStore();
		bookStore.BookAdd(bookOne);
		bookStore.sell("HouseMaid", 1);
		bookStore.order("1213", 2);
	}
}

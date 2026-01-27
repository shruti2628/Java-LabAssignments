package BookStoreManagement;

public class Book {
	String bookTitle;
	String author;
	String isbn;
	int numOfCopies;
	
	public Book(String bookTitle, String author, String isbn, int numOfCopies){
		this.bookTitle = bookTitle;
		this.author =author;
		this.isbn = isbn;
		
		if (numOfCopies>=0) {
			this.numOfCopies = numOfCopies;
		}
		else {
			
			System.out.println("Quantity cannot be negative.");	
		}
	}
	public void printDetails() {
		System.out.print("Title- "+bookTitle+" Author- "+author+" ISBN- "+isbn+" Quantity- "+numOfCopies);
	}
}

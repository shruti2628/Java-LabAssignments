package BookFileParsingandLinkedListOperations;

import java.util.LinkedList;

public class BookService extends Book{

    public BookService(int id, String isbn, String title, String author, int stock) {
		super(id, isbn, title, author, stock);
	}

	private LinkedList<Book> books = new LinkedList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public void sellBook(String isbn, int noOfCopies)
            throws NotSufficientBookException {

        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {

                if (b.getStock() < noOfCopies) {
                    throw new NotSufficientBookException(
                            "Insufficient stock for ISBN: " + isbn
                    );
                }

                b.decreaseStock(noOfCopies);
                System.out.println("Book sold successfully.");
                return;
            }
        }
        System.out.println("Book with ISBN not found.");
    }
    
    public void purchaseBook(String isbn, int noOfCopies) {

        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                b.increaseStock(noOfCopies);
                System.out.println("Book stock updated.");
                return;
            }
        }
        System.out.println("Book with ISBN not found.");
    }

    public void displayAll() {
        for (Book b : books) {
            System.out.println(b);
        }
    }
}


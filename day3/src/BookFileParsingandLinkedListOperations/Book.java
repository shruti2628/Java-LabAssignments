package BookFileParsingandLinkedListOperations;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private String author;
    private int stock;

    public Book(int id, String isbn, String title, String author, int stock) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getStock() {
        return stock;
    }

    public void increaseStock(int qty) {
        stock += qty;
    }

    public void decreaseStock(int qty) {
        stock -= qty;
    }

    @Override
    public String toString() {
        return id + " | " + isbn + " | " + title + " | " + author + " | Stock: " + stock;
    }
}

package com.bookstorejpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstorejpa.entity.Book;
import com.bookstorejpa.repository.BookRepository;

@Service
public class BookService {
	private final BookRepository repo;

    // Constructor Injection 
    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public Book getBook(Integer id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public void deleteBook(Integer id) {
        repo.deleteById(id);
    }

    public List<Book> getByAuthor(String author) {
        return repo.findByAuthor(author);
    }

    public List<Book> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Book> getByPriceLessThan(Double price) {
        return repo.findByPriceLessThan(price);
    }

    public List<Book> searchByTitle(String keyword) {
        return repo.searchByTitle(keyword);
    }

    public List<Book> getByPriceRange(double min, double max) {
        return repo.findByPriceRange(min, max);
    }
}

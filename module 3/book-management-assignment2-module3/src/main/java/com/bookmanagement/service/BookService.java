package com.bookmanagement.service;

import org.springframework.stereotype.Service;

import com.bookmanagement.dto.BookDto;
import com.bookmanagement.entity.Book;
import com.bookmanagement.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
	private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book addBook(BookDto dto) {
        Book book = new Book(null, dto.getTitle(), dto.getAuthor(), dto.getPrice());
        return repo.save(book);
    }

    public Book updateBook(Integer id, BookDto dto) {
        Book existing = repo.findById(id);
        if (existing == null) {
            throw new RuntimeException("Book not found with id: " + id);
        }

        existing.setTitle(dto.getTitle());
        existing.setAuthor(dto.getAuthor());
        existing.setPrice(dto.getPrice());

        return repo.save(existing);
    }

    public Book getBook(Integer id) {
        Book book = repo.findById(id);
        if (book == null) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        return book;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public void deleteBook(Integer id) {
        Book book = repo.findById(id);
        if (book == null) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        repo.deleteById(id);
    }
}

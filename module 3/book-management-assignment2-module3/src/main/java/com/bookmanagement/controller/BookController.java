package com.bookmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.dto.BookDto;
import com.bookmanagement.entity.Book;
import com.bookmanagement.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book add(@RequestBody BookDto dto) {
        return service.addBook(dto);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {
        return service.getBook(id);
    }

    @GetMapping
    public List<Book> getAll() {
        return service.getAllBooks();
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Integer id, @RequestBody BookDto dto) {
        return service.updateBook(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteBook(id);
    }
}
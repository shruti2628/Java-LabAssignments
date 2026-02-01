package com.bookstorejpa.jdbc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstorejpa.entity.Book;
import com.bookstorejpa.jdbc.dao.BookJdbcDao;
import com.bookstorejpa.jdbc.dao.BookNamedDao;

@RestController
@RequestMapping("/api/jdbc/books")
public class BookJdbcController {

    private final BookJdbcDao jdbcDao;
    private final BookNamedDao namedDao;

    public BookJdbcController(BookJdbcDao jdbcDao, BookNamedDao namedDao) {
        this.jdbcDao = jdbcDao;
        this.namedDao = namedDao;
    }

    @PostMapping
    public String addBook(@RequestBody Book book) {
        jdbcDao.save(book);
        return "Book added using JDBC";
    }

    @GetMapping
    public List<Book> getAll() {
        return jdbcDao.findAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        return jdbcDao.findById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        jdbcDao.update(book);
        return "Book updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        jdbcDao.delete(id);
        return "Book deleted";
    }

    @GetMapping("/author/{author}")
    public List<Book> byAuthor(@PathVariable String author) {
        return namedDao.findByAuthor(author);
    }

    @GetMapping("/price-range")
    public List<Book> byPriceRange(
            @RequestParam double min,
            @RequestParam double max) {
        return namedDao.findByPriceRange(min, max);
    }
}

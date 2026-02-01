package com.bookstorejpa.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bookstorejpa.entity.Book;
import com.bookstorejpa.jdbc.rowmapper.BookRowMapper;

import org.springframework.stereotype.Repository;

@Repository
public class BookJdbcDao {
	private final JdbcTemplate jdbc;

    public BookJdbcDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public int save(Book b) {
        String sql = "INSERT INTO books_jdbc(title, author, price, isbn) VALUES (?, ?, ?, ?)";
        return jdbc.update(
                sql,
                b.getTitle(),
                b.getAuthor(),
                b.getPrice(),
                b.getIsbn()
        );
    }

    public Book findById(int id) {
        String sql = "SELECT * FROM books_jdbc WHERE id = ?";
        return jdbc.queryForObject(sql, new BookRowMapper(), id);
    }

    public List<Book> findAll() {
        String sql = "SELECT * FROM books_jdbc";
        return jdbc.query(sql, new BookRowMapper());
    }

    public int update(Book b) {
        String sql = "UPDATE books_jdbc SET title=?, author=?, price=?, isbn=? WHERE id=?";
        return jdbc.update(
                sql,
                b.getTitle(),
                b.getAuthor(),
                b.getPrice(),
                b.getIsbn(),
                b.getId()
        );
    }

    public int delete(int id) {
        String sql = "DELETE FROM books_jdbc WHERE id=?";
        return jdbc.update(sql, id);
    }
}

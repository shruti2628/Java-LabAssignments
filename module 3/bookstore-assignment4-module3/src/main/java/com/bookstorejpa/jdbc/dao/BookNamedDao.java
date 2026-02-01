package com.bookstorejpa.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;
import com.bookstorejpa.entity.Book;
import com.bookstorejpa.jdbc.rowmapper.BookRowMapper;

@Repository
public class BookNamedDao {
	private final NamedParameterJdbcTemplate namedJdbc;
	
    public BookNamedDao(NamedParameterJdbcTemplate namedJdbc) {
        this.namedJdbc = namedJdbc;
    }

    public List<Book> findByAuthor(String author) {
        String sql = "SELECT * FROM books_jdbc WHERE author = :author";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("author", author);

        return namedJdbc.query(sql, params, new BookRowMapper());
    }

    public List<Book> findByPriceRange(double min, double max) {
        String sql = "SELECT * FROM books_jdbc WHERE price BETWEEN :min AND :max";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("min", min);
        params.addValue("max", max);

        return namedJdbc.query(sql, params, new BookRowMapper());
    }
}

package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;
import com.bookstore.util.ConnectionFactory;

public class BookDaoJdbcImpl implements BookDao {
	private Connection connection;

	public BookDaoJdbcImpl() {

		connection = ConnectionFactory.getConnection();

	}

	@Override
	public List<Book> getAllBooks() throws DaoException {
		List<Book> books = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from books");

			while (rs.next()) {
				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
			}
		} catch (SQLException e) {
			throw new DaoException("Error fetching books", e);
		}

		return books;
	}

	@Override
	public Book addBook(Book book) throws DaoException {
		try {

			PreparedStatement psmt = connection.prepareStatement(
					"insert into books(isbn,title,author,price) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, book.getIsbn());
			psmt.setString(2, book.getTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setDouble(4, book.getPrice());
			psmt.executeUpdate();

			ResultSet rs = psmt.getGeneratedKeys();
			if (rs.next()) {
				book.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new DaoException("Unable to add book", e);
		}
		return book;
	}

	@Override

	public void deleteBook(int id) throws DaoException {

		try {
			PreparedStatement psmt = connection.prepareStatement("delete from books where id=?");
			psmt.setInt(1, id);
			psmt.executeUpdate();

		} catch (SQLException e) {

			throw new DaoException("Unable to delete book", e);
		}

	}

	@Override
	public void updateBook(int id, Book book) throws DaoException {

		String sql = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?";

		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setDouble(3, book.getPrice());
			psmt.setInt(4, id);

			int rows = psmt.executeUpdate();
			if (rows == 0) {
				throw new DaoException("No book found with id: " + id);
			}

		} catch (SQLException e) {
			throw new DaoException("Error updating book with id: " + id, e);
		}

	}

	@Override
	public Book getBookById(int id) throws DaoException {

		String sql = "SELECT * FROM books WHERE id = ?";
		Book book = null;

		try (PreparedStatement psmt = connection.prepareStatement(sql)) {

			psmt.setInt(1, id);

			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getDouble("price"));
			} else {
				throw new DaoException("No book found with id: " + id);
			}

		} catch (SQLException e) {
			throw new DaoException("Error fetching book with id: " + id, e);
		}

		return book;
	}

}
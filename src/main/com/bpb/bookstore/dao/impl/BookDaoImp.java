package com.bpb.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpb.bookstore.entity.Book;
import com.bpb.bookstore.exception.DaoException;
import com.bpb.bookstore.daoo.BookDao;
import com.bpb.bookstore.util.DBUtil;

public class BookDaoImp implements BookDao{

	@Override
	public List<Book> getAllBooks() throws DaoException {
		
		List<Book> books = new ArrayList<>();
		String sql = "SELECT * FROM books";
		
		try (Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			
			while (rs.next()) {
				Book book = new Book(
					rs.getInt("id"),
					rs.getString("isbn"),
					rs.getString("title"),
					rs.getString("author"),
					rs.getDouble("price")
				);
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			throw new DaoException("Failed to fetch books", e);
		}
	}

	@Override
	public void deleteBook(int id) throws DaoException {
		String sql = "DELETE FROM books WHERE id=?";
		
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException("Failed to delete book", e);
		}
		
	}

	@Override
	public void updateBook(int id, Book book) throws DaoException {
		
		String sql = "UPDATE books SET isbn=?, title=?, author=?, price=? WHERE id=?";
		
		try (Connection con = DBUtil.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setDouble(4, book.getPrice());
			ps.setInt(5,id);
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			throw new DaoException("Failed to update book", e);
		}
	
	}

	@Override
	public Book getBookById(int id) throws DaoException {
		String sql = "SELECT * FROM books WHERE id=?";
		
		try(Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Book(
					rs.getInt("id"),
					rs.getString("isbn"),
					rs.getString("title"),
					rs.getString("author"),
					rs.getDouble("price")
				);
			}
			return null;
		} catch (SQLException e) {
			throw new DaoException("failed to fetch book by id", e);
		}
	}
	
	@Override
	public Book addBook(Book book) throws DaoException{
		String sql = "INSERT INTO books (isbn, title, author, price) VALUES(?, ?, ?, ?)";
		
		try(Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
			
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setDouble(4, book.getPrice());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				book.setId(rs.getInt(1));
			}
			
			return book;
		} catch(Exception e) {
			throw new DaoException("Failed to add book", e);
		}
	}

}

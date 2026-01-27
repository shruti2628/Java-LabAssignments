package com.bpb.bookstore.daoo;

import java.util.List;

import com.bpb.bookstore.entity.Book;
import com.bpb.bookstore.exception.DaoException;

public interface BookDao {
	List<Book> getAllBooks() throws DaoException;
	
	Book addBook(Book book) throws DaoException;
	
	void deleteBook(int id) throws DaoException;
	
	void updateBook(int id, Book book) throws DaoException;
	
	Book getBookById(int id) throws DaoException;
}

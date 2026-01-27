package com.bookstore.service;

import java.util.List;

import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;
import com.bookstore.exceptions.ServiceException;

public interface BookService {
	public List<Book> getAllBooks() throws ServiceException;

	public Book addBook(Book book) throws ServiceException;

	public void deleteBook(int id) throws ServiceException;

	public void updateBook(int id, Book book) throws ServiceException;

	public Book getBookById(int id) throws ServiceException;

}
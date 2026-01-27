package com.bpb.bookstore.service;

import java.util.List;

import com.bpb.bookstore.daoo.BookDao;
import com.bpb.bookstore.dao.impl.BookDaoImp;
import com.bpb.bookstore.entity.Book;
import com.bpb.bookstore.exception.DaoException;

public class BookService {
	
	private BookDao bookDao;
	
	public BookService() {
		this.bookDao = new BookDaoImp();
	}
	
	public Book addBook(Book book) throws DaoException{
		
		if (book.getTitle()==null || book.getTitle().trim().isEmpty()) {
			throw new IllegalArgumentException("Book title cannot be empty");
		}
		
		if (book.getPrice()<=0) {
			throw new IllegalArgumentException("Book price must be greater than zero");
		}
		
		return bookDao.addBook(book);
	}
	
	public List<Book> getAllBooks() throws DaoException{
		return bookDao.getAllBooks();
	}
	
	public Book getBookById(int id) throws DaoException{
		if (id<=0) {
			throw new IllegalArgumentException("Invalid book ID");
		}
		return bookDao.getBookById(id);
	}
	
	public void updateBook(int id, Book book) throws DaoException{
		if (id<=0) {
			throw new IllegalArgumentException("Invalid book ID");
		}
		if (book.getPrice()<=0) {
			throw new IllegalArgumentException("Book price must be greater than zero");
		}
		bookDao.updateBook(id, book);
	}
	
	public void deleteBook(int id) throws DaoException{
		if (id<=0) {
			throw new IllegalArgumentException("Invalid book ID");
		}
		bookDao.deleteBook(id);
	}

}

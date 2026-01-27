package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoJdbcImpl;
import com.bookstore.dao.BookDaoJpaImpl;
import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;
import com.bookstore.exceptions.ServiceException;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;

	public BookServiceImpl() {

		this.bookDao = new BookDaoJpaImpl();
	}

	@Override
	public Book addBook(Book book) throws ServiceException {
		if (book.getPrice() <= 0) {
			throw new ServiceException("Price must be greater than 0");
		}
		if (book.getTitle() == null || book.getTitle().isEmpty()) {
			throw new ServiceException("Title cannot be empty");
		}

		Book bookRes;
		try {
			bookRes = bookDao.addBook(book);
		} catch (DaoException e) {
			throw new ServiceException("Unable to add book: " + e.getMessage());
		}
		return book;
	}

	@Override
	public List<Book> getAllBooks() throws ServiceException {
		try {
			return bookDao.getAllBooks();
		} catch (DaoException e) {
			throw new ServiceException("Unable to fetch books: " + e.getMessage());
		}
	}

	@Override
	public Book getBookById(int id) throws ServiceException {
		try {
			return bookDao.getBookById(id);
		} catch (DaoException e) {
			throw new ServiceException("Unable to fetch book by ID: " + e.getMessage());
		}
	}

	@Override
	public void updateBook(int id, Book book) throws ServiceException {
		try {
			bookDao.updateBook(id, book);
		} catch (DaoException e) {
			throw new ServiceException("Unable to update book: " + e.getMessage());
		}
	}

	@Override
	public void deleteBook(int id) throws ServiceException {
		try {
			bookDao.deleteBook(id);
		} catch (DaoException e) {
			throw new ServiceException("Unable to delete book: " + e.getMessage());
		}
	}
}
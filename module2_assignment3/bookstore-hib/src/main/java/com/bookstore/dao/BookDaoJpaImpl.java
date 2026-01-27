package com.bookstore.dao;

import java.util.List;

import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;
import com.bookstore.util.JPAConnectionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class BookDaoJpaImpl implements BookDao {

	public BookDaoJpaImpl() {

	}

	@Override
	public List<Book> getAllBooks() throws DaoException {
		EntityManager em = JPAConnectionFactory.getEntityManager();
		List<Book> allBook;
		try {

			allBook = em.createQuery("from Book").getResultList();
		} catch (PersistenceException pe) {
			throw new DaoException("Error fetching books", pe);
		}
		em.close();
		return allBook;
	}

	@Override
	public Book addBook(Book book) throws DaoException {
		EntityManager em = JPAConnectionFactory.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			em.persist(book);

			tx.commit();
			System.out.println("book is saved...");
		} catch (PersistenceException ex) {
			if (tx != null)
				tx.rollback();
			throw new DaoException("Unable to add book", ex);
		}

		em.close();

		return book;
	}

	@Override
	public void deleteBook(int id) throws DaoException {
		EntityManager em = JPAConnectionFactory.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Book book = em.find(Book.class, id);

			if (book != null) {
				em.remove(book);
			}

			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw new DaoException("Unable to delete book", e);
		} finally {
			em.close();
		}
	}

	@Override
	public void updateBook(int id, Book book) throws DaoException {
		EntityManager em = JPAConnectionFactory.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Book toUpdateBook = em.find(Book.class, id);
			toUpdateBook.setAuthor(book.getAuthor());
			toUpdateBook.setPrice(book.getPrice());
			toUpdateBook.setTitle(book.getTitle());

			em.merge(toUpdateBook);

			tx.commit();

		} catch (PersistenceException e) {
			if (tx != null)
				tx.rollback();
			throw new DaoException("Error updating book with id: " + id, e);
		}

		em.close();

	}

	@Override
	public Book getBookById(int id) throws DaoException {
		EntityManager em = JPAConnectionFactory.getEntityManager();
		try {
			return em.find(Book.class, id);
		} catch (PersistenceException e) {
			throw new DaoException("Error fetching book with id: " + id, e);
		} finally {
			em.close();
		}
	}

}
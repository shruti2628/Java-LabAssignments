package com.bookmanagement.repository;

import com.bookmanagement.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BookRepository {
	private final Map<Integer, Book> store = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger(1);

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(counter.getAndIncrement());
        }
        store.put(book.getId(), book);
        return book;
    }

    public Book findById(Integer id) {
        return store.get(id);
    }

    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    public void deleteById(Integer id) {
        store.remove(id);
    }
}

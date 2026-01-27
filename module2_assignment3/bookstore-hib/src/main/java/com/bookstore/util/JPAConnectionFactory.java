package com.bookstore.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConnectionFactory {
	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("jpa");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void close() {

		emf.close();

	}
}
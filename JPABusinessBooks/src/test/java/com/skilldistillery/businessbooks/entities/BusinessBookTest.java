package com.skilldistillery.businessbooks.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class BusinessBookTest {

	private static EntityManagerFactory factory;
	private EntityManager manager;
	private BusinessBook businessBook;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		factory = Persistence.createEntityManagerFactory("JPABusinessBooks");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		factory.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		manager = factory.createEntityManager();
		businessBook = manager.find(BusinessBook.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		businessBook = null;
		manager.close();
	}

	@Test
	void test_BusinessBook_Entity_Mapping() {
		assertNotNull(businessBook);
		assertEquals("Rich Dad Poor Dad", businessBook.getTitle());
	}
}
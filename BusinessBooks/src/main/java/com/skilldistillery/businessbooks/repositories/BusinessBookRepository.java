package com.skilldistillery.businessbooks.repositories;

import java.awt.print.Book;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.businessbooks.entities.BusinessBook;

public interface BusinessBookRepository extends JpaRepository<BusinessBook, Integer> {

	List<Book> findByBookId(int categoryId);

}
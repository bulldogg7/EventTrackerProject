package com.skilldistillery.businessbooks.services;

import java.util.List;

import com.skilldistillery.businessbooks.entities.BusinessBook;

public interface BusinessBookService {

	List<BusinessBook> findAll();
	
	BusinessBook findBookById(int bookId);
	
	BusinessBook createBook(BusinessBook newBook);
	
	BusinessBook updateBook(BusinessBook book, int bookId);
	
	boolean deleteBookById(int bookId);
	
}
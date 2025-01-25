package com.skilldistillery.businessbooks.services;

import java.util.List;

import com.skilldistillery.businessbooks.entities.BusinessBook;

public interface BusinessBookService {

	List<BusinessBook> findAll();
	
	BusinessBook findById(int bookId);
	
	BusinessBook create(BusinessBook newBook);
	
	BusinessBook update(BusinessBook book, int bookId);
	
	boolean deleteById(int bookId);
	
}

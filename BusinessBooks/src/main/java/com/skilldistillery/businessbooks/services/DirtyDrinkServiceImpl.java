package com.skilldistillery.businessbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.businessbooks.entities.BusinessBook;
import com.skilldistillery.businessbooks.repositories.BusinessBookRepository;

@Service
public class DirtyDrinkServiceImpl implements BusinessBookService {

	@Autowired
	BusinessBookRepository bookRepository;
	
	@Override
	public List<BusinessBook> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public BusinessBook findById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessBook create(BusinessBook newBook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessBook update(BusinessBook book, int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

}

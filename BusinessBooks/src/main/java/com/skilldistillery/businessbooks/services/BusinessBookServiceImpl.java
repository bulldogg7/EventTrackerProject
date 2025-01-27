package com.skilldistillery.businessbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.businessbooks.entities.BusinessBook;
import com.skilldistillery.businessbooks.repositories.BusinessBookRepository;

@Service
public class BusinessBookServiceImpl implements BusinessBookService {

	@Autowired
	BusinessBookRepository bookRepository;

	@Override
	public List<BusinessBook> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public BusinessBook findBookById(int bookId) {
		Optional<BusinessBook> bookOptional = bookRepository.findById(bookId);
		BusinessBook foundBook = null;
		if (bookOptional.isPresent()) {
			foundBook = bookOptional.get();
		}
		return foundBook;
	}

	@Override
	public BusinessBook createBook(BusinessBook newBook) {
		return bookRepository.saveAndFlush(newBook);
	}

	@Override
	public BusinessBook updateBook(BusinessBook book, int bookId) {
		Optional<BusinessBook> bookOptional = bookRepository.findById(bookId);
		BusinessBook managedBook = null;
		if (bookOptional.isPresent()) {
			managedBook = bookOptional.get();
			managedBook.setTitle(book.getTitle());
			managedBook.setCategory(book.getCategory());
			managedBook.setAuthor(book.getTitle());
			managedBook.setNumberOfPages(book.getNumberOfPages());
			managedBook.setFinishDate(book.getFinishDate());
			managedBook.setImageUrl(book.getImageUrl());
			managedBook.setRating(book.getRating());
			managedBook.setReview(book.getReview());
			managedBook.setRecommend(book.getRecommend());
			bookRepository.saveAndFlush(managedBook);
		}
		return managedBook;
	}

	@Override
	public boolean deleteBookById(int bookId) {
		boolean wasDeleted = false;
		Optional<BusinessBook> bookOptional = bookRepository.findById(bookId);
		if (bookOptional.isPresent()) {
			BusinessBook businessBook = bookOptional.get();
			bookRepository.delete(businessBook);
			wasDeleted = true;
		}
		return wasDeleted;
	}
}
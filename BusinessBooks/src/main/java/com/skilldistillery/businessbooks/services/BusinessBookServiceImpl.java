package com.skilldistillery.businessbooks.services;

import java.awt.print.Book;
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
		BusinessBook foundBook = bookOptional.get();
		if (bookOptional.isPresent()) {
			foundBook.setTitle(book.getTitle());
			foundBook.setCategory(book.getCategory());
			foundBook.setAuthor(book.getTitle());
			foundBook.setNumberOfPages(book.getNumberOfPages());
			foundBook.setFinishDate(book.getFinishDate());
			foundBook.setImageUrl(book.getImageUrl());
			foundBook.setRating(book.getRating());
			foundBook.setReview(book.getReview());
			foundBook.setRecommend(book.getRecommend());
			bookRepository.saveAndFlush(foundBook);
		}
		return foundBook;
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
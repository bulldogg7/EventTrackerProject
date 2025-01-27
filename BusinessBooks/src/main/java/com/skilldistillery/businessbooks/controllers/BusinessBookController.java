package com.skilldistillery.businessbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.businessbooks.entities.BusinessBook;
import com.skilldistillery.businessbooks.services.BusinessBookService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class BusinessBookController {

	@Autowired
	private BusinessBookService bookService;

	@GetMapping("businessBooks")
	public List<BusinessBook> listBooks() {
		return bookService.findAll();
	}

	@GetMapping("businessBook/{bookId}")
	public BusinessBook findBookById(@PathVariable("bookId") int bookId) {
		return bookService.findBookById(bookId);
	}

	@PostMapping("businessBook")
	public BusinessBook createBook(@RequestBody BusinessBook businessBook, HttpServletResponse response) {
		try {
		bookService.createBook(businessBook);
		response.setStatus(HttpServletResponse.SC_CREATED); //201
		} catch (Exception e) {
			e.printStackTrace();
			businessBook = null;
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
		}
		return businessBook;
	}

	@PutMapping("businessBook/{bookId}")
	public BusinessBook updateBook(@RequestBody BusinessBook businessBook, 
			@PathVariable("bookId") int bookId, HttpServletResponse response) {
		BusinessBook updatedBook = bookService.updateBook(businessBook, bookId);
		if (updatedBook == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
		}
		return updatedBook;
	}

	@DeleteMapping("businessBook/{bookId}")
	public boolean deleteBook(@PathVariable("bookId") int bookId) {
		boolean wasDeleted = bookService.deleteBookById(bookId);
		return wasDeleted;
	}
}
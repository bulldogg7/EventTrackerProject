package com.skilldistillery.businessbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.businessbooks.entities.BusinessBook;
import com.skilldistillery.businessbooks.services.BusinessBookService;

@RestController
@RequestMapping("api")
public class BusinessBookController {

	@Autowired
	private BusinessBookService bookService;

	@GetMapping("businessBooks")
	public List<BusinessBook> listBooks() {
		return bookService.findAll();
	}

}

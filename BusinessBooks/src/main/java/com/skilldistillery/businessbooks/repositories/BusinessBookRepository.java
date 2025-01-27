package com.skilldistillery.businessbooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.businessbooks.entities.BusinessBook;

public interface BusinessBookRepository extends JpaRepository<BusinessBook, Integer> {

}
package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modal.books;

public interface booksRepo extends MongoRepository<books, String> {

}

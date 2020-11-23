package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.books;
import com.example.demo.repository.booksRepo;

@RestController
@RequestMapping("/admin")
public class booksController {

	@Autowired
	
	private booksRepo repo;
	
	//Add new book
	@PostMapping("/addBook")
	public String addBook(@RequestBody books newBook) {
		repo.save(newBook);
		return "New Book Added";
	}
	
	//Delete book
	@DeleteMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") String bookId) {
		Optional<books> book = repo.findById(bookId);
		if(book.isEmpty()) {
			return "No book Exist";
		}
		repo.deleteById(bookId);
		return "Book Deleted";
	}
	
	//get book by id
	@GetMapping("/getOne/{bookId}")
	public books get_by_id(@PathVariable("bookId") String bookId) {
		Optional<books> book = repo.findById(bookId);
		if(book.isEmpty()) {
			return null;
		}
		return book.get();
	}
	
	@PostMapping("/update")
	public String update_book_details(@RequestBody books oldBook) {
		Optional<books> book = repo.findById(oldBook.getId());
		if(book.isEmpty()) {
			return "Book Number dosen't exist";
		}
		repo.save(oldBook);
		return "Book Updated";
	}
	
	//get all books
	@GetMapping("/allBooks")
	public List<books> getAll(){
		return repo.findAll();
	}
}

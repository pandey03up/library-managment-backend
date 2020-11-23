package com.example.demo.modal;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class users {
	
	@Id
	private String id;
	private String email;
	private String name;
	private String password;
	private String type;
	private List<List<Object>> issuedBooks;
	private List<String> reservedBooks;
	private int fine = 0;
	private boolean isAdmin = false;
	
	public int getTotalFine() {
		return fine;
	}
	public void setTotalFine(int totalFine) {
		this.fine = totalFine;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<List<Object>> getIssuedBooks() {
		return issuedBooks;
	}
	public void setIssuedBooks(List<List<Object>> issuedBooks) {
		this.issuedBooks = issuedBooks;
	}
	public List<String> getReservedBooks() {
		return reservedBooks;
	}
	public void setReservedBooks(List<String> reservedBooks) {
		this.reservedBooks = reservedBooks;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	
	
	
	
	
}

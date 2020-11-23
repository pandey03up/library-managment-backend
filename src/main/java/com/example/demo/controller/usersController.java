package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.books;
import com.example.demo.modal.users;
import com.example.demo.repository.usersRepo;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/users")
public class usersController {
	@Autowired
	
	private usersRepo repo;
	
	//hashing function for password
	private String hashIt(String oldPassword) {
		String newPassword = "$crypto&u_p$";
		for(int i = 0;i < oldPassword.length();i++) {
			newPassword = newPassword.concat(String.valueOf(oldPassword.charAt(i)));
			int ascii = oldPassword.charAt(i);
			if(ascii >= 97) {
				ascii -= 64;
			}
			if(ascii >= 65 && ascii < 97) {
				ascii -= 32;
			}
			newPassword = newPassword.concat(Character.toString((char)ascii));
		}
		return newPassword;
	}
	
	//create new user
	@PostMapping("/signup")
	public String Register(@RequestBody users newUser){
		Optional<users> exists = repo.findById(newUser.getId());
		if(!exists.isEmpty()) {
			return "User already exists";
		}
		newUser.setPassword(hashIt(newUser.getPassword()));
		if(repo.findById(newUser.getId()).isEmpty()) {
			repo.save(newUser);
			return "New User Created";
		}
		return "User already exists";
	}
	
	//get all users
	@GetMapping("/getAll")
	public List<users> getAll(){
		return repo.findAll();
	}
	
	//get one user
	@GetMapping("/login/{log_email}/{pass}")
	public users Login(@PathVariable("log_email") String log_email, @PathVariable("pass") String pass) throws Exception{
		Optional<users> user = repo.findById(log_email);
		if(!user.isEmpty()) {
			users myUser = user.get();
			if(myUser.getPassword().equals(hashIt(pass))) {
				return myUser;
			}
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public users get_one(@PathVariable("id") String id) {
		Optional<users> user = repo.findById(id);
		if(user.isEmpty()) {
			return null;
		}
		return user.get();
	}
	
	//Update user
	@PostMapping("/update")
	public String update_user(@RequestBody users oldUser) {
		Optional<users> user = repo.findById(oldUser.getId());
		if(user.isEmpty()) {
			return "User dosen't exist";
		}
		repo.save(oldUser);
		return "User Updated";
	}
		
}

package com.cognizant.login.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.login.LoginApplication;
import com.cognizant.login.model.User;
import com.cognizant.login.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginApplication.class);
	
	@Autowired
	UserService userService;

	@GetMapping()
	public List<User> getUsers() {
//		System.err.println("Hello---------------");
		return this.userService.getUsersList();
	}

	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable("id") int id) {
		return this.userService.getUserById(id);
	}
	
	@GetMapping("/login/{email}/{password}")
	public User getUserByMail(@PathVariable("email") String email,@PathVariable("password") String password){
		return this.userService.getUserByEmail(email,password);
	}
	@PostMapping()
	public void postUser(@RequestBody User user) {
		this.userService.postUser(user);
	}
	
	@PutMapping("/{id}")
	public void updateUser(@RequestBody User user,@PathVariable("id") int id) {
		System.err.println("********************8"+user+id);
		this.userService.updateUser(user,id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		this.userService.deleteUser(id);
	}
}

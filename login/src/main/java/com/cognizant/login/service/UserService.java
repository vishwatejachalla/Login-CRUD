package com.cognizant.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.login.model.User;
import com.cognizant.login.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> getUsersList() {
		return userRepository.findAll();
	}

	public void postUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user,int id) {
		User updateUser=userRepository.findId(id);
		updateUser.setName(user.getName());
		updateUser.setEmail(user.getEmail());
		updateUser.setPassword(user.getPassword());
		updateUser.setDescription(user.getDescription());
		updateUser.setUpdatedBy(user.getUpdatedBy());
		updateUser.setUpdatedDate(user.getUpdatedDate());
//		System.err.println("************"+updateUser);
		userRepository.save(updateUser);		
	}
	
	public void deleteUser(int id) {
//		User userOne=userRepository.findByEmail(email);
		userRepository.deleteById(id);
	}

	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}

	public User getUserByEmail(String email,String password){
		return userRepository.findByEmail(email,password);
	}
}

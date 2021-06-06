package com.user.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.info.dto.User;
import com.user.info.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		return userRepository.findById(id).get();
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);	
	}
	
}

package com.peerlender.profile.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peerlender.profile.domain.model.User;
import com.peerlender.profile.domain.repository.UserRepository;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/users")
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping(value = "/user")
	public void newUser(@RequestBody final User user) {
		userRepository.save(user);
	}

	@PutMapping(value = "/user")
	public void updateUser(@RequestBody final User user) {
		userRepository.save(user);
	}
}

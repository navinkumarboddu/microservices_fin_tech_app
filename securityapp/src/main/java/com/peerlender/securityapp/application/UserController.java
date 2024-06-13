package com.peerlender.securityapp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peerlender.securityapp.user.exception.UserNotFoundException;
import com.peerlender.securityapp.user.model.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/validate")
	public String validateTokenAndGetUserName(@RequestHeader("Authorization") String token) {
		return userRepository.findById(token).orElseThrow(UserNotFoundException::new).getUsername();
	}

}

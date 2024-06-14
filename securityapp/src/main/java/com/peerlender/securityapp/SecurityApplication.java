package com.peerlender.securityapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.peerlender.securityapp.user.model.User;
import com.peerlender.securityapp.user.model.repository.UserRepository;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Bujji","2898_AD"));
		userRepository.save(new User("Bhairava","2898_AD"));
	}

}

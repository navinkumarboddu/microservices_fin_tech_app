package com.peerlender.profile;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.peerlender.profile.domain.model.User;
import com.peerlender.profile.domain.repository.UserRepository;

@SpringBootApplication
public class ProfileApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(ProfileApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProfileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Adding users:");
		userRepository.save(new User("Bujji", "Bujji", "Nag", 6000, "Robot", LocalDate.of(1, 6, 17)));
		userRepository.save(new User("Bhairava", "Bhairava", "Ashwin", 6000, "Savior", LocalDate.of(0, 1, 1)));
		logger.info("Adding users completed:");
	}
}

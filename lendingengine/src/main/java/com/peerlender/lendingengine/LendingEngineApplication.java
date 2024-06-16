package com.peerlender.lendingengine;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;

@SpringBootApplication
public class LendingEngineApplication implements CommandLineRunner {

	private static final Logger log =
			(Logger) LoggerFactory.getLogger(LendingEngineApplication.class);

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(LendingEngineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Bhairava","Bhairava", "Kannappa", 26, "Lord of world");
		userRepository.save(user);
		log.info("New user created :" + user);

		Optional<User> optionalUser = userRepository.findById("Bhairava");
		log.info("Found user :" + optionalUser.get());

		List<User> userList = userRepository.findAll();
		userList.stream().forEach(System.out::println);
	}

}

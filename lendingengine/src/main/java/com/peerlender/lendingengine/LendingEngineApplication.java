package com.peerlender.lendingengine;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.peerlender.lendingengine.domain.model.LoanUser;
import com.peerlender.lendingengine.domain.repository.LoanUserRepository;

@SpringBootApplication
public class LendingEngineApplication implements CommandLineRunner {

	private static final Logger log =
			(Logger) LoggerFactory.getLogger(LendingEngineApplication.class);

	@Autowired
	private LoanUserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(LendingEngineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LoanUser user = new LoanUser(1,"John", "Spareow", 26, "Worker");
		userRepository.save(user);
		log.info("New user created :" + user);

		Optional<LoanUser> optionalUser = userRepository.findById(1L);
		log.info("Found user :" + optionalUser.get());

		List<LoanUser> userList = userRepository.findAll();
		userList.stream().forEach(System.out::println);
	}

}

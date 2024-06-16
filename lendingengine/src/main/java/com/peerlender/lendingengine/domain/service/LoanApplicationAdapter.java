package com.peerlender.lendingengine.domain.service;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peerlender.lendingengine.application.model.LoanRequest;
import com.peerlender.lendingengine.domain.exception.UserNotFoundException;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;

@Component
public class LoanApplicationAdapter {

	@Autowired
	private UserRepository loanUserRepository;

	public LoanApplication transform(LoanRequest loanRequest, User borrower) {
		Optional<User> user = loanUserRepository.findById(borrower.getUserName());
		if (user.isPresent()) {
			return new LoanApplication(loanRequest.getAmount(), user.get(), loanRequest.getDaysToRepay(),
					loanRequest.getInterestRate());
		} else {
			throw new UserNotFoundException(borrower.getUserName());
		}
	}

}

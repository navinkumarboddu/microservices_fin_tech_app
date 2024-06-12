package com.peerlender.lendingengine.domain.service;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peerlender.lendingengine.application.model.LoanRequest;
import com.peerlender.lendingengine.domain.exception.UserNotFoundException;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.LoanUser;
import com.peerlender.lendingengine.domain.repository.LoanUserRepository;

@Component
public class LoanApplicationAdapter {

	@Autowired
	private LoanUserRepository loanUserRepository;

	public LoanApplication transform(LoanRequest loanRequest) {
		Optional<LoanUser> user = loanUserRepository.findById(loanRequest.getBorrowerId());
		if (user.isPresent()) {
			return new LoanApplication(loanRequest.getAmount(), user.get(), 
					loanRequest.getDaysToRepay(), loanRequest.getInterestRate());
		} else {
			throw new UserNotFoundException(loanRequest.getBorrowerId());
		}
	}

}

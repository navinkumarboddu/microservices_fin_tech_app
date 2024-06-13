package com.peerlender.lendingengine.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peerlender.lendingengine.domain.exception.LoanApplicationNotFoundException;
import com.peerlender.lendingengine.domain.exception.UserNotFoundException;
import com.peerlender.lendingengine.domain.model.Loan;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlender.lendingengine.domain.repository.LoanRepository;
import com.peerlender.lendingengine.domain.repository.UserRepository;

@Service
public class LoanService {

	@Autowired
	private LoanApplicationRepository loanApplicationRepository;

	@Autowired
	private UserRepository loanUserRepository;

	@Autowired
	private LoanRepository loanRepository;

	public void acceptLoan(final long loanApplicationId, final long lenderId) {
		Optional<User> loanUser = Optional
				.of(loanUserRepository.findById(lenderId).orElseThrow(() -> new UserNotFoundException(lenderId)));
		Optional<LoanApplication> loanApplication = Optional.of(loanApplicationRepository.findById(loanApplicationId)
				.orElseThrow(() -> new LoanApplicationNotFoundException(loanApplicationId)));

		loanRepository.save(new Loan(loanUser.get(), loanApplication.get()));
	}

	public List<Loan> getLoans() {
		return loanRepository.findAll();
	}
}

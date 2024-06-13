package com.peerlender.lendingengine.application;

import com.peerlender.lendingengine.application.model.LoanRequest;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import com.peerlender.lendingengine.domain.service.LoanApplicationAdapter;
import com.peerlender.lendingengine.domain.service.LoanService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	private final LoanApplicationRepository loanApplicationRepository;

	@Autowired
	private UserRepository loanUserRepository;

	@Autowired
	private LoanApplicationAdapter loanApplicationAdapter;

	@Autowired
	private LoanService loanService;

	@Autowired
	public LoanController(LoanApplicationRepository loanRequestRepository) {
		super();
		this.loanApplicationRepository = loanRequestRepository;
	}

	@PostMapping(value = "/loan/request")
	public void requestLoan(@RequestBody final LoanRequest loanRequest) {
		LoanApplication loanApplication = loanApplicationAdapter.transform(loanRequest);
		loanApplicationRepository.save(loanApplication);
	}

	@GetMapping(value = "/loan/requests")
	public List<LoanApplication> getLoans() {
		return loanApplicationRepository.findAll();
	}

	@GetMapping(value = "/users")
	public List<User> findUsers() {
		return loanUserRepository.findAll();
	}

	@PostMapping(value = "/loan/accept/{lenderId}/{loanApplicationId}")
	public void acceptLoan(@PathVariable final String lenderId, @PathVariable final String loanApplicationId) {
		loanService.acceptLoan(Long.parseLong(loanApplicationId), Long.parseLong(lenderId));
	}
}

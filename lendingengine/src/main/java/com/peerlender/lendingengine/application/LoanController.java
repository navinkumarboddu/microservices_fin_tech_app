package com.peerlender.lendingengine.application;

import com.peerlender.lendingengine.application.model.LoanRequest;
import com.peerlender.lendingengine.application.service.TokenValidationService;
import com.peerlender.lendingengine.domain.model.Loan;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import com.peerlender.lendingengine.domain.service.LoanApplicationAdapter;
import com.peerlender.lendingengine.domain.service.LoanService;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
	private TokenValidationService tokenValidationService;

	@Autowired
	public LoanController(LoanApplicationRepository loanRequestRepository) {
		super();
		this.loanApplicationRepository = loanRequestRepository;
	}

	@PostMapping(value = "/loan/request")
	public void requestLoan(@RequestBody final LoanRequest loanRequest, HttpServletRequest request) {
		User borrower = tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
		LoanApplication loanApplication = loanApplicationAdapter.transform(loanRequest, borrower);
		loanApplicationRepository.save(loanApplication);
	}

	@GetMapping(value = "/loan/requests")
	public List<LoanApplication> getLoans(HttpServletRequest request) {
		tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
		return loanApplicationRepository.findAll();
	}

	@GetMapping(value = "/users")
	public List<User> findUsers(HttpServletRequest request) {
		tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
		return loanUserRepository.findAll();
	}

	@PostMapping(value = "/loan/accept/{loanApplicationId}")
	public void acceptLoan(@PathVariable final String loanApplicationId, HttpServletRequest request) {
		User lender = tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
		loanService.acceptLoan(Long.parseLong(loanApplicationId), lender.getUserName());
	}

	@GetMapping(value = "/loans")
	public List<Loan> findLoans(HttpServletRequest request) {
		tokenValidationService.validateTokenAndGetUser(request.getHeader(HttpHeaders.AUTHORIZATION));
		return loanService.getLoans();
	}
}

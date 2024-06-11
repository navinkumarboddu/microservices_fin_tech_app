package com.peerlender.lendingengine.application;

import com.peerlender.lendingengine.application.model.LoanRequest;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.LoanUser;
import com.peerlender.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlender.lendingengine.domain.repository.LoanUserRepository;
import com.peerlender.lendingengine.domain.service.LoanApplicationAdapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	private final LoanApplicationRepository loanApplicationRepository;
	
	@Autowired
	private LoanUserRepository loanUserRepository;
	
	@Autowired
	private LoanApplicationAdapter  loanApplicationAdapter;

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
	
	@GetMapping(value="/users")
	public List<LoanUser> findUsers(){
		return loanUserRepository.findAll();
	}
}

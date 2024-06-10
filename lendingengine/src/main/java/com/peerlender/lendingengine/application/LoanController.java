package com.peerlender.lendingengine.application;

import com.peerlender.lendingengine.application.model.LoanRequest;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.LoanUser;
import com.peerlender.lendingengine.domain.repository.LoanRequestRepository;
import com.peerlender.lendingengine.domain.repository.LoanUserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	private final LoanRequestRepository loanRequestRepository;
	
	@Autowired
	private LoanUserRepository loanUserRepository;

	@Autowired
	public LoanController(LoanRequestRepository loanRequestRepository) {
		super();
		this.loanRequestRepository = loanRequestRepository;
	}

	@PostMapping(value = "/loan/request")
	public void requestLoan(@RequestBody final LoanRequest loanRequest) {
		System.out.println(loanRequest);
	}
	
	@GetMapping(value="/users")
	public List<LoanUser> findUsers(){
		return loanUserRepository.findAll();
	}
}

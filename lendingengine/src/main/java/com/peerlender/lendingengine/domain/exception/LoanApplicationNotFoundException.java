package com.peerlender.lendingengine.domain.exception;

public class LoanApplicationNotFoundException extends RuntimeException {

	public LoanApplicationNotFoundException(long applicationId) {
		super("Loan Application with id : " + applicationId + " not found...");
	}
}

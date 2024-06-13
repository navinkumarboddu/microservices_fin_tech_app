package com.peerlender.lendingengine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peerlender.lendingengine.domain.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}

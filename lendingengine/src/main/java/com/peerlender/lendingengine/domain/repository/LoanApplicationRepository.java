package com.peerlender.lendingengine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peerlender.lendingengine.domain.model.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long>{

}

package com.peerlender.lendingengine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peerlender.lendingengine.domain.model.LoanUser;

public interface LoanUserRepository extends JpaRepository<LoanUser, Long> {

}

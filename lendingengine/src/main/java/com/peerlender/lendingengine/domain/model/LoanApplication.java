package com.peerlender.lendingengine.domain.model;

import java.time.Duration;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public final class LoanApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int amount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "borrower_id")
	private User borrower;

	private int repaymentTimeInDays;

	private double interestRate;

	public LoanApplication() {
		super();
	}

	public LoanApplication(int amount, User borrower, int repaymentTimeInDays, double interestRate) {
		this.amount = amount;
		this.borrower = borrower;
		this.repaymentTimeInDays = repaymentTimeInDays;
		this.interestRate = interestRate;
	}

	public int getAmount() {
		return amount;
	}

	public User getBorrower() {
		return borrower;
	}

	public int getRepaymentTimeInDays() {
		return repaymentTimeInDays;
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public String toString() {
		return "LoanRequest{" + "amount=" + amount + ", borrower=" + borrower + ", repaymentTimeInDays=" + repaymentTimeInDays
				+ ", interestRate=" + interestRate + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LoanApplication that = (LoanApplication) o;
		return amount == that.amount && Double.compare(interestRate, that.interestRate) == 0
				&& Objects.equals(borrower, that.borrower) && Objects.equals(repaymentTimeInDays, that.repaymentTimeInDays);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, borrower, repaymentTimeInDays, interestRate);
	}
}

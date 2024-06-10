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

    private final int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id")
    private final LoanUser borrower;

    private final Duration repaymentTime;

    private final double interestRate;

    public LoanApplication(int amount, LoanUser borrower, Duration repaymentTime, double interestRate) {
        this.amount = amount;
        this.borrower = borrower;
        this.repaymentTime = repaymentTime;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public LoanUser getBorrower() {
        return borrower;
    }

    public Duration getRepaymentTime() {
        return repaymentTime;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", borrower=" + borrower +
                ", repaymentTime=" + repaymentTime +
                ", interestRate=" + interestRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanApplication that = (LoanApplication) o;
        return amount == that.amount && Double.compare(interestRate, that.interestRate) == 0 && Objects.equals(borrower, that.borrower) && Objects.equals(repaymentTime, that.repaymentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, borrower, repaymentTime, interestRate);
    }
}

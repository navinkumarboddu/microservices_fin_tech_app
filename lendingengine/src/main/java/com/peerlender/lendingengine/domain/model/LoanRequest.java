package com.peerlender.lendingengine.domain.model;

import java.time.Duration;
import java.util.Objects;

public final class LoanRequest {

    private final int amount;

    private final User borrower;

    private final Duration repaymentTime;

    private final double interestRate;

    public LoanRequest(int amount, User borrower, Duration repaymentTime, double interestRate) {
        this.amount = amount;
        this.borrower = borrower;
        this.repaymentTime = repaymentTime;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public User getBorrower() {
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
        LoanRequest that = (LoanRequest) o;
        return amount == that.amount && Double.compare(interestRate, that.interestRate) == 0 && Objects.equals(borrower, that.borrower) && Objects.equals(repaymentTime, that.repaymentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, borrower, repaymentTime, interestRate);
    }
}

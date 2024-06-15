package com.peerlender.lendingengine.application.model;

import java.util.Objects;

public class LoanRequest {

	private final int amount;

	private final String borrowerId;

	private final int daysToRepay;

	private final double interestRate;

	public LoanRequest(int amount, String borrowerId, int daysToRepay, double interestRate) {
		super();
		this.amount = amount;
		this.borrowerId = borrowerId;
		this.daysToRepay = daysToRepay;
		this.interestRate = interestRate;
	}

	public int getAmount() {
		return amount;
	}

	public String getBorrowerId() {
		return borrowerId;
	}

	public int getDaysToRepay() {
		return daysToRepay;
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LoanRequest that = (LoanRequest) o;
		return amount == that.amount && daysToRepay == that.daysToRepay
				&& Double.compare(interestRate, that.interestRate) == 0 && Objects.equals(borrowerId, that.borrowerId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, borrowerId, daysToRepay, interestRate);
	}

	@Override
	public String toString() {
		return "LoanRequest [amount=" + amount + ", borrowerId=" + borrowerId + ", daysToRepay=" + daysToRepay
				+ ", interestRate=" + interestRate + "]";
	}

}

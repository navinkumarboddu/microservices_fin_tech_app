package com.peerlender.lendingengine.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private User borrower;

	@ManyToOne
	private User lender;

	private int amount;

	private double interestRate;

	private LocalDate dateLent;

	private LocalDate dateDue;

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(User lender, LoanApplication loanApplication) {
		this.borrower = loanApplication.getBorrower();
		this.lender = lender;
		this.amount = loanApplication.getAmount();
		this.interestRate = loanApplication.getInterestRate();
		this.dateLent = LocalDate.now();
		this.dateDue = LocalDate.now().plusDays(loanApplication.getRepaymentTimeInDays());
	}

	public Loan(long id, User borrower, User lender, int amount, double interestRate, LocalDate dateLent,
			LocalDate dateDue) {
		super();
		this.id = id;
		this.borrower = borrower;
		this.lender = lender;
		this.amount = amount;
		this.interestRate = interestRate;
		this.dateLent = dateLent;
		this.dateDue = dateDue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getBorrower() {
		return borrower;
	}

	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}

	public User getLender() {
		return lender;
	}

	public void setLender(User lender) {
		this.lender = lender;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public LocalDate getDateLent() {
		return dateLent;
	}

	public void setDateLent(LocalDate dateLent) {
		this.dateLent = dateLent;
	}

	public LocalDate getDateDue() {
		return dateDue;
	}

	public void setDateDue(LocalDate dateDue) {
		this.dateDue = dateDue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, borrower, dateDue, dateLent, id, interestRate, lender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return amount == other.amount && Objects.equals(borrower, other.borrower)
				&& Objects.equals(dateDue, other.dateDue) && Objects.equals(dateLent, other.dateLent) && id == other.id
				&& Double.doubleToLongBits(interestRate) == Double.doubleToLongBits(other.interestRate)
				&& Objects.equals(lender, other.lender);
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", borrower=" + borrower + ", lender=" + lender + ", amount=" + amount
				+ ", interestRate=" + interestRate + ", dateLent=" + dateLent + ", dateDue=" + dateDue + "]";
	}

}

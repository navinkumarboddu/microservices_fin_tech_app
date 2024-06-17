package com.peerlender.profile.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`user`")
public final class User {

	@Id
	private String userName;

	private String firstName;

	private String lastName;

	private int age;

	private String occupation;

	private LocalDate registerSince;

	public User() {
	}

	public User(String userName, String firstName, String lastName, int age, String occupation,
			LocalDate registerSince) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.occupation = occupation;
		this.registerSince = registerSince;
	}

	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getOccupation() {
		return occupation;
	}

	public LocalDate getRegisterSince() {
		return registerSince;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", occupation=" + occupation + ", registerSince=" + registerSince + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, firstName, lastName, occupation, registerSince, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(occupation, other.occupation)
				&& Objects.equals(registerSince, other.registerSince) && Objects.equals(userName, other.userName);
	}

}
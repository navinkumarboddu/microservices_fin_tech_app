package com.peerlender.profile.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peerlender.profile.domain.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}

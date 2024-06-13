package com.peerlender.securityapp.user.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peerlender.securityapp.user.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}

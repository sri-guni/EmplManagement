package com.sri.empmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.empmgmt.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String userName);
}

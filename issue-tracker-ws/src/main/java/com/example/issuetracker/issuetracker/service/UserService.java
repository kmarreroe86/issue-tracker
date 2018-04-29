package com.example.issuetracker.issuetracker.service;

import java.util.List;

import com.example.issuetracker.issuetracker.model.User;

public interface UserService {

	User findById(Long id);

	User findByName(String userName);

	User save(User newUser);

	List<User> findAll();

	void deleteById(Long id);

}
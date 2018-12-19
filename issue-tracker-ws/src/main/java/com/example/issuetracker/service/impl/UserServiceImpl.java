package com.example.issuetracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.issuetracker.model.User;
import com.example.issuetracker.repository.UserRepository;
import com.example.issuetracker.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User findByName(String userName) {
		return repository.findByUsername(userName);
	}

	@Override
	public JpaRepository<User, Long> getDao() {
		return repository;
	}

}

package com.example.issuetracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.issuetracker.model.User;
import com.example.issuetracker.repository.UserRepository;
import com.example.issuetracker.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	
	@Override
	public User findById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public User findByName(String userName) {
		return repository.findByUsername(userName);
	}

	@Override
	public User save(User newUser) {
		User savedUser = repository.save(newUser);
		return savedUser;
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

}

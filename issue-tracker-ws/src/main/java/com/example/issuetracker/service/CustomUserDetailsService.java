package com.example.issuetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.issuetracker.model.CustomUserDetails;
import com.example.issuetracker.model.User;
import com.example.issuetracker.repository.UserRepository;

@Service(value = "userService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);

		if (user == null)
			throw new UsernameNotFoundException("Username not found");
		return new CustomUserDetails(user);
	}

}

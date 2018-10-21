package com.example.issuetracker.service;

import com.example.issuetracker.model.User;

public interface UserService extends Operations<User>{

	User findByName(String userName);

}

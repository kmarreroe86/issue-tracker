package com.example.issuetracker.issuetracker.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.issuetracker.model.User;
import com.example.issuetracker.issuetracker.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.findAll();

		if (users.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}

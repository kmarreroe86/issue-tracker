package com.example.issuetracker.web.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.model.CustomUserDetails;
import com.example.issuetracker.model.User;
import com.example.issuetracker.service.UserService;
import com.example.issuetracker.viewmodel.UserViewModel;

@CrossOrigin(origins = "*", maxAge = 3600)
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

	@GetMapping(value = "/userdata/")
	public ResponseEntity<UserViewModel> getUserData(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null)
			return new ResponseEntity<UserViewModel>(HttpStatus.NO_CONTENT);

		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		UserViewModel user = new UserViewModel(userDetails.getId(), userDetails.getUsername(),
				userDetails.getStringRole().toString());

		return new ResponseEntity<UserViewModel>(user, HttpStatus.OK);

	}
}

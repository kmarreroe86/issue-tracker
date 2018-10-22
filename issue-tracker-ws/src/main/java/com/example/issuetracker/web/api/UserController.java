package com.example.issuetracker.web.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
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
import com.example.issuetracker.model.Project;
import com.example.issuetracker.model.User;
import com.example.issuetracker.resource.UserResource;
import com.example.issuetracker.resource.UserResourceAssembler;
import com.example.issuetracker.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@ExposesResourceFor(CustomUserDetails.class)
//@RequestMapping(value = "/order", produces = "application/json")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserResourceAssembler assembler;

	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.findAll();

		if (users.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping(value = "/userdata/")
	public ResponseEntity<UserResource> getUserData(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null)
			return new ResponseEntity<UserResource>(HttpStatus.NO_CONTENT);

		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();		
		/*UserResource user = new UserResource(userDetails.getId(), userDetails.getUsername(),
				userDetails.getStringRole().toString());*/
//		User u = (User)userDetails;

		return new ResponseEntity<UserResource>(assembler.toResource(userDetails), HttpStatus.OK);

	}
}

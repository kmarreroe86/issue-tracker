package com.example.issuetracker.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.config.TokenProvider;
import com.example.issuetracker.model.AuthToken;
import com.example.issuetracker.model.User;
import com.example.issuetracker.model.UserLogin;
import com.example.issuetracker.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenProvider jwtTokenUtil;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody UserLogin loginUser) throws AuthenticationException {
		System.out.println("Authentication.register:" + System.currentTimeMillis());
		System.out.println("loginUser.getUsername:" + loginUser.getUsername());
		System.out.println("loginUser.getPassword:" + loginUser.getPassword());

		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginUser.getUsername(), 
						loginUser.getPassword()
						)
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
//		final User user = userService.findByName(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(authentication);
		
		return ResponseEntity.ok(new AuthToken(token));
	}

}

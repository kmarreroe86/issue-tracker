package com.example.issuetracker.resource;

import org.springframework.hateoas.ResourceSupport;

import com.example.issuetracker.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResource extends ResourceSupport {
	private final long id;

	private final String username;

	private final String role;
	
	public UserResource(User user) {
		id = user.getId();
		username = user.getUsername();
		role = user.getRol().toString();
	}

	/*public UserResource(Long id, String username, String role) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
	}*/
	
	@JsonProperty("id")
	public Long getResourceId() {
		return id;
	}

	public String getUsername() {
		return username;
	}	

	public String getRole() {
		return role;
	}	

}

package com.example.issuetracker.issuetracker.viewmodel;

public class UserViewModel {
	private Long id;

	private String username;

	private String role;

	public UserViewModel(Long id, String username, String role) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

}

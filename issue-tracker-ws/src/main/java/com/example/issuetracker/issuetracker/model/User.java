package com.example.issuetracker.issuetracker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRol rol;
	
	private boolean active;
	
	private String email;

	@OneToMany(mappedBy = "user")
	private Set<Issue> issueList = new HashSet<>();

	@ManyToMany(mappedBy = "users", // -> mappedBy takes value of the list in the owner side.
			fetch = FetchType.LAZY,
			cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            })
//	@JsonIgnore
	private Set<Project>projects = new HashSet<>();

	public User() {	}
	
	public User(User u) {
		this.id = u.getId();
		this.active = u.isActive();
		this.email = u.getEmail();
		this.username = u.getUsername();		
		this.password = u.getPassword();
		this.rol = u.getRol();
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRol getRol() {
		return rol;
	}

	public void setRol(UserRol rol) {
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}
	
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

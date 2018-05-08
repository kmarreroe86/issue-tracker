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

	@Enumerated(EnumType.STRING)
	private UserRol rol;

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

	public User() {

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

}

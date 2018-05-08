package com.example.issuetracker.issuetracker.service;

import java.util.List;

import com.example.issuetracker.issuetracker.model.Project;
import com.example.issuetracker.issuetracker.model.User;

public interface ProjectService {

	Project findById(Long id);

	Project findByName(String projectName);

	Project save(Project newProject);

	List<Project> findAll();
	
	List<Project> findProjectsByUserId(Long userId);

	void deleteById(Long id);
	
	void addUsersToProject(Long projectID, List<User> userList);

}

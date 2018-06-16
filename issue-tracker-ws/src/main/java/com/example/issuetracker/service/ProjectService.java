package com.example.issuetracker.service;

import java.util.List;

import com.example.issuetracker.model.Project;
import com.example.issuetracker.model.User;
import com.example.issuetracker.viewmodel.ProjectViewModel;

public interface ProjectService {

	ProjectViewModel findById(Long id);

	Project findByName(String projectName);

	Project save(Project newProject);

	List<Project> findAll();
	
	List<ProjectViewModel> findProjectsByUserId(Long userId);

	void deleteById(Long id);
	
	void addUsersToProject(Long projectID, List<User> userList);

}

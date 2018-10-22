package com.example.issuetracker.service;

import java.util.List;

import com.example.issuetracker.model.Project;
import com.example.issuetracker.resource.ProjectResource;

public interface ProjectService extends Operations<Project> {
	
	/*Project findById(Long id);

	Project findByName(String projectName);

	Project save(Project newProject);

	List<Project> findAll();
	
	List<ProjectViewModel> findProjectsByUserId(Long userId);

	void deleteById(Long id);
	
	void addUsersToProject(Long projectID, List<User> userList);*/
	
	/* Add to the interface*/
	List<Project> findProjectsByUserId(Long userId);
//	public Project findByName(String projectName)
//	public void addUsersToProject(Long projectID, List<User> userList)

}

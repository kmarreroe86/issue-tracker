package com.example.issuetracker.repository;

import java.util.List;

import com.example.issuetracker.model.Project;

public interface CustomProjectRepository {
	
	List<Project> getProjectsByUserId(Long userid);

}

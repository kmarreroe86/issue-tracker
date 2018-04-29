package com.example.issuetracker.issuetracker.service;

import java.util.List;

import com.example.issuetracker.issuetracker.model.Project;

public interface ProjectService {

	Project findById(Long id);

	Project findByName(String projectName);

	Project save(Project newProject);

	List<Project> findAll();

	void deleteById(Long id);

}

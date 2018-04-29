package com.example.issuetracker.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.issuetracker.issuetracker.model.Project;
import com.example.issuetracker.issuetracker.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository repository;

	@Override
	public Project findById(Long id) {		
		return repository.getOne(id);
	}

	@Override
	public Project findByName(String projectName) {
		return repository.findByProjectName(projectName);
	}

	@Override
	public Project save(Project newProject) {
		Project savedProject = repository.save(newProject);
		return savedProject;
	}

	@Override
	public List<Project> findAll() {		
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}

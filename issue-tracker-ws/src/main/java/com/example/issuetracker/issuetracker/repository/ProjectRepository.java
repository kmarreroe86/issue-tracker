package com.example.issuetracker.issuetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.issuetracker.issuetracker.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	Project findByProjectName(String projectName);
	

}

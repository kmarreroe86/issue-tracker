package com.example.issuetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.issuetracker.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	Project findByProjectName(String projectName);
	
	List<Project> findByUsers_Id(Long id);
	

}
package com.example.issuetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.issuetracker.model.Issue;
import com.example.issuetracker.model.Project;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
	
	// TODO: Remove this method. Not been used.
	List<Issue> findByProjectId(Project project);

}

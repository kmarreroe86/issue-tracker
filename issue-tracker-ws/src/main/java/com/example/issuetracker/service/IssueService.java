package com.example.issuetracker.service;

import java.util.List;

import com.example.issuetracker.model.Issue;

public interface IssueService {
	
	List<Issue> findAll();
	
	Issue createIssue(Issue issue);

}

package com.example.issuetracker.issuetracker.service;

import java.util.List;

import com.example.issuetracker.issuetracker.model.Issue;

public interface IssueService {
	
	List<Issue> findAll();
	
	Issue createIssue(Issue issue);

}

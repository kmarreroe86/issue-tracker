package com.example.issuetracker.service;

import java.util.List;

import com.example.issuetracker.model.Issue;
import com.example.issuetracker.viewmodel.IssueViewModel;

public interface IssueService {
	
	List<Issue> findAll();
	
	Issue createIssue(Issue issue);
	
	IssueViewModel updateIssue(IssueViewModel issue);
	
	/*List<IssueViewModel> getProjectIssues(Project project);*/

}

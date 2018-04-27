package com.example.issuetracker.issuetracker.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.issuetracker.issuetracker.model.Issue;
import com.example.issuetracker.issuetracker.model.IssuePriority;
import com.example.issuetracker.issuetracker.model.IssueStatus;
import com.example.issuetracker.issuetracker.repository.IssueRepository;

@Service
public class IssueServiceImpl implements IssueService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IssueRepository repository;

	public List<Issue> findAll() {
		logger.info("> findAll");

		List<Issue> issues = repository.findAll();

		logger.info("< findAll");
		return issues;
	}

	@Override
	public Issue createIssue(Issue issue) {
		
		logger.info("> Create");
		issue.setStatus(IssueStatus.OPEN);
		if(issue.getPriority() == null) issue.setPriority(IssuePriority.MEDIUM);
		
		Issue persistedIssue = repository.save(issue);
		
		return persistedIssue;		
	}
	
	

}

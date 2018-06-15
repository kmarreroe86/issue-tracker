package com.example.issuetracker.web.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.model.Issue;
import com.example.issuetracker.service.IssueService;

@RestController
public class IssueController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());	
	@Autowired
	private IssueService issueService;
	
	@GetMapping("/issues/")
	public ResponseEntity<List<Issue>> getAllIssues() {
		List<Issue> issues = null;
		
		try {
			issues = issueService.findAll();
			if(issues == null) issues = new ArrayList<>();
		} catch (Exception e) {
			logger.error("An error ocurred\n");
			logger.error(e.getMessage());
			return new ResponseEntity<List<Issue>>(issues, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
	}
	
	@PostMapping(value="/issue", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Issue> createIssue(@RequestBody Issue issue) {
		logger.info("> createIssue");
		Issue createdIssue = null;
		try {
			createdIssue = issueService.createIssue(issue);
		} catch (Exception e) {
			logger.error("Unexpected exception caught: " + e);
			return new ResponseEntity<Issue>(createdIssue, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Issue>(createdIssue, HttpStatus.OK);
	}
}

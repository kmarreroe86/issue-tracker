package com.example.issuetracker.web.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.model.Issue;
import com.example.issuetracker.resource.IssueResource;
import com.example.issuetracker.service.IssueService;
import com.example.issuetracker.util.IssueResourceAssembler;

@CrossOrigin(origins = "*", maxAge = 3600)
@ExposesResourceFor(Issue.class)
@RestController
@RequestMapping(value = "/issue", produces = "application/json")
public class IssueController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IssueService issueService;

	@Autowired
	private IssueResourceAssembler assembler;	

	@GetMapping("/list/")
	public ResponseEntity<Collection<IssueResource>> getAllIssues() {
		List<Issue> issues = null;

		try {
			issues = issueService.findAll();
			if (issues == null) issues = new ArrayList<>();
		} catch (Exception e) {
			logger.error("An error ocurred\n");
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Collection<IssueResource>>(assembler.toResourceCollection(issues), HttpStatus.OK);
	}

	// TODO: Re-Implement this.
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<IssueResource> createIssue(@RequestBody IssueResource model) {
		logger.info("> createIssue");
		Issue createdIssue = null;
		try {
			createdIssue = issueService.create(new Issue());
		} catch (Exception e) {
			logger.error("Unexpected exception caught: " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<IssueResource>(assembler.toResource(createdIssue), HttpStatus.OK);
	}

//	@PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
	@PostMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<IssueResource> changeIssueStatus(@PathVariable("id") final long id, @RequestBody Issue modelFromRequest) {

		try {
			Issue issue = new Issue(modelFromRequest, id);
			Issue updatedIssue = issueService.update(issue);
			return new ResponseEntity<IssueResource>(assembler.toResource(updatedIssue), HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Unexpected exception caught on changing issue status: " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}

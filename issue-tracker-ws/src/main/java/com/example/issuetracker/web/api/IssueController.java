package com.example.issuetracker.web.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.model.Issue;
import com.example.issuetracker.model.IssuePriority;
import com.example.issuetracker.model.IssueStatus;
import com.example.issuetracker.model.IssueType;
import com.example.issuetracker.model.Project;
import com.example.issuetracker.service.IssueService;
import com.example.issuetracker.service.ProjectService;
import com.example.issuetracker.viewmodel.IssueViewModel;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class IssueController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IssueService issueService;
	
	@Autowired
	private ProjectService projectService;

	/*@Autowired
	private ProjectService projectService;*/

	@GetMapping("/issues/")
	public ResponseEntity<List<Issue>> getAllIssues() {
		List<Issue> issues = null;

		try {
			issues = issueService.findAll();
			if (issues == null) issues = new ArrayList<>();
		} catch (Exception e) {
			logger.error("An error ocurred\n");
			logger.error(e.getMessage());
			return new ResponseEntity<List<Issue>>(issues, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
	}

	@PostMapping(value = "/issue", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Issue> createIssue(@RequestBody IssueViewModel model) {
		logger.info("> createIssue");
		Issue createdIssue = null;
		try {			
			createdIssue = issueService.create(entityIssueBuilder(model));
		} catch (Exception e) {
			logger.error("Unexpected exception caught: " + e);
			return new ResponseEntity<Issue>(createdIssue, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Issue>(createdIssue, HttpStatus.OK);
	}

	@PutMapping(value = "/modify/issue/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<IssueViewModel> changeIssueStatus(@RequestBody IssueViewModel model) {

		try {
			Issue entity = entityIssueBuilder(model);
			IssueViewModel updatedIssue = issueViewModelBuilder(issueService.update(entity));
			return new ResponseEntity<IssueViewModel>(updatedIssue, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Unexpected exception caught on changing issue status: " + e);
			return new ResponseEntity<IssueViewModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Issue entityIssueBuilder(IssueViewModel model) {

		Issue entity = new Issue();
		entity.setId(model.getId());
		entity.setTitle(model.getTitle());
		entity.setDescription(model.getDescription());
		entity.setCreatedDate(model.getCreatedDate());
		entity.setModifiedDate(new Date());
		entity.setPriority(IssuePriority.valueOf(model.getIssuePriority()));
		entity.setStatus(IssueStatus.valueOf(model.getIssueStatus()));
		entity.setStoryPoints(model.getStoryPoints());
		entity.setType(IssueType.valueOf(model.getIssueType()));
		entity.setProject(projectService.findOne(model.getProjectId()));
		entity.setAssignedUserId(model.getAssignedUserId());

		return entity;
	}

	private IssueViewModel issueViewModelBuilder(Issue entity) {

		return new IssueViewModel(entity.getId(), entity.getTitle(), entity.getDescription(),
				entity.getPriority().toString(), entity.getStatus().toString(), entity.getStoryPoints(),
				entity.getType().toString(), entity.getCreatedDate(), entity.getProject().getId(), entity.getId());
	}
}

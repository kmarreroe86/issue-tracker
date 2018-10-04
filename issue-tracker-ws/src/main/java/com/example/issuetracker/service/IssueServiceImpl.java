package com.example.issuetracker.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.issuetracker.model.Issue;
import com.example.issuetracker.model.IssuePriority;
import com.example.issuetracker.model.IssueStatus;
import com.example.issuetracker.model.IssueType;
import com.example.issuetracker.repository.IssueRepository;
import com.example.issuetracker.repository.ProjectRepository;
import com.example.issuetracker.repository.UserRepository;
import com.example.issuetracker.viewmodel.IssueViewModel;

@Service
public class IssueServiceImpl implements IssueService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IssueRepository repository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Issue> findAll() {
		logger.info("> findAll");

		List<Issue> issues = repository.findAll();

		logger.info("< findAll");
		return issues;
	}

	@Override
	public Issue createIssue(Issue issue) {

		logger.info("> Create");
		issue.setStatus(IssueStatus.TODO);
		if (issue.getPriority() == null) issue.setPriority(IssuePriority.MEDIUM);

		Issue persistedIssue = repository.save(issue);

		return persistedIssue;
	}

	public IssueViewModel updateIssue(IssueViewModel model) {
		if (model == null) return null;

		Issue entity = entityIssueBuilder(model);
		entity = repository.save(entity);

		return issueViewModelBuilder(entity);
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
		entity.setProject(projectRepository.getOne(model.getProjectId()));
		entity.setUser(userRepository.getOne(model.getAssignedUserId()));

		return entity;
	}

	private IssueViewModel issueViewModelBuilder(Issue entity) {

		return new IssueViewModel(entity.getId(), entity.getTitle(), entity.getDescription(),
				entity.getPriority().toString(), entity.getStatus().toString(), entity.getStoryPoints(),
				entity.getType().toString(), entity.getCreatedDate(), entity.getProject().getId(),
				entity.getUser().getId());
	}

}

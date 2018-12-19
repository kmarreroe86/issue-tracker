package com.example.issuetracker.resource;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.hateoas.ResourceSupport;

import com.example.issuetracker.model.Issue;
import com.example.issuetracker.model.Project;
import com.example.issuetracker.model.UserRol;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectResource extends ResourceSupport {
	private final long id;

	private final String projectName;

	private final String projectKey;

	private final UserResource projectLead;

	private final String url;

	private final Set<IssueResource> issues;
	
	public ProjectResource(Project project) {
		super();
		this.id = project.getId();
		this.projectName = project.getProjectName();
		this.projectKey = project.getProjectKey();
		this.projectLead = new UserResource(project.getUsers().stream().filter(u -> u.getRol().equals(UserRol.PO)).findFirst().get());
		this.url = project.getUrl();
//		this.issues = new HashSet<>();
		this.issues = project.getProject_issues().stream().map(i -> new IssueResource(i)).collect(Collectors.toSet());
		/*Set<IssueResource> set1 = new HashSet<>();
		for (Issue issue : project.getProject_issues()) {
			IssueResource res = new IssueResource(issue);
			set1.add(res);
		}
		this.issues = set1;
		System.out.println("Do nothig");*/
	}

	/*public ProjectResource(Long id, String projectName, String projectKey, UserResource projectLead, String url) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectKey = projectKey;
		this.projectLead = projectLead;
		this.url = url;
		this.issues = new HashSet<>();
	}*/
	
	@JsonProperty("id")
	public Long getResourceId() {
		return id;
	}

	public String getProjectName() {
		return projectName;
	}
	
	public String getProjectKey() {
		return projectKey;
	}
	
	public UserResource getProjectLead() {
		return projectLead;
	}	

	public String getUrl() {
		return url;
	}	

	public Set<IssueResource> getIssues() {
		return issues;
	}

}

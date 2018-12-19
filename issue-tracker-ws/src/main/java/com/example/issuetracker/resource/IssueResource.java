package com.example.issuetracker.resource;

import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.ResourceSupport;

import com.example.issuetracker.model.Issue;
import com.example.issuetracker.model.Project;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueResource extends ResourceSupport {

	private  Long id;

	private  String title;

	private  String description;

	private  String issuePriority;

	private  String issueStatus;

	private  String issueType;

	private  int storyPoints;

	private  Date createdDate;
	
	private Date modifiedDate;

//	private final Long projectId;
	private final Project project;

	private Long assignedUserId;

	/*
	 * public IssueResource(Long id, String title, String description, String
	 * issuePriority, String issueStatus, int storyPoints, String issueType, Date
	 * createdDate, Long projectId, Long assignedUser) { super(); this.id = id;
	 * this.title = title; this.description = description; this.issuePriority =
	 * issuePriority; this.issueStatus = issueStatus; this.storyPoints =
	 * storyPoints; this.issueType = issueType; this.createdDate = createdDate;
	 * this.projectId = projectId; this.assignedUserId = assignedUser; }
	 */
	
//	public IssueResource() {}

	public IssueResource(Issue issue) {
		this.id = issue.getId();
		this.title = issue.getTitle();
		this.description = issue.getDescription();
		this.issuePriority = issue.getPriority().toString();
		this.issueStatus = issue.getStatus().toString();
		this.storyPoints = issue.getStoryPoints();
		this.issueType = issue.getType().toString();
		this.createdDate = issue.getCreatedDate();
		this.modifiedDate = issue.getModifiedDate();
		this.project = issue.getProject();
		this.assignedUserId = issue.getAssignedUserId();
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getIssuePriority() {
		return issuePriority;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}

	@JsonProperty("id")
	public Long getResourceId() {
		return id;
	}

	public String getIssueType() {
		return issueType;
	}

	public Project getProject() {
		return project;
	}

	public Long getAssignedUserId() {
		return assignedUserId;
	}
	
	// Two IssueResource are equal if their IDs are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssueResource resource = (IssueResource) o;
        return getResourceId() == resource.getResourceId();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

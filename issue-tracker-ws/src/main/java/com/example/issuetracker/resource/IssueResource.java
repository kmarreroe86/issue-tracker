package com.example.issuetracker.resource;

import java.util.Date;

public class IssueResource {

	private Long id;

	private String title;

	private String description;

	private String issuePriority;

	private String issueStatus;

	private String issueType;

	private int storyPoints;

	private Date createdDate;
	
	private Long projectId;
	
	private Long assignedUserId;

	public IssueResource(Long id, String title, String description, String issuePriority, String issueStatus,
			int storyPoints, String issueType, Date createdDate, Long projectId, Long assignedUser) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.issuePriority = issuePriority;
		this.issueStatus = issueStatus;
		this.storyPoints = storyPoints;
		this.issueType = issueType;
		this.createdDate = createdDate;
		this.projectId = projectId;
		this.assignedUserId = assignedUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIssuePriority() {
		return issuePriority;
	}

	public void setIssuePriority(String issuePriority) {
		this.issuePriority = issuePriority;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getAssignedUserId() {
		return assignedUserId;
	}

	public void setAssignedUserId(Long assignedUserId) {
		this.assignedUserId = assignedUserId;
	}

}

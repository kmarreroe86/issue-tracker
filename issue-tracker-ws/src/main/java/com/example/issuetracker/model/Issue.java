package com.example.issuetracker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "issues")
public class Issue implements Serializable, Identifiable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	@Column(name = "issue_type")
//	@Enumerated(EnumType.STRING)
//	private IssueType issueType;
	private String issueType;

//	@Enumerated(EnumType.STRING)
//	private IssuePriority priority;
	private String priority;

//	@Enumerated(EnumType.STRING)
//	private IssueStatus status;
	private String status;

	@Column(name = "story_points")
	private int storyPoints;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "modified_date")
	private Date modifiedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	@JsonIgnore
	private Project project;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id", nullable = true)
//	@JsonIgnore
//	private User user;
	private Long assignedUserId;

	public Issue() {

	}
	
	public Issue(final Issue issue, final Long id){
		this.setId(id);
		this.setAssignedUserId(issue.getAssignedUserId());
		this.setCreatedDate(issue.getCreatedDate());
		this.setDescription(issue.getDescription());		
		
		this.setModifiedDate(new Date());
		this.setPriority(issue.getPriority());
		this.setStatus(issue.getStatus());
		this.setStoryPoints(issue.getStoryPoints());
		this.setTitle(issue.getTitle());
		this.setType(issue.getType());
		this.setProject(issue.getProject());
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

	public String getType() {
		return issueType;
	}

	public void setType(String type) {
		this.issueType = type;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public void setAssignedUserId(Long user) {
		this.assignedUserId = user;
	}

	public Project getProject() {
		return project;
	}

	public Long getAssignedUserId() {
		return assignedUserId;
	}

}

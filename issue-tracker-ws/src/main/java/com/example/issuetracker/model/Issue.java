package com.example.issuetracker.model;

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
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	@Column(name = "issue_type")
	@Enumerated(EnumType.STRING)
	private IssueType issueType;

	@Enumerated(EnumType.STRING)
	private IssuePriority priority;

	@Enumerated(EnumType.STRING)
	private IssueStatus status;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = true)
	@JsonIgnore
	private User user;

	public Issue() {

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

	public IssueType getType() {
		return issueType;
	}

	public void setType(IssueType type) {
		this.issueType = type;
	}

	public IssuePriority getPriority() {
		return priority;
	}

	public void setPriority(IssuePriority priority) {
		this.priority = priority;
	}

	public IssueStatus getStatus() {
		return status;
	}

	public void setStatus(IssueStatus status) {
		this.status = status;
	}

	public long getId() {
		return id;
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

}

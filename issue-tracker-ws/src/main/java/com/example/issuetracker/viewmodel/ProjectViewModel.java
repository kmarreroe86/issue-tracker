package com.example.issuetracker.viewmodel;

public class ProjectViewModel {
	private Long id;

	private String projectName;

	private String projectKey;

	private UserViewModel projectLead;
	
	private String url;

	public ProjectViewModel(Long id, String projectName, String projectKey, UserViewModel projectLead, String url) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectKey = projectKey;
		this.projectLead = projectLead;
		this.url = url;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public UserViewModel getProjectLead() {
		return projectLead;
	}

	public void setProjectLead(UserViewModel projectLead) {
		this.projectLead = projectLead;
	}

	public Long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

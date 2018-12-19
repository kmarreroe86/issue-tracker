package com.example.issuetracker.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.OneToMany;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Doc:
 * https://dzone.com/articles/calling-stored-procedures-from-spring-data-jpa
 * https://medium.com/@senanayake.kalpa/calling-stored-procedure-using-spring-jpa-ee37fa58ca2d
 * https://social.msdn.microsoft.com/Forums/sqlserver/en-US/1ba119e2-8c42-4a02-83af-5c3aa0856405/using-stored-procedure-to-insert-data-and-return-value?forum=transactsql
 * https://www.baeldung.com/jpa-stored-procedures
 */
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getProjectsByUserId", procedureName = "sp_get_projects_by_userId", resultClasses = Project.class, 
				parameters = {
				@StoredProcedureParameter(name = "i_userid", type = Long.class, mode = ParameterMode.IN) }
		)
})
@Entity
@Table(name = "projects")
public class Project implements Serializable, Identifiable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "project_key")
	private String projectKey;

	private String url;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<Issue> project_issues = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "project_user", joinColumns = {
			@JoinColumn(name = "project_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", referencedColumnName = "id") })
//	@JsonIgnore
	private Set<User> users = new HashSet<>();

	public Project() {
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getId() {
		return id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Issue> getProject_issues() {
		return project_issues;
	}

	public void setProject_issues(Set<Issue> project_issues) {
		this.project_issues = project_issues;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}

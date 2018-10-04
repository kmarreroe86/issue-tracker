package com.example.issuetracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.issuetracker.model.CustomUserDetails;
import com.example.issuetracker.model.Project;
import com.example.issuetracker.model.User;
import com.example.issuetracker.model.UserRol;
import com.example.issuetracker.repository.ProjectRepository;
import com.example.issuetracker.viewmodel.IssueViewModel;
import com.example.issuetracker.viewmodel.ProjectViewModel;
import com.example.issuetracker.viewmodel.UserViewModel;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository repository;

	@Override
	public ProjectViewModel findById(Long id) {
		Project project = repository.getOne(id);
		
		// TODO: Get the user for this project		
		return project == null ? null : projectViewModelBuilder(project); 
	}	

	@Override
	public Project findByName(String projectName) {
		return repository.findByProjectName(projectName);
	}

	@Override
	public Project save(Project newProject) {
		Project savedProject = repository.save(newProject);
		return savedProject;
	}

	@Override
	public List<Project> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void addUsersToProject(Long projectID, List<User> userList) {
		Project currentProject = repository.getOne(projectID);

		if (currentProject == null) return;

		currentProject.getUsers().addAll(userList);
		repository.save(currentProject);
	}

	public List<ProjectViewModel> findProjectsByUserId(Long userId) {
		List<Project> projects = repository.findByUsers_Id(userId);
		List<ProjectViewModel> projectListsViewModel = new ArrayList<>();
		UserViewModel u = null;

		for (Project project : projects) {
			Optional<User> projectLead = project.getUsers().stream().filter(pl -> pl.getRol() == UserRol.PO)
					.findFirst();
			if (projectLead.isPresent()) {
				u = new UserViewModel(projectLead.get().getId(), projectLead.get().getUsername(),
						projectLead.get().getRol().toString());
			}

			ProjectViewModel proViewModel = new ProjectViewModel(project.getId(), project.getProjectName(),
					project.getProjectKey(), u, project.getUrl());
			projectListsViewModel.add(proViewModel);
		}
		return projectListsViewModel;
	}

	// TODO: Remove this issue. Not been used. Refactor interface
	@Override
	public Project findEntityProjectById(Long id) {
		return repository.getOne(id);
	}
	
	private ProjectViewModel projectViewModelBuilder(Project projectEntity) {		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Long assignedUserId = ((CustomUserDetails) auth.getPrincipal()).getId();
		
		
		ProjectViewModel model = new ProjectViewModel(projectEntity.getId(), projectEntity.getProjectName(),
				projectEntity.getProjectKey(), null, projectEntity.getUrl());
		
		Set<IssueViewModel> issues = projectEntity.getProject_issues().parallelStream().map(i -> 
			new IssueViewModel(
					i.getId(), 
					i.getTitle(), 
					i.getDescription(), 
					i.getPriority().toString(), 
					i.getStatus().toString(), 
					i.getStoryPoints(), 
					i.getType().toString(),
					i.getCreatedDate(),
					projectEntity.getId(),
					assignedUserId)).collect(Collectors.toSet());
		
		model.setIssues(issues);		
		
		return model;
	}

}

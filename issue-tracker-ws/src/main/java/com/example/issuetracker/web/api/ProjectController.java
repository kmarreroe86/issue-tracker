package com.example.issuetracker.web.api;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.model.Project;
import com.example.issuetracker.service.ProjectService;
import com.example.issuetracker.viewmodel.IssueViewModel;
import com.example.issuetracker.viewmodel.ProjectViewModel;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

//    @PreAuthorize("hasRole('ADMIN')")
	@Secured({"ROLE_DEVELOPER", "ROLE_QA", "ROLE_PO", "ROLE_DESIGNER"})
	@RequestMapping(value = "/projects/", method = RequestMethod.GET)
	public ResponseEntity<List<Project>> getProjects() {

		List<Project> projects = projectService.findAll();
		if (projects.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}	
	
	@Secured({"ROLE_DEVELOPER", "ROLE_QA", "ROLE_PO", "ROLE_DESIGNER"})
	@GetMapping(value = "/project/{id}")
	public ResponseEntity<ProjectViewModel> getProjectById(@PathVariable("id")Long projectId){
		
		Project entity = projectService.findOne(projectId);
		
		if(entity == null) return new ResponseEntity<ProjectViewModel>(HttpStatus.NO_CONTENT);
		ProjectViewModel project = projectViewModelBuilder(entity);
		return new ResponseEntity<ProjectViewModel>(project, HttpStatus.OK);
	}
	
	@Secured({"ROLE_DEVELOPER", "ROLE_QA", "ROLE_PO", "ROLE_DESIGNER"})
	@GetMapping(value = "/projects/{userId}")
	public ResponseEntity<List<ProjectViewModel>> getProjectsByUserId(@PathVariable("userId") Long userId) {

		List<ProjectViewModel> projects = projectService.findProjectsByUserId(userId);		
		
		if (projects.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<ProjectViewModel>>(projects, HttpStatus.OK);
	}
	
private ProjectViewModel projectViewModelBuilder(Project projectEntity) {		
		
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Long assignedUserId = ((CustomUserDetails) auth.getPrincipal()).getId();*/
		
		
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
					i.getAssignedUserId())).collect(Collectors.toSet());
		
		model.setIssues(issues);		
		
		return model;
	}

}

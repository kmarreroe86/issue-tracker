package com.example.issuetracker.web.api;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
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
import com.example.issuetracker.resource.IssueResource;
import com.example.issuetracker.resource.ProjectResource;
import com.example.issuetracker.service.ProjectService;
import com.example.issuetracker.util.ProjectResourceAssembler;;

@CrossOrigin(origins = "*", maxAge = 3600)
@ExposesResourceFor(Project.class)
@RequestMapping(value = "/project", produces = "application/json")
@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectResourceAssembler assembler;

//    @PreAuthorize("hasRole('ADMIN')")
	@Secured({ "ROLE_DEVELOPER", "ROLE_QA", "ROLE_PO", "ROLE_DESIGNER" })
	@RequestMapping(value = "/list/", method = RequestMethod.GET)
	public ResponseEntity<Collection<ProjectResource>> getProjects() {

		List<Project> projects = projectService.findAll();
		if (projects.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Collection<ProjectResource>>(assembler.toResourceCollection(projects), HttpStatus.OK);
	}

	@Secured({ "ROLE_DEVELOPER", "ROLE_QA", "ROLE_PO", "ROLE_DESIGNER" })
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProjectResource> getProjectById(@PathVariable("id") Long projectId) {
		System.out.println("getProjectsByID: " + projectId);
		Project entity = projectService.findOne(projectId);
		if (entity == null) return new ResponseEntity<ProjectResource>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<ProjectResource>(assembler.toResource(entity), HttpStatus.OK);
	}

	@Secured({ "ROLE_DEVELOPER", "ROLE_QA", "ROLE_PO", "ROLE_DESIGNER" })
	@GetMapping(value = "/list/{userId}")
	public ResponseEntity<Collection<ProjectResource>> getProjectsByUserId(@PathVariable("userId") Long userId) {
		System.out.println("getProjectsByUserID");
		List<Project> projects = projectService.findProjectsByUserId(userId);
		return new ResponseEntity<Collection<ProjectResource>>(assembler.toResourceCollection(projects), HttpStatus.OK);
	}

}

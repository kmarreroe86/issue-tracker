package com.example.issuetracker.issuetracker.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.issuetracker.model.Project;
import com.example.issuetracker.issuetracker.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/projects/", method = RequestMethod.GET)
	public ResponseEntity<List<Project>> getProjects() {

		List<Project> projects = projectService.findAll();
		if (projects.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}

	@GetMapping(value = "/projects/{userId}")
	public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable("userId") Long userId) {

		List<Project> projects = projectService.findProjectsByUserId(userId);
		if (projects.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}

}

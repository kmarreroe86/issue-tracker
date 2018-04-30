package com.example.issuetracker.issuetracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.issuetracker.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

}

package com.example.issuetracker.issuetracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.issuetracker.issuetracker.service.IssueService;

@RestController
public class IssueController {
	
	@Autowired
	private IssueService issueService;

}

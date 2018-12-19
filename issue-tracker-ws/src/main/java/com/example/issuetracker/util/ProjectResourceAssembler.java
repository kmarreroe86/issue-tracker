package com.example.issuetracker.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.example.issuetracker.model.Project;
import com.example.issuetracker.resource.ProjectResource;

@Component
public class ProjectResourceAssembler extends ResourceAssembler<Project, ProjectResource> {
	
	@Autowired
	protected EntityLinks entityLinks;

	private static final String UPDATE_REL = "update";
	private static final String DELETE_REL = "delete";
	
	
	@Override
	public ProjectResource toResource(Project domainObject) {
		
		ProjectResource resource = new ProjectResource(domainObject);
		
		final Link selfLink = entityLinks.linkToSingleResource(domainObject);
		resource.add(selfLink.withSelfRel());
		resource.add(selfLink.withRel(UPDATE_REL));
		resource.add(selfLink.withRel(DELETE_REL));
		
		return resource;
	}
}

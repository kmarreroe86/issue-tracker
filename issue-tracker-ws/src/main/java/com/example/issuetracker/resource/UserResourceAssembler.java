package com.example.issuetracker.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.example.issuetracker.model.CustomUserDetails;
import com.example.issuetracker.model.User;

@Component
public class UserResourceAssembler extends ResourceAssembler<CustomUserDetails, UserResource> {

	@Autowired
	protected EntityLinks entityLinks;

	private static final String UPDATE_REL = "update";
	private static final String DELETE_REL = "delete";

	@Override
	public UserResource toResource(CustomUserDetails domainObject) {
		
		UserResource resource = new UserResource(domainObject);
		
		final Link selfLink = entityLinks.linkToSingleResource(domainObject);
		resource.add(selfLink.withSelfRel());
		resource.add(selfLink.withRel(UPDATE_REL));
		resource.add(selfLink.withRel(DELETE_REL));
		
		return resource;
	}

}

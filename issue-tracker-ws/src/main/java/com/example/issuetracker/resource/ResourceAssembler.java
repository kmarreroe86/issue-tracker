package com.example.issuetracker.resource;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class ResourceAssembler<DomainType, ResourceType> {

	public abstract ResourceType toResource(DomainType domainObject);

	public Collection<ResourceType> toResourceCollection(Collection<DomainType> domainObjects) {

		return domainObjects.stream().map(domainObj -> toResource(domainObj)).collect(Collectors.toList());
	}

}

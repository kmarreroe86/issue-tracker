package com.example.issuetracker.util;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class ResourceAssembler<DomainType, ResourceType> {
	
	protected static final String UPDATE_REL2 = "update2";

	protected abstract ResourceType toResource(DomainType domainObject);

	public Collection<ResourceType> toResourceCollection(Collection<DomainType> domainObjects) {

		return domainObjects.stream().map(domainObj -> toResource(domainObj)).collect(Collectors.toList());
	}

}

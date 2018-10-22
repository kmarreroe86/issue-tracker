package com.example.issuetracker.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.issuetracker.model.Project;
import com.example.issuetracker.model.User;
import com.example.issuetracker.model.UserRol;
import com.example.issuetracker.repository.ProjectRepository;
import com.example.issuetracker.resource.ProjectResource;
import com.example.issuetracker.resource.ProjectResourceAssembler;
import com.example.issuetracker.resource.UserResource;
import com.example.issuetracker.resource.UserResourceAssembler;
import com.example.issuetracker.service.ProjectService;

@Service
public class ProjectServiceImpl extends AbstracService<Project> implements ProjectService {

	@Autowired
	private ProjectRepository daoRepository;
	
	/*@Autowired
	private ProjectResourceAssembler assembler;
	
	@Autowired
	private UserResourceAssembler userAssembler;*/
	
	
//	TODO: Check logic of loading user projects
	public List<Project> findProjectsByUserId(Long userId) {
		
		List<Project> projects = daoRepository.findByUsers_Id(userId);
		/*List<ProjectResource> projectListsViewModel = new ArrayList<>();
		UserResource u = null;

		for (Project project : projects) {
			Optional<User> projectLead = project.getUsers().stream().filter(pl -> pl.getRol() == UserRol.PO)
					.findFirst();
			if (projectLead.isPresent()) {
				// TODO: Refactor this. Move transform to Resource to Controller.
				u = new UserResource(projectLead.get());
			}

			// TODO: Refactor this. Move transform to Resource to Controller.
			ProjectResource proViewModel = new ProjectResource(project);
			projectListsViewModel.add(proViewModel);
		}
		return projectListsViewModel;*/
		return projects;
	}
	
	protected JpaRepository<Project, Long> getDao() {
		return daoRepository;
	}

}

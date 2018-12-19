package com.example.issuetracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.issuetracker.model.Project;
import com.example.issuetracker.repository.ProjectRepository;
import com.example.issuetracker.service.ProjectService;

@Service
public class ProjectServiceImpl /*extends AbstracService<Project>*/ implements ProjectService {

	@Autowired
	private ProjectRepository daoRepository;
	
	/*@Autowired
	private ProjectResourceAssembler assembler;
	
	@Autowired
	private UserResourceAssembler userAssembler;*/
	
	
//	TODO: Check logic of loading user projects
	public List<Project> findProjectsByUserId(Long userId) {
		
		List<Project> projects = daoRepository.getProjectsByUserId(userId);
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
	
	@Override
	public CrudRepository<Project, Long> getDao() {
		return daoRepository;
	}

}

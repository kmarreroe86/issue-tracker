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
import com.example.issuetracker.service.ProjectService;
import com.example.issuetracker.viewmodel.ProjectViewModel;
import com.example.issuetracker.viewmodel.UserViewModel;

@Service
public class ProjectServiceImpl extends AbstracService<Project> implements ProjectService {

	@Autowired
	private ProjectRepository daoRepository;	
	
	
//	TODO: Check logic of loading user projects
	public List<ProjectViewModel> findProjectsByUserId(Long userId) {
		
		List<Project> projects = daoRepository.findByUsers_Id(userId);
		List<ProjectViewModel> projectListsViewModel = new ArrayList<>();
		UserViewModel u = null;

		for (Project project : projects) {
			Optional<User> projectLead = project.getUsers().stream().filter(pl -> pl.getRol() == UserRol.PO)
					.findFirst();
			if (projectLead.isPresent()) {
				u = new UserViewModel(projectLead.get().getId(), projectLead.get().getUsername(),
						projectLead.get().getRol().toString());
			}

			ProjectViewModel proViewModel = new ProjectViewModel(project.getId(), project.getProjectName(),
					project.getProjectKey(), u, project.getUrl());
			projectListsViewModel.add(proViewModel);
		}
		return projectListsViewModel;
	}
	
	protected JpaRepository<Project, Long> getDao() {
		return daoRepository;
	}

}

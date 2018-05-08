package com.example.issuetracker.issuetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.issuetracker.issuetracker.model.Project;
import com.example.issuetracker.issuetracker.model.User;
import com.example.issuetracker.issuetracker.model.UserRol;
import com.example.issuetracker.issuetracker.repository.ProjectRepository;

@SpringBootApplication
public class IssueTrackerWsApplication /*implements CommandLineRunner*/ {
	
	/*@Autowired
	private ProjectRepository repo;*/

	public static void main(String[] args) {
		SpringApplication.run(IssueTrackerWsApplication.class, args);
	}
	

//	@Override
//	public void run(String... args) throws Exception {
		/*Project testProject = new Project();		
		testProject.setProjectName("TestProjectManyToMany1");
		Project testProject2 = new Project();
		testProject2.setProjectName("TestProjectManyToMany2");
		
		User testUser1 = new User();
		testUser1.setUsername("TestUser1");
		testUser1.setRol(UserRol.DEVELOPER);
		
		User testUser2 = new User();
		testUser2.setUsername("TestUser2");
		testUser2.setRol(UserRol.DESIGNER);
		
		testProject.getUsers().add(testUser1);
		testProject.getUsers().add(testUser2);		
		testProject2.getUsers().add(testUser1);
		testProject2.getUsers().add(testUser2);
		
		testUser1.getProjects().add(testProject);
		testUser1.getProjects().add(testProject2);		
		testUser2.getProjects().add(testProject);
		testUser2.getProjects().add(testProject2);	
		
		repo.save(testProject);
		repo.save(testProject2);*/
		
//	}
}

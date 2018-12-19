package com.example.issuetracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.issuetracker.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>, CustomProjectRepository {
	
}
/*public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	Project findByProjectName(String projectName);
	
	List<Project> findByUsers_Id(Long id);
	

}*/


package com.example.issuetracker.issuetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.issuetracker.issuetracker.model.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
	

}

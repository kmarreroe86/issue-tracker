package com.example.issuetracker.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.issuetracker.model.Issue;
import com.example.issuetracker.repository.IssueRepository;
import com.example.issuetracker.service.IssueService;

@Service
@Transactional
public class IssueServiceImpl extends AbstracService<Issue> implements IssueService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IssueRepository daoRepository;

	/*public Issue updateIssue(Issue entity) {
		if (entity == null) return null;

		return update(entity);
	}*/

	@Override
	protected JpaRepository<Issue, Long> getDao() {

		return daoRepository;
	}

}

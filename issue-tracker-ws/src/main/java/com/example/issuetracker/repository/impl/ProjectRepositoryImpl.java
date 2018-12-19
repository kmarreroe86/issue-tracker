package com.example.issuetracker.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.example.issuetracker.model.Project;
import com.example.issuetracker.repository.CustomProjectRepository;

public class ProjectRepositoryImpl implements CustomProjectRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Project> getProjectsByUserId(Long userid) {

		StoredProcedureQuery findProjectsByUserId = em.createNamedStoredProcedureQuery("getProjectsByUserId");
				//.setParameter("@i_userid", userid);
		StoredProcedureQuery storedProcedure = 
				findProjectsByUserId.setParameter("i_userid", 1L);
		List<Project> kaka = storedProcedure.getResultList();

		return kaka;
	}
	
	/*
	 * No named procedure.
	 * StoredProcedureQuery storedProcedure = 
          entityManager
            .createStoredProcedureQuery("FIND_CAR_BY_YEAR",Car.class)
            .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
            .setParameter(1, 2015);
        
        storedProcedure.getResultList()
          .forEach(c -> Assert.assertEquals(new Integer(2015), ((Car) c).getYear()));
    }
    */

}

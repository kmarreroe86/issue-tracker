package com.example.issuetracker.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

public interface Operations<T extends Serializable> {

	T findOne(final long id);

	List<T> findAll();

	Page<T> findPaginated(int page, int size);

	// write
	T create(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final long entityId);

}

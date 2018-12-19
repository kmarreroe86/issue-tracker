package com.example.issuetracker.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface Operations<T extends Serializable> {

//	T findOne(final long id);
	@Transactional(readOnly = true)
	default T findOne(final long id) {
		return getDao().findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	default List<T> findAll() {
		return (List<T>) getDao().findAll();
	}

	/**
	 * TODO: Check pagination 
	 * */
	/*default Page<T> findPaginated(final int page, final int size) {
		return getDao().findAll(new PageRequest(page, size));
	}*/

	// write
	default T create(final T entity) {
		return getDao().save(entity);
	}

	default T update(final T entity) {
		return getDao().save(entity);
	}

	default void delete(final T entity) {
		getDao().delete(entity);
	}

	default void deleteById(final long entityId) {
		getDao().deleteById(entityId);
	}

	CrudRepository<T, Long> getDao();

}

package com.example.issuetracker.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.issuetracker.service.Operations;

@Transactional
public abstract class AbstracService<T extends Serializable> /*implements Operations<T>*/ {
	
	// read - one

/*    @Override
    @Transactional(readOnly = true)
    public T findOne(final long id) {
        return getDao().findById(id).orElse(null);
    }
    

    // read - all

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public Page<T> findPaginated(final int page, final int size) {
        return getDao().findAll(new PageRequest(page, size));
    }

    // write

    @Override
    public T create(final T entity) {
        return getDao().save(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(final long entityId) {
        getDao().deleteById(entityId);
    }

    protected abstract JpaRepository<T, Long> getDao();
*/
	}

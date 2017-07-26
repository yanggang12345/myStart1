package com.bdqn.service;

import java.util.List;

public interface BaseService<T> {
	public void saveOrUpdate(T entity);
	public void delete(int id);
	public T findById(int id);
	public List<T> findAll();
}

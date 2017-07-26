package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.Category;

public interface CategoryDao {

	public List<Category> findAll();

	public Category findByCid(Integer cid);

	public void save(Category category);

	public void delete(Category category);
}

package com.bdqn.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bdqn.dao.CategoryDao;
import com.bdqn.entity.Category;
import com.bdqn.service.categoryService;


@Transactional
public class CategoryServiceImpl implements categoryService{

	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public void save(Category category) {
		categoryDao.save(category);
	}

	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}

	public void delete(Category category) {
		categoryDao.delete(category);
	}
	
}

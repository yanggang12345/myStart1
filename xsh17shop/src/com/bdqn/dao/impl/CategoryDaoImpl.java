package com.bdqn.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.dao.CategoryDao;
import com.bdqn.entity.Category;


public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao{

	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	public void save(Category category) {
		this.getHibernateTemplate().saveOrUpdate(category);
	}

	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

}

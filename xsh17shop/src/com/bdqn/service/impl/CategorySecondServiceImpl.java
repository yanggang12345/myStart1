package com.bdqn.service.impl;

import java.util.List;

import com.bdqn.common.PageBean;
import com.bdqn.dao.CategorySecondDao;
import com.bdqn.entity.CategorySecond;
import com.bdqn.entity.Product;
import com.bdqn.service.CategorySecondService;

public class CategorySecondServiceImpl implements CategorySecondService {

	private  CategorySecondDao  categorySecondDao;
	
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	@Override
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	@Override
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		//设置当前页数
		pageBean.setPage(page);
		int limit =10;
		pageBean.setLimit(limit);
		
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		int totalPage =0;
		totalPage = (totalCount+limit-1)/limit;
		pageBean.setTotalPage(totalPage);
		
		int begin = (page-1)*limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public CategorySecond findByCsid(int csid) {
		return categorySecondDao.findByCsid(csid);
	}

	@Override
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	@Override
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}

	@Override
	public List<CategorySecond> findByCid(int cid) {
		return categorySecondDao.findByCid(cid);
	}


}

package com.bdqn.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.transaction.annotation.Transactional;

import com.bdqn.common.PageBean;
import com.bdqn.dao.UserDao;
import com.bdqn.entity.User;
import com.bdqn.service.UserService;
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao ;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveOrUpdate(User entity) {
		// TODO Auto-generated method stub
		 userDao.saveOrUpdate(entity);
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
		
	}

	@Override
	public User findByUserCode(String code) {
		
		return userDao.findByUserCode(code) ;
	}

	@Override
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		
		pageBean.setPage(page);
		int limit =10;
		pageBean.setLimit(limit);
		
		int totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		int totalPage = 0;
		totalPage = (totalCount+limit-1)/limit;
		pageBean.setTotalPage(totalPage);
		
		int begin = (page -1)*limit;
		List<User>  list = userDao.findByPage(begin,limit);
		pageBean.setList(list);
		
		return pageBean;
	}
	
}

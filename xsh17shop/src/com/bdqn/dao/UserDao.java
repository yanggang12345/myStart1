package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.User;

public interface UserDao extends BaseDao<User>{
	/*
	 * 根据用户名查询用户
	 */
	User findByUserName(String username);
	/*
	 * 根据用户激活码查询用户
	 */
	public User findByUserCode(String code);
	/**
	 * 查找用户数量
	 * @return
	 */
	int findCount();
	/**
	 * 分页查询用户
	 * @param begin
	 * @param limit
	 * @return
	 */
	List<User> findByPage(int begin, int limit);
}

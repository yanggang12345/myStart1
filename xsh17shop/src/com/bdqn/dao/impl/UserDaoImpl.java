package com.bdqn.dao.impl;


import java.util.List;

import com.bdqn.common.PageHibernateCallback;
import com.bdqn.dao.UserDao;
import com.bdqn.entity.Order;
import com.bdqn.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findByUserName(String username) {
		String sql="From User where username=?";
		List list = this.getHibernateTemplate().find(sql,username);
		return list.size()==0?null:(User)(list.get(0)) ;
	}

	@Override
	public User findByUserCode(String code) {
		String sql="From User where code=?";
		List list = this.getHibernateTemplate().find(sql,code);
		return list.size()==0?null:(User)(list.get(0)) ;
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<User> findByPage(int begin, int limit) {
		String hql ="from User";
		List<User> list = this.getHibernateTemplate().execute(new PageHibernateCallback<>(hql, null, begin, limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}

	
}

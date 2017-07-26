package com.bdqn.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.dao.AdminUserDao;
import com.bdqn.entity.AdminUser;

public class AdminUserDaoImpl extends HibernateDaoSupport implements AdminUserDao{

	@Override
	public AdminUser login(AdminUser adminUser) {
		String hql = "from AdminUser where username = ? and password = ?";
		List<AdminUser> list = this.getHibernateTemplate().find(hql,adminUser.getUsername(),adminUser.getPassword());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}

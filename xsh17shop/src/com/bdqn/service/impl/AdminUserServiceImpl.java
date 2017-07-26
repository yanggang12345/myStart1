package com.bdqn.service.impl;

import com.bdqn.dao.AdminUserDao;
import com.bdqn.dao.DaoFactory;
import com.bdqn.entity.AdminUser;
import com.bdqn.service.AdminUserService;

public class AdminUserServiceImpl implements AdminUserService{
	private AdminUserDao adminUserDao=DaoFactory.createAdminUserDao();

	@Override
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}

	public AdminUserDao getAdminUserDao() {
		return adminUserDao;
	}

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	
	
}

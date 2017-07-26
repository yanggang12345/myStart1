package com.bdqn.dao;

import com.bdqn.dao.impl.AdminUserDaoImpl;

public class DaoFactory {
	public static AdminUserDao createAdminUserDao(){
		return new AdminUserDaoImpl();
	}
}

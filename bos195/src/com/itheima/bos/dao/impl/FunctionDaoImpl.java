package com.itheima.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.dao.base.impl.BaseDaoImpl;
import com.itheima.bos.domain.Function;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao{
	/**
	 * 根据用户id查询对应的权限
	 */
	public List<Function> findListByUserid(String userid) {
		String hql="select distinct f from Function f left outer join f.roles r left outer join r.users u where u.id=?";
		return this.getHibernateTemplate().find(hql,userid);
	}

	public List<Function> findAllMenu() {
		String hql="from Function f where f.generatemenu ='1' order by f.zindex desc";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * 根据用户id查询菜单
	 */
	public List<Function> findMenuByUserid(String id) {
		String hql="select distinct f from Function f left outer join f.roles r left outer join r.users u where u.id=?"
				+ " and f.generatemenu ='1' order by f.zindex desc";
		return this.getHibernateTemplate().find(hql,id);
	}

}

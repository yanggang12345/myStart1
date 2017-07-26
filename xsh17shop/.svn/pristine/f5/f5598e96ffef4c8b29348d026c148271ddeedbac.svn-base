package com.bdqn.dao.impl;

import java.util.List;

import com.bdqn.dao.OrderItemDao;
import com.bdqn.entity.OrderItem;

public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao{

	@Override
	public int findLastInsertIntoId() {
		String sql="select last_insert_id()";
		return this.getHibernateTemplate().get(int.class,sql);
	}

	@Override
	public List<OrderItem> findByOid(int oid) {
		String sql="from OrderItem where oid="+oid;
		return this.getHibernateTemplate().find(sql);
	}

}

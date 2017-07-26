package com.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.common.PageHibernateCallback;
import com.bdqn.dao.OrderDao;
import com.bdqn.entity.Order;
import com.bdqn.entity.OrderItem;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao{

	@Override
	public List<Order> findByPage(int begin, int limit) {
		String hql ="from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<>(hql, null, begin, limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public List<Order> findByPageWithState(int begin, int limit,int uid) {
		String hql ="from Order where uid="+uid+" ORDER BY ordertime DESC";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<>(hql, null, begin, limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	};
	
	@Override
	public int findCount() {
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public int findCountByUid(int uid) {
		String hql = "select count(*)  from Order where uid ="+uid;
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	@Override
	public List<OrderItem> findByOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid=?";
		List<OrderItem> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public void update(Order order) {
		this.getHibernateTemplate().update(order);
	}

	@Override
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}


	@Override
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	public int findLastInsertIntoId(){
		
		return 0;
	}


	@Override
	public int findByState(Integer state) {
		String hql = "select count(*) from Order where state ="+state;
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public void delete(Integer oid) {
		this.getHibernateTemplate().delete(findByOid(oid));
		
	}

	

	@Override
	public List<Order> findByPageWithState(int begin, int limit, Integer state) {
		String hql ="from Order where state="+state+" ORDER BY ordertime DESC";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<>(hql, null, begin, limit));
		if(list != null && list.size()>0){
			return list;
		}
		return null;
	}

	

}

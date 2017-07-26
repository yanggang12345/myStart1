package com.bdqn.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.bdqn.common.PageBean;
import com.bdqn.dao.OrderDao;
import com.bdqn.dao.OrderItemDao;
import com.bdqn.entity.Order;
import com.bdqn.entity.OrderItem;
import com.bdqn.service.OrderItemService;
import com.bdqn.service.OrderService;

public class OrderItemServiceImpl implements OrderItemService{

	private OrderItemDao orderItemDao;


	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	@Override
	public void saveOrUpdate(OrderItem entity) {
		orderItemDao.saveOrUpdate(entity);
		
	}

	@Override
	public void delete(int id) {
		orderItemDao.delete(id);
		
	}

	@Override
	public OrderItem findById(int id) {
		// TODO Auto-generated method stub
		return orderItemDao.findById(id);
	}

	@Override
	public List<OrderItem> findAll() {
		// TODO Auto-generated method stub
		return orderItemDao.findAll();
	}

	@Override
	public int findLastInsertIntoId() {
		// TODO Auto-generated method stub
		return orderItemDao.findLastInsertIntoId();
	}

	@Override
	public Set<OrderItem> findByOid(Integer oid) {
		Set<OrderItem> orderItems=new LinkedHashSet<>();
		 List<OrderItem> list = orderItemDao.findByOid(oid);
		 for (OrderItem orderItem : list) {
			orderItems.add(orderItem);
		}
		 return orderItems;
	}
	

}

package com.bdqn.service;

import java.util.List;

import com.bdqn.common.PageBean;
import com.bdqn.entity.Order;
import com.bdqn.entity.OrderItem;

public interface OrderService {

	PageBean<Order> findByPage(Integer page);

	List<OrderItem> findByOrderItem(Integer oid);

	void update(Order order);

	Order findByOid(Integer oid);
	
	void save(Order order);
	
	public int findLastInsertIntoId();
	
	PageBean<Order> findByPageWithUid(Integer page,int uid);

	/*List<Order> findByState(Integer state);*/
	
	void delete(Integer oid);

	PageBean<Order> findByPageWithState(Integer page, Integer state);

}

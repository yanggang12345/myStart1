package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.OrderItem;


public interface OrderItemDao extends BaseDao<OrderItem> {
	/**
	 * 没用
	 * @return
	 */
	public int findLastInsertIntoId();
	/**
	 * 按订单id查看订单商品
	 * @param oid
	 * @return
	 */
	List<OrderItem> findByOid(int oid);
}

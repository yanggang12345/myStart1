package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.Order;
import com.bdqn.entity.OrderItem;

public interface OrderDao {
	/**
	 * 分页查找订单
	 * @param begin
	 * @param limit
	 * @return
	 */
	List<Order> findByPage(int begin, int limit);
	/**
	 * 查找总数
	 * @return
	 */
	int findCount();
	/**
	 * 按订单用户查找订单
	 * @param uid
	 * @return
	 */
	int findCountByUid(int uid);
	/**
	 * 按订单oid查找商品
	 * @param oid
	 * @return
	 */
	List<OrderItem> findByOrderItem(Integer oid);
	/**
	 * 修改订单
	 * @param order
	 */
	void update(Order order);
	/**
	 * 按订单id查找订单
	 * @param oid
	 * @return
	 */
	Order findByOid(Integer oid);
	/**
	 * 保存订单
	 * @param order
	 */
	void save(Order order);
	/**
	 * 没用
	 * @return
	 */
	public int findLastInsertIntoId();
	/**
	 * 按用户uid分页查询
	 * @param begin
	 * @param limit
	 * @param uid
	 * @return
	 */
	List<Order> findByPageWithState(int begin, int limit,int uid);
	/**
	 * 按状态查询
	 * @param state
	 * @return
	 */
	int findByState(Integer state);
	/**
	 * 删除订单
	 * @param oid
	 */
	void delete(Integer oid);
	/**
	 * 按订单状态分页查询
	 * @param begin
	 * @param limit
	 * @param state
	 * @return
	 */
	List<Order> findByPageWithState(int begin, int limit, Integer state);

}

package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.CategorySecond;
import com.bdqn.entity.Product;

public interface ProductDao {

	/**
	 * 分页查询商品
	 * @param begin
	 * @param limit
	 * @return
	 */
	List<Product> findByPage(int begin, int limit);
	/**
	 * 按订单类的一级或者二级种类查询
	 * @param begin
	 * @param limit
	 * @param csid
	 * @return
	 */
	List<Product> findByPage(int begin, int limit,Integer csid);
	/**
	 * 查询总数
	 * @return
	 */
	int findCount();
	/**
	 * 保存商品
	 * @param product
	 */
	void save(Product product);
	/**
	 * 按商品id查询商品
	 * @param pid
	 * @return
	 */
	Product finByPid(int pid);
	/**
	 * 删除商品
	 * @param product
	 */
	void delete(Product product);

	/**
	 * 按种类查询
	 * @param csid
	 * @return
	 */
	List<Product> findByCsid(int csid);
	/**
	 * 按是否热门查询
	 * @return
	 */
	List<Product> findHot();
	/**
	 * 查找最新商品
	 * @return
	 */
	List<Product> findNew();

}

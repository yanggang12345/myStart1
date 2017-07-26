package com.bdqn.web.cart.vo;

import com.bdqn.entity.Product;
/**
 * 购物车商品
 * <p>Title:CartItem<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author 123456
 * <p>杨刚</p>
 */
public class CartItem {

	private Product product;
	private int count ;
	private double subtotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return Double.parseDouble(product.getShop_price())*count;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}

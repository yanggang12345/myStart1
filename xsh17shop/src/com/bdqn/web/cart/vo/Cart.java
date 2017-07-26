package com.bdqn.web.cart.vo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class Cart {

	private static Map<Integer, CartItem> map = new LinkedHashMap<>();;
	
	public Map<Integer, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}
	public Collection<CartItem> getCartItems(){
		return map.values();
		
	}
	public double getTotal() {
		return total;
	}

	private double total;
	
	public void addCart(CartItem cartItem){
		//判断购物车中是否有这个商品
		/**
		 * 1.如果有这个商品就数量加添加的数量
		 * 2.如果没得这个商品就添加
		 */
		Integer pid=cartItem.getProduct().getPid();
		if(map.containsKey(pid)){
			CartItem item = map.get(pid);
			item.setCount(item.getCount()+cartItem.getCount());
			map.put(pid, item);
		}else{
			map.put(pid, cartItem);
		}
		total+=cartItem.getSubtotal();
	}
	/**
	 * 删除购物车中的商品
	 * @param pid
	 */
	public void removeCart(Integer pid){
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		CartItem item = map.remove(pid);
		total-=item.getSubtotal();
	}
	/*
	 * 清空购物车
	 */
	public void clearCart(){
		map.clear();
		total=0;
	}
	
}

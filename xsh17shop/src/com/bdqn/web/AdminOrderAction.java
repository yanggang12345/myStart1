package com.bdqn.web;

import java.util.List;

import com.bdqn.common.PageBean;
import com.bdqn.entity.Order;
import com.bdqn.entity.OrderItem;
import com.bdqn.service.OrderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
	
	private Order order = new Order();
	private OrderService orderService;
	private  Integer page;
	
	public String findAll(){
		PageBean<Order> pageBean = orderService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findAll";
	}
	public String findOrderItem(){
		//根据订单ID查询
		List<OrderItem> list = orderService.findByOrderItem(order.getOid());
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOrderItem";
	}
	
/*	public String findByState(){
		
		List<Order> slist = orderService.findByState(order.getState());
		ActionContext.getContext().getValueStack().set("slist", slist);
		return "findByState";
		
	}*/
	
	public String findByState(){
			
		PageBean<Order> pageBean = orderService.findByPageWithState(page,order.getState());
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByState";
			
	}
	
	public String updateState(){
		Order currOrder = orderService.findByOid(order.getOid());
		//修改状态
		currOrder.setState(3);
		orderService.update(currOrder);
		
		return "updateState";
	}
	
	@Override
	public Order getModel() {
		return order;
	}




	public Order getOrder() {
		return order;
	}




	public void setOrder(Order order) {
		this.order = order;
	}




	public Integer getPage() {
		return page;
	}




	public void setPage(Integer page) {
		this.page = page;
	}




	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	
}

package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Decidedzone;
import com.itheima.bos.web.action.base.BaseAction;

import cn.itcast.crm.domain.Customer;
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {
	//接受分区id
	private String[] subareaid;

	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	
	/*
	 * 添加分区
	 */
	public String add(){
		decidedzoneService.save(model,subareaid);
		return "list";
	}
	/**
	 * 分页查询
	 */
	public String pageQuery() throws IOException{
		
		decidedzoneService.pageQuery(pageBean);
		//将PageBean对象转为json返回
		this.writePageBean2Json(pageBean, new String[]{"subareas","currentPage","detachedCriteria","pageSize","decidedzones"});
		return NONE;
	}
	/**
	 * 查询没有关联到定区得客户
	 * @return
	 * @throws IOException
	 */
	public String findnoassociationCustomers() throws IOException{
		List<Customer> list = customService.findnoassociationCustomers();
		String[] excludes=new String[]{"station","address"};
		this.writeList2Json(list, excludes);
		return NONE;
	}
	/**
	 * 查询关联到定区得客户
	 * @return
	 * @throws IOException
	 */
	public String findhasassociationCustomers() throws IOException{
		List<Customer> list = customService.findhasassociationCustomers(model.getId());
		String[] excludes=new String[]{"station","address"};
		this.writeList2Json(list, excludes);
		return NONE;
	}
	
	public Integer[] getCustomerIds() {
		return customerIds;
	}
	public void setCustomerIds(Integer[] customerIds) {
		this.customerIds = customerIds;
	}
	private Integer[] customerIds;
	/**
	 * 定区关联客户
	 */
	public String assigncustomerstodecidedzone(){
		customService.assignCustomersToDecidedZone(customerIds, model.getId());
		return "list";
	}
}

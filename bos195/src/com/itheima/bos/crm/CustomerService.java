package com.itheima.bos.crm;

import java.util.List;

import cn.itcast.crm.domain.Customer;

// 客户服务接口 
public interface CustomerService {
	// 未关联定区客户
	public List<Customer> findnoassociationCustomers();

	// 查询已经关联指定定区的客户
	public List<Customer> findhasassociationCustomers(String decidedZoneId);

	// 将未关联定区客户关联到定区上
	public void assignCustomersToDecidedZone(Integer[] customerIds, String decidedZoneId);
	
	//根据电话号码查询客户
	public Customer findCustomerByPhonenumber(String phonenumber);
	
	//根据取件地址查询定区id
	public String findDecidezoneIdByPickaddress(String address);
}

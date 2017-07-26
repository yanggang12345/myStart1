package com.itheima.bos.web.action;

import java.io.IOException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Noticebill;
import com.itheima.bos.domain.User;
import com.itheima.bos.utils.BOSContext;
import com.itheima.bos.web.action.base.BaseAction;

import cn.itcast.crm.domain.Customer;
@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill>{
	/**
	 * 调用代理对象
	 * @throws IOException 
	 */
	public String findCustomerByTelephone() throws IOException{
		Customer customer = customService.findCustomerByPhonenumber(model.getTelephone());
		String[] excludes=new String[]{};
		this.writeObject2Json(customer, excludes);
		return NONE;
	}
	/*
	 * 保存业务通知单，尝试自动分单
	 */
	public String add(){
		User user=BOSContext.getLoginUser();
		model.setUser(user);
		noticebillService.save(model);
		
		return "addUI";
	}
}

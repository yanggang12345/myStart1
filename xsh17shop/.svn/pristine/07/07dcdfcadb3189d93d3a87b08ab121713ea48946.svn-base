package com.bdqn.web;

import org.apache.struts2.ServletActionContext;

import com.bdqn.entity.AdminUser;
import com.bdqn.service.AdminUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	//模型驱动
	private AdminUser adminUser = new AdminUser();
	@Override
	public AdminUser getModel() {
		return adminUser;
	}
	
	private AdminUserService adminUserService;
	
	
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	public String login(){
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if(existAdminUser == null){
			//登陆失败
			this.addActionError("登陆失败 用户名或密码错误");
			return "loginFail";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}
	
	public String home(){
		return "home";
	}
	
}

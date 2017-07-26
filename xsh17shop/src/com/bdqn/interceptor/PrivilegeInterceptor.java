package com.bdqn.interceptor;

import org.apache.struts2.ServletActionContext;

import com.bdqn.entity.AdminUser;
import com.bdqn.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 权限拦截器
 * <p>Title:PrivilegeInterceptor<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author 123456
 * <p>杨刚</p>
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		//判断session中是否保存了后台用户的信息
		AdminUser existUser = (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("existAdminUser");
		if(existUser == null){
			ActionSupport as =(ActionSupport) actionInvocation.getAction();
			as.addActionError("您还未登陆");
			return "loginFail";
		}else{
			return actionInvocation.invoke();
		}
		
		
	}

}

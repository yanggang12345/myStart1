package com.bdqn.interceptor;

import org.apache.struts2.ServletActionContext;

import com.bdqn.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 用户拦截器用于拦截用户是否登录，且登陆后才能购买商品
 * <p>Title:UserLoginInterceptor<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @date 2017年7月26日 下午4:14:32
 * @author 123456
 * <p>杨刚</p>
 */
public class UserLoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		//未登录就跳到首页
		if (user==null) {
			ActionSupport as =(ActionSupport) invocation.getAction();
			as.addActionError("您还未登陆");
			return "login";
		}else{
			return invocation.invoke();
		}
	}

}

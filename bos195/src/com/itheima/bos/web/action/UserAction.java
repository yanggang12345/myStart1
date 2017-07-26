package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.crm.CustomerService;
import com.itheima.bos.domain.User;
import com.itheima.bos.service.IUserService;
import com.itheima.bos.utils.MD5Utils;
import com.itheima.bos.web.action.base.BaseAction;

import cn.itcast.crm.domain.Customer;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	//通过属性驱动接收验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String login(){
		
		//生成的验证码
		String key = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		//判断用户输入的验证码是否正确
		if(StringUtils.isNotBlank(checkcode)&& checkcode.equals(key)){
			//获得当前用户对象
			Subject subject = SecurityUtils.getSubject();//状态为"未认证"
			String password=model.getPassword();
			password = MD5Utils.md5(password);
			//构造一个用户密码令牌
			AuthenticationToken token=new UsernamePasswordToken(model.getUsername(),password);
			try {
				subject.login(token);
			} catch (UnknownAccountException e) {
				e.printStackTrace();
				//设置错误信息
				this.addActionError(this.getText("usernamenotfound"));
				return "login";
			}catch (Exception e) {
				e.printStackTrace();
				//设置错误信息
				this.addActionError(this.getText("loginError"));
				return "login";
			}
			//获取认证信息对象中存储的User对象
			User user = (User) subject.getPrincipal();
			ServletActionContext.getRequest().getSession().setAttribute("loginUser",user);
			return"home";
		}else{
			//验证码错误，设置错误提示信息，跳转到登录页面
			this.addActionError(this.getText("validateCodeError"));
			return "login";
		}
		
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "login";
	}
	
	/*
	 * 修改当前用户密码
	 */
	public String editPassword() throws IOException{
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		String password =model.getPassword();//新密码
		password = MD5Utils.md5(password);
		user.setPassword(password);
		String flag="1";
		try {
			userService.editPassword(password,user.getId());
		} catch (Exception e) {
			//修改密码失败
			flag="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(flag);
		return NONE;
	}
	/**
	 * 用户分页查询
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException{
		userService.pageQuery(pageBean);
		String[] excludes=new String[]{"noticebills","roles"};
		this.writePageBean2Json(pageBean, excludes);
		return NONE;
	}
	
	private String[] rolesIds;
	/**
	 * 添加用户
	 */
	public String add(){
		userService.save(model,rolesIds);
		return "list";
	}
	public String[] getRolesIds() {
		return rolesIds;
	}
	public void setRolesIds(String[] rolesIds) {
		this.rolesIds = rolesIds;
	}
	
}

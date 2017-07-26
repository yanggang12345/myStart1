package com.bdqn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bdqn.common.PageBean;
import com.bdqn.entity.User;
import com.bdqn.service.UserService;
import com.bdqn.util.LoginUtils;
import com.bdqn.util.MailUitls;
import com.bdqn.web.smsValidate.IndustrySMS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends BaseAction implements ModelDriven<User>{

	private UserService userService;
	private static String code1;
	private static int ids;
	private User user=new User();
	
	private Integer page=1;
	/**
	 * 查找所有用户
	 * @return
	 */
	public String findAll(){
		PageBean<User> pageBean = userService.findByPage(page);
		//显示到页面
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	/**
	 * 更新或者保存用户
	 * @return
	 */
	public String saveOrUpdate(){
		userService.saveOrUpdate(user);
		return "saveSuccess";
	}
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public String delete(int id){
		userService.delete(id);
		return "saveSuccess";
	}
	/**
	 * 编辑用户页面
	 * @return
	 */
	public String edit(){
		return "editSuccess";
	}
	/**
	 * 注册页面
	 * @return
	 */
	public String registPage(){
		return "registPage";
	}
	/**
	 * 登录页面
	 * @return
	 */
	public String loginPage(){
		return "loginPage";
	}
	/**
	 * 验证码
	 */
	private String checkcode;
	
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	/**
	 * 用户注册
	 * @return
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws IOException
	 */
	public String regist() throws AddressException, MessagingException, IOException{
		String checkCode1=(String) ServletActionContext.getRequest().getSession().getAttribute("checkCode");
		if (!checkcode.equalsIgnoreCase(checkCode1)) {
			this.addActionError("验证码输入错误!");
			return "checkcodeFail";
		}
		//生成邮箱激活码
		String code=UUID.randomUUID().toString();
		user.setCode(code);
		MailUitls.sendMail(user.getEmail(), code);
		saveOrUpdate();
		ids=user.getUid();
		this.addActionMessage("注册成功!请去邮箱激活!");
		return "msg";
	}
	//短信验证
	public String codeActive() throws IOException{
		code1 = IndustrySMS.execute(user.getPhone());
		return NONE;
	}
	//检查短信验证码是否正确
	public String checkCodeActive() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if(code1!=null){
			if(!code1.equals(user.getCode())){
				out.print("1");//激活失败
			}else{
				out.println();//激活成功
			}
		}
		return NONE;
	}
	/**
	 * 邮箱激活
	 * @return
	 */
	public String active(){
		String code = user.getCode();
		user = userService.findById(ids);
		user.setCode(code);
		user.setState(1);
		User existUser = userService.findByUserCode(code);
		if(existUser!=null){
			userService.saveOrUpdate(user);
			this.addActionMessage("激活成功！请去登录！");
		}else{
			this.addActionMessage("激活失败！激活码错误！");
		}
		return "msg";
		
	}
	/**
	 * 记住用户或密码
	 */
	private String isRememberUsername;
	
	public void setIsRememberUsername(String isRememberUsername) {
		this.isRememberUsername = isRememberUsername;
	}
	/**
	 * 用户登录
	 * @return
	 * @throws IOException
	 */
	public String login(){
		User existUser = userService.findByUserName(user.getUsername());
		if(existUser.getPassword().equals(user.getPassword())){
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			LoginUtils.createCookie(request,response);//这就是我用来实现去记住用户密码功能的一个类，只需要传入reques 和response即可 
			return "index";
		}else{
			this.addActionError("用户或者密码错误！");
			return "loginPage";
		}
	}
	/**
	 * 按名字查找用户
	 * @return
	 * @throws IOException
	 */
	public String findByName() throws IOException{
		User existUser = userService.findByUserName(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		/*response.setHeader("content-type","text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");*/
		PrintWriter out = response.getWriter();
		
		if(existUser!=null){
			out.print("1");
			/*this.addActionError("用户名已经存在！");*/
		}else{
			out.println();
			/*this.addActionError("用户名可以使用！");*/
		}
		return NONE;
	}
	
	/**
	 * 用户退出
	 * @return
	 */
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public User getModel() {
		return user;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
}

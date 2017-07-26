package com.bdqn.entity;
/**
 * 用户实体类
 * @author ll
 *
 */
public class User {
	private int uid;				//用户id
	private String username;	//用户名
	private String password;	//用户密码
	private String name;		//用户姓名
	private String email;		//用户邮箱
	private String phone;		//用户电话
	private String addr;		//用户地址
	private int state;			//用户状态 ：1代表激活 0代表未激活
	private String code;		//用户激活码
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}

package com.bdqn.entity;

/**
 * 后台管理的用户实体类
 * @author ll
 *
 */
public class AdminUser {
	private int uid;		//管理员id
	private String username;//管理员用户名
	private String password;//管理员密码
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
	
}

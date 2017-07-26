package com.bdqn.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * 一级分类实体类
 * @author ll
 *
 */
public class Category {
	private int cid;		//	一级分类的id
	private String cname;	//	一级分类的名称
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
}

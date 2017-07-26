package com.bdqn.web;

import java.util.List;

import com.bdqn.entity.Category;
import com.bdqn.service.categoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	private Category category = new Category();
	
	private categoryService categoryService;
	
	public String findAll(){
		List<Category> cList = categoryService.findAll();
		//显示到页面
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	public String save(){
		categoryService.save(category);
		return "saveSuccess";
	}
	
	public String delete(){
		categoryService.delete(category);
		return "saveSuccess";
	}
	public String edit(){
		return "editSuccess";
	}
	
	@Override
	public Category getModel() {
		return category;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public void setCategoryService(categoryService categoryService) {
		this.categoryService = categoryService;
	}

}

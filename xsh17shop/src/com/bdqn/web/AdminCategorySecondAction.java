package com.bdqn.web;


import java.util.List;

import com.bdqn.common.PageBean;
import com.bdqn.entity.Category;
import com.bdqn.entity.CategorySecond;
import com.bdqn.service.CategorySecondService;
import com.bdqn.service.categoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	private CategorySecond categorySecond = new CategorySecond();
	
	private CategorySecondService categorySecondService;
	
	private categoryService categoryService;
	private Integer page;
	
	public String findAll(){
		PageBean<CategorySecond> pageBean = categorySecondService.findByPage(page);
		//保存到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	public String addPage(){
		List<Category> cList = categoryService.findAll();
		//把数据显示到下拉列表
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPage";
	}
	
	public String save(){
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}
	
	public String delete(){
		//如果是级联删除 先查询再删除 
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	public String edit(){
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		List<Category> cList = categoryService.findAll();
		
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editSuccess";
	}
	
	@Override
	public CategorySecond getModel() {
		return categorySecond;
	}




	public CategorySecond getCategorySecond() {
		return categorySecond;
	}




	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}




	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCategoryService(categoryService categoryService) {
		this.categoryService = categoryService;
	}

}

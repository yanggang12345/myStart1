package com.bdqn.web;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.bdqn.entity.Category;
import com.bdqn.entity.Product;
import com.bdqn.service.ProductService;
import com.bdqn.service.categoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{

	private categoryService categoryService;
	

	private ProductService productService;
	public void setCategoryService(categoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	/**
	 * 首页展示
	 */
	public String execute(){
		
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getSession().put("clist", cList);
		List<Product> hList = productService.findHot();
		//如果热门商品大于十条,则在首页只显示十条
		if(hList.size()>10){
			hList = hList.subList(0, 10);
		}else if(hList.size()>5 && hList.size()<10){
			hList = hList.subList(0, 5);
		}
		
		ActionContext.getContext().getValueStack().set("hList", hList);
		List<Product> nList = productService.findNew();
		//如果最新商品大于十条,则在首页只显示十条
		if(nList.size()>10){
			nList = nList.subList(0, 10);
		}else if(nList.size()>5 && nList.size()<10){
			nList = nList.subList(0, 5);
		}
		ActionContext.getContext().getValueStack().set("nList", nList);
		
		return "index";
		
	}
}

package com.bdqn.web;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.common.PageBean;
import com.bdqn.entity.Category;
import com.bdqn.entity.CategorySecond;
import com.bdqn.entity.Product;
import com.bdqn.service.CategorySecondService;
import com.bdqn.service.ProductService;
import com.bdqn.service.categoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 *	文件名称: ProductAction.java<br>
 *	内容摘要: TODO<br>
 *	创建人　: dongshihua<br>
 *	创建日期: 2017年7月17日<br>
 *	版本号　: <br>
 *	公司　　: <br>
 *	修改记录: <br>
 *	修改日期: <br>
 *	版本号　: <br>
 *	修改人　: <br>
 *	修改内容: <br>
 *
 */

public class ProductAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	private categoryService categoryService;
	public void setCategoryService(categoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	private int cid;
	private int page;
	private int pid;
	private int csid;
	
	private Product model;
	private PageBean<Product> pageBean;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	/**
	 * 
	 * @return
	 */
	public String findByPid(){
		model = productService.findByPid(pid);
		return "findByPid";
	}
	
	/**
	 * 
	 * @return
	 */
	public String findByCid(){
		List<Category> clist = categoryService.findAll();
		ActionContext.getContext().getSession().put("clist", clist);
		
		
		List<CategorySecond> categorySecond = categorySecondService.findByCid(categoryService.findByCid(cid).getCid());
		
		List<Product> list = new ArrayList<>();
		
		for (CategorySecond category : categorySecond) {
			
			
			for (Product product : productService.findByCsid(category.getCsid())) {
				list.add(product);
			}
		}
		
		pageBean = productService.findByPage(page,list);
		
		return "findByCid";
	}
	
	/**
	 * 
	 * @return
	 */
	public String findByCsid(){
		List<Category> clist = categoryService.findAll();
		ActionContext.getContext().getSession().put("clist", clist);
		
		pageBean = productService.findByPage(page,csid);
		
		return "findByCid";
	}
	
	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the pageBean
	 */
	public PageBean<Product> getPageBean() {
		return pageBean;
	}

	/**
	 * @param pageBean the pageBean to set
	 */
	public void setPageBean(PageBean<Product> pageBean) {
		this.pageBean = pageBean;
	}

	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the csid
	 */
	public int getCsid() {
		return csid;
	}

	/**
	 * @param csid the csid to set
	 */
	public void setCsid(int csid) {
		this.csid = csid;
	}

	/**
	 * @return the model
	 */
	public Product getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Product model) {
		this.model = model;
	}
	
}

package com.bdqn.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;
import org.hibernate.sql.Delete;

import com.bdqn.common.PageBean;
import com.bdqn.entity.CategorySecond;
import com.bdqn.entity.Product;
import com.bdqn.service.CategorySecondService;
import com.bdqn.service.ProductService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{

	private Product product = new Product();
	private ProductService productService;
	private CategorySecondService categorySecondService;
	private Integer page;
	//文件上传所需的参数
	private File upload;
	private String uploadFileName;//接收上传的文件名
	private String uploadContentType; //上传的类型
	public String findAll(){
		PageBean<Product> pageBean = productService.findByPage(page);
		//
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//页面跳转
		return "findAll";
	}
	
	public String addPage(){
		List<CategorySecond> csList = categorySecondService.findAll();
		//值栈
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "addPageSuccess";
	}
	
	public String save(){
		/*product.setPdate(new Date());*/
		//文件上传
		if(upload !=null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			File diskFile = new File(realPath +"//"+ uploadFileName);//创建新文件
			try {
				FileUtil.copyFile(upload, diskFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			product.setImage("products"+uploadFileName);
		}
		
		productService.save(product);
		return "saveSuccess";
	}
	
	public String delete(){
		product = productService.findByPid(product.getPid());
		//删除图片
		String path = product.getImage();
		if(path != null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/"+path);
			File file = new File(realPath);
			file.delete();
		}
		
		//删除商品
		productService.delete(product);
		return "editSuccess";
	}

	
	public String edit(){
		product = productService.findByPid(product.getPid());
		
		List<CategorySecond> csList =  categorySecondService.findAll();
		
		ActionContext.getContext().getValueStack().set("csList", csList);
		
		return "editSuccess";
	}
			
			
	@Override
	public Product getModel() {
		return product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}

	public CategorySecondService getCategorySecondService() {
		return categorySecondService;
	}

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

}

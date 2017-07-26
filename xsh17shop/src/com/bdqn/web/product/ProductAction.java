package com.bdqn.web.product;

import com.bdqn.entity.Product;
import com.bdqn.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{

	private Product product=new Product();
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	private ProductService productService;
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	/**
	 * 按商品号查找商品
	 * @return
	 */
	public String findByPid(){
		
		product = productService.findByPid(product.getPid());
		return "product";
		 
	}
}
